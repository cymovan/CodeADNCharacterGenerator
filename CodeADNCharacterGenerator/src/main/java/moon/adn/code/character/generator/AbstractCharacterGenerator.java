package moon.adn.code.character.generator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.archetypes.Archetype;
import moon.adn.code.model.character.AbstractCharacter;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.CharacterFileHelper;
import moon.adn.code.model.character.NPC;
import moon.adn.code.model.character.builder.CaracteristicSpeciesModifiers;
import moon.adn.code.model.character.builder.Modifier;
import moon.adn.code.model.character.builder.SocialOriginSkillsHelper;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.history.CharacterHistory;
import moon.adn.code.model.character.history.CharacterHistoryGenerator;
import moon.adn.code.model.character.identity.Identity;
import moon.adn.code.model.character.identity.JobEnum;
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SocialOriginEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;
import moon.adn.code.model.character.identity.apparence.EyesColorEnum;
import moon.adn.code.model.character.identity.apparence.HairColourEnum;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillValues;
import moon.adn.code.model.character.skills.SkillsSpeciesModifiers;
import moon.adn.code.model.character.specializations.CareerEnum;
import moon.adn.code.model.character.specializations.SpecializationsAtCreation;

/**
 * Builder of {@link Character}.
 * 
 * @author Cédric DELRUE
 *
 */
@Getter
@Setter
public abstract class AbstractCharacterGenerator<T extends AbstractCharacter> implements CharacterGenerator<T> {
	protected final Logger logger = LoggerFactory.getLogger(AbstractCharacterGenerator.class);

	protected static Random random = new SecureRandom();
	// Parameterized random generations
	private Set<SpeciesEnum> selectedSpeciesforRandom = new HashSet<SpeciesEnum>();
	private Optional<SexEnum> selectedSex = Optional.empty();

	protected Identity identity;
	protected Map<CaracteristicEnum, CaractValues> caracteristicsMap = new TreeMap<>();
	protected Map<SkillEnum, SkillValues> skillsMap = new TreeMap<>();
	protected SpecializationsAtCreation speciesSpecializationsAtCreation = new SpecializationsAtCreation();
	protected Map<SpecializationsAtCreation, Integer> specializationChoices = new HashMap<>();
	protected Map<CareerEnum, Integer> careersMapChoosed = new HashMap<>();
	protected SocialOriginEnum socialOriginEnum;
	protected CareerEnum carrerChoosed;

	protected CaracteristicSpeciesModifiers caracteristicsModifiers = new CaracteristicSpeciesModifiers();
	protected SkillsSpeciesModifiers skillsModifiers = new SkillsSpeciesModifiers();

	protected Archetype archetype;

	protected CharacterHistoryGenerator chg;

	protected Set<SkillEnum> skillsToLearn = new HashSet<>();
	protected int skillsPoints = 50;
	protected int hobbiesPoints = 30;

	/**
	 * Build and consolidate Datas of the character.
	 */
	public CharacterHistory buildHistory() {
		Character characterLoaded = CharacterFileHelper.loadCharacter("character");
		chg = new CharacterHistoryGenerator(characterLoaded);
		return chg.generate();
	}

	protected void applySpeciesModifiers() {
		Map<CaracteristicEnum, Modifier> map = caracteristicsModifiers.getModifiersMap();
		for (Map.Entry<CaracteristicEnum, Modifier> entry : map.entrySet()) {
			CaracteristicEnum caract = entry.getKey();
			CaractValues value = caracteristicsMap.get(caract);
			value.applyCaractModifier(map.get(caract));
		}

		if (null != skillsModifiers) {
			int initValue = 0;
			Map<SkillEnum, Modifier> mapSkill = skillsModifiers.getModifiersMap();
			for (Map.Entry<SkillEnum, Modifier> entry : mapSkill.entrySet()) {
				SkillEnum skill = entry.getKey();
				Modifier modifier = mapSkill.get(skill);
				SkillValues values = skillsMap.get(skill);
				if (null != values) {
					initValue = values.getInitScore();
				}
				skillsMap.put(skill, new SkillValues(initValue, initValue, modifier));
			}
		}
	}

	protected void speciesSpecializations() {
		SpeciesEnum species = identity.getSpecies();
		speciesSpecializationsAtCreation = species.getSpecializations();
	}

