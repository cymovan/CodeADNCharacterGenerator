package moon.adn.code.character.generator;

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
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SocialOriginEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;
import moon.adn.code.model.character.identity.apparence.EyesColorEnum;
import moon.adn.code.model.character.identity.apparence.HairColourEnum;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillValues;
import moon.adn.code.model.character.skills.SkillsSpeciesModifiers;
import moon.adn.code.model.character.specializations.CarreerEnum;
import moon.adn.code.model.character.specializations.SpecializationsAtCreation;

/**
 * Builder of {@link Character}.
 * 
 * @author cdelr
 *
 */
@Getter
@Setter
public abstract class AbstractCharacterGenerator<Clazz extends AbstractCharacter> implements CharacterGenerator<Clazz> {
	protected final Logger logger = LoggerFactory.getLogger(AbstractCharacterGenerator.class);

	protected static Random random = new Random();
	protected int hobbiesPoints = 30;

	// Parameterized random generations
	private Optional<Set<SpeciesEnum>> selectedSpeciesforRandom = Optional.empty();
	private Optional<SexEnum> selectedSex = Optional.empty();

	protected Identity identity;
	protected Map<CaracteristicEnum, CaractValues> caracteristicsMap = new TreeMap<>();
	protected Map<SkillEnum, SkillValues> skillsMap = new TreeMap<>();
	protected SpecializationsAtCreation speciesSpecializations = new SpecializationsAtCreation();
	protected Map<SpecializationsAtCreation, Integer> specializationChoices = new HashMap<>();
	protected Map<CarreerEnum, Integer> carreersMapChoosed = new HashMap<>();
	protected SocialOriginEnum socialOriginEnum;
	protected CarreerEnum carrerChoosed;

	protected CaracteristicSpeciesModifiers caracteristicsModifiers = new CaracteristicSpeciesModifiers();
	protected SkillsSpeciesModifiers skillsModifiers = new SkillsSpeciesModifiers();

	protected Archetype archetype;

	protected CharacterHistoryGenerator chg;

	protected Set<SkillEnum> skillsToLearn = new HashSet<>();
	protected int skillsPoints = 50;

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
		for (CaracteristicEnum caract : map.keySet()) {
			CaractValues value = caracteristicsMap.get(caract);
			value.applyCaractModifier(map.get(caract));
		}

