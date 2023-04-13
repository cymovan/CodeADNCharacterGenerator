package moon.adn.code.model.character.specializations;

import static moon.adn.code.system.RandomDiceUtil.*;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

import static moon.adn.code.model.character.specializations.SpecializationEnum.*;

@Data
public class SpecializationsCreationHelper {

	public static SpecializationsAtCreation sylvanElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new HashMap<>();
		specializationsMap.put(CLIMBING, getValues(CLIMBING, 2));
		specializationsMap.put(PRECISION, getValues(PRECISION, 2));
		specializationsMap.put(MEDICINAL_PLANTS, getValues(MEDICINAL_PLANTS, 2));
		specializationsMap.put(ANIMAL_EMPATHY, getValues(ANIMAL_EMPATHY, 2));
		if (d100() <= 50) {
			specializationsMap.put(ANIMAL_COMMUNICATION, getValues(ANIMAL_COMMUNICATION, 2));
		}
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation urbanElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new HashMap<>();
		specializationsMap.put(LOOK, getValues(LOOK, 2));
		specializationsMap.put(STYLE, getValues(STYLE, 2));
		specializationsMap.put(GUNSLINGER, getValues(GUNSLINGER, 2));
		specializationsMap.put(LOCAL_ECONOMY, getValues(LOCAL_ECONOMY, 1));
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation paleElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new HashMap<>();
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
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new HashMap<>();
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
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new HashMap<>();
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
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new HashMap<>();
		specializationsMap.put(LIGHT_AMPLI_VISION, getValues(LIGHT_AMPLI_VISION, 1));
		specializationsMap.put(DISEASES_RESIST, getValues(DISEASES_RESIST, 5));
		specializationsMap.put(COLD_RESISTANCE, getValues(COLD_RESISTANCE, 1));
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation aquaticElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new HashMap<>();
		specializationsMap.put(INFRAVISION, getValues(INFRAVISION, 1));
		specializationsMap.put(DIVE, getValues(DIVE, 4));
		specializationsMap.put(AQUATIC_GRACE, getValues(AQUATIC_GRACE, 4));
		specializationsMap.put(AQUATIC_VIBES, getValues(AQUATIC_VIBES, 4));
		return new SpecializationsAtCreation(specializationsMap);
	}

	public static SpecializationsAtCreation darkElfSpecializations() {
		Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new HashMap<>();
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