	protected Identity generateIdentity() {
		Identity tempIdentity = new Identity();

		if (archetype != null) {
			tempIdentity.setJob(archetype.getArchetype().getJob());
		} else if (null != carrerChoosed) {
			tempIdentity.setJob(JobEnum.randomJobUsingRules(carrerChoosed));
		}

		// Species
		SpeciesEnum species;
		if (!selectedSpeciesforRandom.isEmpty()) {
			Set<SpeciesEnum> speciesSet = selectedSpeciesforRandom;
			SpeciesEnum[] tabSpecies = speciesSet.stream().toArray(SpeciesEnum[]::new);
			species = tabSpecies[random.nextInt(tabSpecies.length)];
		} else {
			species = SpeciesEnum.random();
		}

		// Sex
		tempIdentity.setSpecies(species);
		if (selectedSex.isPresent()) {
			tempIdentity.setSex(selectedSex.get());
		} else {
			tempIdentity.setSex(SexEnum.random());
		}

		// Random Age.
		if (SpeciesEnum.HUMAN == species) {
			tempIdentity.setAge(random.nextInt(25, 52));
		} else {
			tempIdentity.setAge(random.nextInt(35, 100));
		}

		// Random Name
		tempIdentity.setName(species.getNamesGenerator().generateCompleteName(tempIdentity.getSex()));

		// Eyes Color
		List<EyesColorEnum> eyesColorsList = EyesColorEnum.getSpeciesEyeColorsList(species);
		Collections.shuffle(eyesColorsList);
		tempIdentity.setEyeColor(eyesColorsList.stream().findFirst().orElse(null));

		// Hairs Color
		List<HairColourEnum> hairColorlist = HairColourEnum.getSpeciesHairColorsList(species);
		Collections.shuffle(hairColorlist);
		tempIdentity.setHairColor(hairColorlist.stream().findFirst().orElse(null));

		// Social Origin
		socialOriginEnum = SocialOriginEnum.randomSocialOrigin();
		tempIdentity.setSocialOrigin(socialOriginEnum.getSocialOriginValue());
		return tempIdentity;
	}

	protected void caracteristicSpeciesModifiers() {
		caracteristicsModifiers = getIdentity().getSpecies().getCaractModifiers();
	}

	protected void skillsSpeciesModifiers() {
		SkillsSpeciesModifiers ssm = getIdentity().getSpecies().getSkillModifiers();
		if (null != ssm) {
			skillsModifiers = ssm;
		}
	}

	protected void socialOriginSkillsInit() {
		SocialOriginSkillsHelper socOriginHelp = new SocialOriginSkillsHelper();
		socOriginHelp.initSocialSkills(socialOriginEnum);
		skillsMap = socOriginHelp.getInitSkillMap();
	}

	public T buildFromArchetype(Archetype archetype) {
		// TODO : A revoir.
		return null;
	}

	/**
	 * Template code for {@link Character}, {@link NPC}...
	 * 
	 * @param character
	 */
	protected void commonBuild(T character) {
		// Build character using creation rules.
		this.setIdentity(generateIdentity());
		caracteristicSpeciesModifiers();
		socialOriginSkillsInit();
		skillsSpeciesModifiers();
		speciesSpecializations();
		applySpeciesModifiers();

		character.setIdentity(this.identity);
		character.setCaracteristicsMap(caracteristicsMap);
		character.setSkillsMap(skillsMap);

		// Add default Specializations
		if (null != speciesSpecializationsAtCreation) {
			character.setSpecializations(speciesSpecializationsAtCreation.getSpecializationsMap());
		}
	}

	protected void commonBuildWithTemplate(T character, Archetype archetype) {
		caracteristicsMap = archetype.getArchetype().getCaracteristicsMap();
		for (SkillEnum skill : archetype.getArchetype().getSkillsToLearn()) {
			skillsMap.put(skill, new SkillValues());
		}
		this.archetype = archetype;
		commonBuild(character);
	}

	protected void populateFromSkillToLearn(T character) {
		for (Iterator<SkillEnum> iterator = skillsToLearn.iterator(); iterator.hasNext();) {
			SkillEnum skillEnum = iterator.next();
			SkillValues value = character.getSkillsMap().get(skillEnum);
			if (null == value) {
				character.getSkillsMap().put(skillEnum, new SkillValues(0));
			}
		}
	}

