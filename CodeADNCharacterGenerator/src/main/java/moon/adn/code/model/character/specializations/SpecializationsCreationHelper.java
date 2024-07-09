package moon.adn.code.model.character.specializations;

import static moon.adn.code.model.character.specializations.SpecializationEnum.ANIMAL_COMMUNICATION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.ANIMAL_EMPATHY;
import static moon.adn.code.model.character.specializations.SpecializationEnum.ANIMATION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.AQUATIC_GRACE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.AQUATIC_VIBES;
import static moon.adn.code.model.character.specializations.SpecializationEnum.CHARISMA;
import static moon.adn.code.model.character.specializations.SpecializationEnum.CHARM;
import static moon.adn.code.model.character.specializations.SpecializationEnum.CLIMBING;
import static moon.adn.code.model.character.specializations.SpecializationEnum.COLD_RESISTANCE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.CONJURING_SPIRITS;
import static moon.adn.code.model.character.specializations.SpecializationEnum.DISEASES_RESIST;
import static moon.adn.code.model.character.specializations.SpecializationEnum.DIVE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.EMOTIONS_CONCEALMENT;
import static moon.adn.code.model.character.specializations.SpecializationEnum.GUNSLINGER;
import static moon.adn.code.model.character.specializations.SpecializationEnum.HIDE_IN_SHADOWS;
import static moon.adn.code.model.character.specializations.SpecializationEnum.HYPNOTIZE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.INFRAVISION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.INVENTION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.LIGHT_AMPLI_VISION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.LOCAL_ECONOMY;
import static moon.adn.code.model.character.specializations.SpecializationEnum.LOOK;
import static moon.adn.code.model.character.specializations.SpecializationEnum.MEDICINAL_PLANTS;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PAIN_RESIST;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PRECISION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PSYCHOLOGY;
import static moon.adn.code.model.character.specializations.SpecializationEnum.SPIRIT_NATURE_COMMUNICATION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.STYLE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.URBAN_DISCRETION;
import static moon.adn.code.system.RandomDiceUtil.d100;

import java.util.EnumMap;
import java.util.Map;

import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * Helper creating {@link SpecializationsAtCreation} depending on
 * {@link SpeciesEnum}.
 * 
 * @author Cédric DELRUE
 *
 */
public class SpecializationsCreationHelper {

