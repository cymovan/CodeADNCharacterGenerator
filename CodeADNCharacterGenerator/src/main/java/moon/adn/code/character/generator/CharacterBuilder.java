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
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.CharacterFileHelper;
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
public class CharacterBuilder {
	private static Random random = new Random();

	private Identity identity;

	// Parameterized random generations
	private Optional<Set<SpeciesEnum>> selectedSpeciesforRandom = Optional.empty();
	private Optional<SexEnum> selectedSex = Optional.empty();

	private Map<CaracteristicEnum, CaractValues> caracteristicsMap = new TreeMap<>();
	private Map<SkillEnum, SkillValues> skillsMap = new TreeMap<>();
	private SpecializationsAtCreation speciesSpecializations = new SpecializationsAtCreation();
	private Map<SpecializationsAtCreation, Integer> specializationChoices = new HashMap<>();
	private SocialOriginEnum socialOriginEnum;

	private CaracteristicSpeciesModifiers caracteristicsModifiers = new CaracteristicSpeciesModifiers();
	private SkillsSpeciesModifiers skillsModifiers = new SkillsSpeciesModifiers();

	private CharacterHistoryGenerator chg;

	/**
	 * Build and consolidate Datas of the character.
	 */
	public Character build() {
		// Build character using creation rules.
		this.setIdentity(generateIdentity());
		caracteristicSpeciesModifiers();
		socialOriginSkillsInit();
		skillsSpeciesModifiers();
		speciesSpecializations();
		applySpeciesModifiers();

		// Generate final character with simplified values
		Character character = new Character();
		character.setIdentity(this.identity);
		character.setCaracteristicsMap(caracteristicsMap);
		character.setSkillsMap(skillsMap);

		// Add default Specializations
		if (null != speciesSpecializations) {
			character.setSpecializations(speciesSpecializations.getSpecializationsMap());
		}
		// Events
		chg = new CharacterHistoryGenerator(character);
		CharacterHistory ch = chg.generate();
		character.setEventsMap(ch.getEventsMap());
		character.setRaecMap(ch.getRaecMap());

		CharacterFileHelper.saveCharacter(character);
		return character;
	}

	/**
	 * Build and consolidate Datas of the character.
	 */
	public CharacterHistory buildHistory() {
		Character characterLoaded = CharacterFileHelper.loadCharacter("character");
		chg = new CharacterHistoryGenerator(characterLoaded);
		return chg.generate();
	}

	private void applySpeciesModifiers() {
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

	private void speciesSpecializations() {
		SpeciesEnum species = identity.getSpecies();
		speciesSpecializations = species.getSpecializations();
	}

	private Identity generateIdentity() {
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

	private void caracteristicSpeciesModifiers() {
		caracteristicsModifiers = getIdentity().getSpecies().getCaractModifiers();
	}

	private void skillsSpeciesModifiers() {
		SkillsSpeciesModifiers ssm = getIdentity().getSpecies().getSkillModifiers();
		if (null != ssm) {
			skillsModifiers = ssm;
		}
	}

	private void socialOriginSkillsInit() {
		SocialOriginSkillsHelper socOriginHelp = new SocialOriginSkillsHelper();
		socOriginHelp.initSocialSkills(socialOriginEnum);
		skillsMap = socOriginHelp.getInitSkillMap();
	}
}
