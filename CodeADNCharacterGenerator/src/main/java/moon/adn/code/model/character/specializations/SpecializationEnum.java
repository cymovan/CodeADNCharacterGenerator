package moon.adn.code.model.character.specializations;

import static moon.adn.code.model.character.specializations.SpecializationCategoryEnum.FIGHTER;
import static moon.adn.code.model.character.specializations.SpecializationCategoryEnum.GENERAL;
import static moon.adn.code.model.character.specializations.SpecializationCategoryEnum.MYSTIC;
import static moon.adn.code.model.character.specializations.SpecializationCategoryEnum.SPY;

import lombok.Getter;

/**
 * @author cdelr
 *
 */
public enum SpecializationEnum {
	// General Specializations.
	ANIMATION(GENERAL), LOOK(GENERAL), ARMORY_BLADES(GENERAL), ARMORY_FIRE_ARMS(GENERAL), ARMORY_ARMOR(GENERAL),
	KNOCK_OUT(GENERAL), HUCKSTER(GENERAL), CHARM(GENERAL), BODY_DEV(GENERAL), AMBUSH(GENERAL), ANIMAL_EMPATHY(GENERAL),
	TIE_KNOTS(GENERAL), BODYBUILDING(GENERAL), AQUATIC_GRACE(GENERAL), STYLE(GENERAL), INFLUENCE(GENERAL),
	INFRAVISION(GENERAL), NEGOTIATION(GENERAL), DEVELOPED_SMELL_SENSE(GENERAL), DIVE(GENERAL), PAIN_RESIST(GENERAL),
	DRUGS_RESIST(GENERAL), DISEASES_RESIST(GENERAL), SURVIVE_IN_HOSTILE(GENERAL), LIGHT_AMPLI_VISION(GENERAL),

	// Figther Specializations.

	PRECISE_SHOT(FIGHTER), LOCAL_ECONOMY(SPY),

	// Mystic SPécializations.
	ANIMAL_COMMUNICATATION(MYSTIC), SPIRIT_NATURE_COMMUNICATION(MYSTIC), INNER_STRENGTH(MYSTIC),
	HOT_COLD_IMMUNITY(MYSTIC), SUMMON_NATURE_SPIRIT(MYSTIC), MEDITATION(MYSTIC), HEAT_RESISTANCE(MYSTIC),
	COLD_RESISTANCE(MYSTIC);

	private @Getter SpecializationCategoryEnum specializationCategory;

	SpecializationEnum(SpecializationCategoryEnum specializationCategory) {
		this.specializationCategory = specializationCategory;
	}

}