	public static SpecializationsAtCreation sylvanElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new EnumMap<>(
				SpecializationEnum.class);
		specializationsMap.put(CLIMBING, getValues(CLIMBING, 2));
		specializationsMap.put(PRECISION, getValues(PRECISION, 2));
		specializationsMap.put(MEDICINAL_PLANTS, getValues(MEDICINAL_PLANTS, 2));
		specializationsMap.put(ANIMAL_EMPATHY, getValues(ANIMAL_EMPATHY, 2));
		specializationsMap.put(LIGHT_AMPLI_VISION, getValues(LIGHT_AMPLI_VISION, 1));
		if (d100() <= 25) {
			specializationsMap.put(ANIMAL_COMMUNICATION, getValues(ANIMAL_COMMUNICATION, 2));
		}
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation urbanElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new EnumMap<>(
				SpecializationEnum.class);
		specializationsMap.put(LOOK, getValues(LOOK, 2));
		specializationsMap.put(STYLE, getValues(STYLE, 2));
		specializationsMap.put(GUNSLINGER, getValues(GUNSLINGER, 2));
		specializationsMap.put(LOCAL_ECONOMY, getValues(LOCAL_ECONOMY, 1));
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation paleElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new EnumMap<>(
				SpecializationEnum.class);
		specializationsMap.put(LIGHT_AMPLI_VISION, getValues(LIGHT_AMPLI_VISION, 1));
		if (d100() <= 30) {
			specializationsMap.put(HYPNOTIZE, getValues(HYPNOTIZE, 1));
		}
		if (d100() <= 50) {
			specializationsMap.put(ANIMAL_COMMUNICATION, getValues(ANIMAL_COMMUNICATION, 2));
		}
		specializationsMap.put(PSYCHOLOGY, getValues(PSYCHOLOGY, 4));
		specializationsMap.put(CHARM, getValues(CHARM, 1));
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation greyElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new EnumMap<>(
				SpecializationEnum.class);
		specializationsMap.put(INFRAVISION, getValues(INFRAVISION, 1));
		specializationsMap.put(LIGHT_AMPLI_VISION, getValues(LIGHT_AMPLI_VISION, 1));
		if (d100() <= 75) {
			specializationsMap.put(ANIMAL_COMMUNICATION, getValues(ANIMAL_COMMUNICATION, 3));
		}
		if (d100() <= 5) {
			specializationsMap.put(SPIRIT_NATURE_COMMUNICATION, getValues(SPIRIT_NATURE_COMMUNICATION, 4));
		}
		specializationsMap.put(ANIMATION, getValues(ANIMATION, 2));
		specializationsMap.put(INVENTION, getValues(INVENTION, 4));
		specializationsMap.put(CHARISMA, getCareerValues(CHARISMA, 2, 1));
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation goldElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new EnumMap<>(
				SpecializationEnum.class);
		specializationsMap.put(INFRAVISION, getValues(INFRAVISION, 1));
		specializationsMap.put(LIGHT_AMPLI_VISION, getValues(LIGHT_AMPLI_VISION, 1));
		specializationsMap.put(ANIMAL_COMMUNICATION, getValues(ANIMAL_COMMUNICATION, 4));
		specializationsMap.put(SPIRIT_NATURE_COMMUNICATION, getValues(SPIRIT_NATURE_COMMUNICATION, 3));
		if (d100() <= 5) {
			specializationsMap.put(CONJURING_SPIRITS, getValues(CONJURING_SPIRITS, 2));
		}
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation nightElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new EnumMap<>(
				SpecializationEnum.class);
		specializationsMap.put(LIGHT_AMPLI_VISION, getValues(LIGHT_AMPLI_VISION, 1));
		specializationsMap.put(DISEASES_RESIST, getValues(DISEASES_RESIST, 5));
		specializationsMap.put(COLD_RESISTANCE, getValues(COLD_RESISTANCE, 1));
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation aquaticElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new EnumMap<>(
				SpecializationEnum.class);
		specializationsMap.put(INFRAVISION, getValues(INFRAVISION, 1));
		specializationsMap.put(DIVE, getValues(DIVE, 4));
		specializationsMap.put(AQUATIC_GRACE, getValues(AQUATIC_GRACE, 4));
		specializationsMap.put(AQUATIC_VIBES, getValues(AQUATIC_VIBES, 4));
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation darkElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new EnumMap<>(
				SpecializationEnum.class);
		specializationsMap.put(INFRAVISION, getValues(INFRAVISION, 1));
		specializationsMap.put(URBAN_DISCRETION, getValues(URBAN_DISCRETION, 2));
		specializationsMap.put(HIDE_IN_SHADOWS, getValues(HIDE_IN_SHADOWS, 4));
		specializationsMap.put(EMOTIONS_CONCEALMENT, getValues(EMOTIONS_CONCEALMENT, 2));
		specializationsMap.put(PAIN_RESIST, getValues(PAIN_RESIST, 2));
		return new SpecializationsAtCreation(specializationsMap);
	}

	private static SpecializationValuesAbstract getValues(SpecializationEnum specEnum, int boxesChecked) {
		SpecializationValuesAbstract values = specEnum.getSpecializationValues();
		values.setBoxesChecked(boxesChecked);
		return values;
	}

	private static SpecializationValuesAbstract getCareerValues(SpecializationEnum specEnum, int segmentsChecked,
			int boxesChecked) {
		SpecializationValuesAbstract values = specEnum.getSpecializationValues();
		values.setBoxesChecked(boxesChecked);
		values.setSegmentsChecked(segmentsChecked);
		return values;
	}
}
