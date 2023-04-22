package moon.adn.code.character.generator;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;
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
	protected static Random random = new Random();

	// Parameterized random generations
	private Optional<Set<SpeciesEnum>> selectedSpeciesforRandom = Optional.empty();
	private Optional<SexEnum> selectedSex = Optional.empty();

	protected Identity identity;
	protected Map<CaracteristicEnum, CaractValues> caracteristicsMap = new TreeMap<>();
	protected Map<SkillEnum, SkillValues> skillsMap = new TreeMap<>();
	protected SpecializationsAtCreation speciesSpecializations = new SpecializationsAtCreation();
	protected Map<SpecializationsAtCreation, Integer> specializationChoices = new HashMap<>();
	protected SocialOriginEnum socialOriginEnum;

	protected CaracteristicSpeciesModifiers caracteristicsModifiers = new CaracteristicSpeciesModifiers();
	protected SkillsSpeciesModifiers skillsModifiers = new SkillsSpeciesModifiers();

	protected CharacterHistoryGenerator chg;

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

	/**
	 * Template code for {@link Character}, {@link NPC}...
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
}