		if (null != skillsModifiers) {
			int initValue = 0;
			Map<SkillEnum, Modifier> mapSkill = skillsModifiers.getModifiersMap();
			for (SkillEnum skill : mapSkill.keySet()) {
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
		speciesSpecializations = species.getSpecializations();
	}

	protected Identity generateIdentity() {
		Identity identity = new Identity();

		if (archetype != null) {
			identity.setJob(archetype.getArchetype().getJob());
		}

		// Species
		SpeciesEnum species;
		if (selectedSpeciesforRandom.isPresent()) {
			Set<SpeciesEnum> speciesSet = selectedSpeciesforRandom.get();
			SpeciesEnum[] tabSpecies = speciesSet.stream().toArray(SpeciesEnum[]::new);
			species = tabSpecies[random.nextInt(tabSpecies.length)];
		} else {
			species = SpeciesEnum.random();
		}

		// Sex
		identity.setSpecies(species);
		if (selectedSex.isPresent()) {
			identity.setSex(selectedSex.get());
		} else {
			identity.setSex(SexEnum.random());
		}

		// Random Age.
		if (SpeciesEnum.HUMAN == species) {
			identity.setAge(random.nextInt(25, 52));
		} else {
			identity.setAge(random.nextInt(35, 100));
		}

		// Random Name
		identity.setName(species.getNamesGenerator().generateCompleteName(identity.getSex()));

		// Eyes Color
		List<EyesColorEnum> eyesColorsList = EyesColorEnum.getSpeciesEyeColorsList(species);
		Collections.shuffle(eyesColorsList);
		identity.setEyeColor(eyesColorsList.stream().findFirst().orElse(null));

		// Hairs Color
		List<HairColourEnum> hairColorlist = HairColourEnum.getSpeciesHairColorsList(species);
		Collections.shuffle(hairColorlist);
		identity.setHairColor(hairColorlist.stream().findFirst().orElse(null));

		// Social Origin
		socialOriginEnum = SocialOriginEnum.randomSocialOrigin();
		identity.setSocialOrigin(socialOriginEnum.getSocialOriginValue());
		return identity;
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

	public abstract Clazz build();

	public Clazz buildFromArchetype(Archetype archetype) {
		// TODO : A revoir.
		return null;
	}

	/**
	 * Template code for {@link Character}, {@link NPC}...
	 * 
	 * @param character
	 */
	protected void commonBuild(Clazz character) {
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
		if (null != speciesSpecializations) {
			character.setSpecializations(speciesSpecializations.getSpecializationsMap());
		}
	}

	protected void commonBuildWithTemplate(Clazz character, Archetype archetype) {
		caracteristicsMap = archetype.getArchetype().getCaracteristicsMap();
		for (SkillEnum skill : archetype.getArchetype().getSkillsToLearn()) {
			skillsMap.put(skill, new SkillValues());
		}
		this.archetype = archetype;
		commonBuild(character);
	}

	protected void populateFromSkillToLearn(Clazz character) {
		for (Iterator<SkillEnum> iterator = skillsToLearn.iterator(); iterator.hasNext();) {
			SkillEnum skillEnum = iterator.next();
			SkillValues value = character.getSkillsMap().get(skillEnum);
			if (null == value) {
				character.getSkillsMap().put(skillEnum, new SkillValues(0));
			}
		}
	}

	protected void spendSkillsPoints(int sPoints, int maxScore) {
		if (sPoints != 0) {
			skillsPoints = sPoints;
		}
		List<SkillEnum> skillsLearn = new ArrayList<>();
		skillsLearn.addAll(skillsMap.keySet());
		Collections.shuffle(skillsLearn);
		final int maxLoop = 4;
		int loop = 0;
		int countMaxScore = 0;
		while (loop++ < maxLoop && skillsPoints != 0) {
			for (SkillEnum skill : skillsLearn) {
				SkillValues value = getSkillsMap().get(skill);
				int currentValue = value.getCurrentScore();
				int choice = 0;
				if (skillsPoints == 0) {
					loop = maxLoop;
					break;
				}
				if (currentValue >= maxScore) {
					addRandomSkill();
				} else {
					// Avoid skillScore up to maxScore allowed
					while (choice == 0) {
						if (currentValue < maxScore) {
							choice = random.nextInt(maxScore);
							if (currentValue + choice > maxScore) {
								choice = 0;
							}
						}
					}
					if (choice == maxScore) {
						countMaxScore++;
					}
					if (countMaxScore == 3 && maxScore > 3) {
						countMaxScore = 0;
						maxScore--;
						addRandomSkill();
					}
					if (choice < skillsPoints) {
						skillsPoints -= choice;
					} else {
						choice = skillsPoints;
						skillsPoints = 0;
					}
					int score = currentValue + choice;
					logger.info(identity.getName() + ": " + skill + " : " + currentValue + " - random : " + choice);
					value.setCurrentScore(score);
				}
			}
		}
		logger.info(identity.getName() + ": Nb Compétences : " + getSkillsMap().size());
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

	protected void spendHobbyPoints(Clazz character, int sPoints, int maxScore) {
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

	protected void defineCarrerAndHobbiesPointsWithoutMystic(Character character, CarreerEnum... carreer) {
		if (null == carreer) {
			while (CarreerEnum.MYSTIC == this.carrerChoosed) {
				this.carrerChoosed = CarreerEnum.random();
			}
			this.hobbiesPoints = CarreerEnum.getHobbiesPoints(carrerChoosed, character);
			// Add first CarreerEnum
			carreersMapChoosed.put(carrerChoosed, 1);
			character.setCarreersMap(carreersMapChoosed);
		}
	}
}