	protected void spendSkillsPoints(int sPoints, int maxScore) {
		skillsPoints = sPoints;
		int countMaxScore = 0;

		if (skillsPoints == 0) {
			return;
		}

		List<SkillEnum> skillsLearn = new ArrayList<>(skillsMap.keySet());
		Collections.shuffle(skillsLearn);

		int maxLoop = 4;
		int loop = 0;

		while (loop < maxLoop && skillsPoints > 0) {
			for (SkillEnum skill : skillsLearn) {
				SkillValues value = skillsMap.get(skill);
				int currentValue = value.getCurrentScore();

				if (currentValue < maxScore) {
					int choice = calculateChoice(currentValue, maxScore);
					updateSkillsPoints(choice, skillsPoints);
					int score = currentValue + choice;
					logger.trace("{}: {} : {} - random : {}", identity.getName(), skill, currentValue, choice);
					value.setCurrentScore(score);

					if (checkMaxScoreCondition(maxScore, countMaxScore)) {
						maxScore--;
						addRandomSkill();
					}
				} else {
					addRandomSkill();
				}
			}
			loop++;
		}
		logger.trace("{}: Skills count : {}", identity.getName(), skillsMap.size());
	}

	private int calculateChoice(int currentValue, int maxScore) {
		int choice = 0;
		while (choice == 0 || currentValue + choice > maxScore) {
			choice = random.nextInt(maxScore);
		}
		return choice;
	}

	private void updateSkillsPoints(int choice, int skillsPoints) {
		if (choice < skillsPoints) {
			skillsPoints -= choice;
		} else {
			skillsPoints = 0;
		}
	}

	private boolean checkMaxScoreCondition(int maxScore, int countMaxScore) {
		if (maxScore > 3 && countMaxScore == 3) {
			countMaxScore = 0;
			return true;
		}
		return false;
	}

	private void addRandomSkill() {
		SkillEnum randomSkill = null;
		while (randomSkill == null) {
			randomSkill = SkillEnum.randomOnlyPossibleSkills();
			if (getSkillsMap().get(randomSkill) == null) {
				randomSkill = null;
			}
		}
		getSkillsMap().put(randomSkill, new SkillValues());
	}

	protected void spendHobbyPoints(T character, int sPoints, int maxScore) {
		initCommonUsefullSkillsToLearn();
		populateFromSkillToLearn(character);
		spendSkillsPoints(sPoints, maxScore);
	}

	protected void initCommonUsefullSkillsToLearn() {
		skillsToLearn.add(SkillEnum.SEE);
		skillsToLearn.add(SkillEnum.LISTEN);
		skillsToLearn.add(SkillEnum.HUMAN_PERCEPTION);
		skillsToLearn.add(SkillEnum.GUNS);
		skillsToLearn.add(SkillEnum.HUMAN_PERCEPTION);
		skillsToLearn.add(SkillEnum.BIBLIO);
		skillsToLearn.add(SkillEnum.DISGUISE);
		skillsToLearn.add(SkillEnum.CHAT);
		skillsToLearn.add(SkillEnum.COMEDY);
		skillsToLearn.add(SkillEnum.BARGAIN);
		skillsToLearn.add(SkillEnum.BRAWL);
		skillsToLearn.add(SkillEnum.DODGE);
		skillsToLearn.add(SkillEnum.SNEAK);
		skillsToLearn.add(SkillEnum.ATHLETISM);
		skillsToLearn.add(SkillEnum.MARTIAL_ART);
		skillsToLearn.add(SkillEnum.SNEAK);
		skillsToLearn.add(SkillEnum.TRACKING);
	}

	protected void defineCareerAndHobbiesPointsWithoutMystic(Character character) {
		character.setCaracteristicsMap(this.caracteristicsMap);
		this.carrerChoosed = CareerEnum.random();
		while (CareerEnum.MYSTIC == this.carrerChoosed) {
			this.carrerChoosed = CareerEnum.random();
		}
		this.hobbiesPoints = CareerEnum.getHobbiesPoints(carrerChoosed, character);
		// Add first careerEnum
		careersMapChoosed.put(carrerChoosed, 1);
		character.setCareersMap(careersMapChoosed);
	}

	protected void defineCareerAndHobbiesPointsWithoutMystic(Character character, Archetype archetype) {
		character.setCaracteristicsMap(archetype.getArchetype().getCaracteristicsMap());
		this.carrerChoosed = archetype.getArchetype().getMaincareer();
		this.hobbiesPoints = CareerEnum.getHobbiesPoints(carrerChoosed, character);
		// Add first careerEnum
		careersMapChoosed.put(carrerChoosed, 1);
		character.setCareersMap(careersMapChoosed);
	}

	@Override
	public T buildFromParameters(CharacterParameters params) {
		throw new NotImplementedException("Not implemented yet !");
	}
}
