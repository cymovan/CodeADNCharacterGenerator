package moon.adn.code.model.character.specializations;

import static moon.adn.code.model.character.specializations.CarreerEnum.FIGHTER;
import static moon.adn.code.model.character.specializations.CarreerEnum.GENERAL;
import static moon.adn.code.model.character.specializations.CarreerEnum.MYSTIC;
import static moon.adn.code.model.character.specializations.CarreerEnum.SCIENTIST;
import static moon.adn.code.model.character.specializations.CarreerEnum.SPY;

import lombok.Getter;

/**
 * @author cdelr
 *
 */
public enum SpecializationEnum {
	// General Specializations.
	ANIMATION(GENERAL), LOOK(GENERAL, new StandardSpecializationValues(5)), ARMORY_BLADES(GENERAL),
	ARMORY_FIRE_ARMS(GENERAL), ARMORY_ARMOR(GENERAL), KNOCK_OUT(GENERAL), HUCKSTER(GENERAL), CHARM(GENERAL),
	BODY_DEV(GENERAL), AMBUSH(GENERAL, new BooleanSpecializationValues()), ANIMAL_EMPATHY(GENERAL),
	TIE_KNOTS(GENERAL, new BooleanSpecializationValues()), BODYBUILDING(GENERAL), AQUATIC_GRACE(GENERAL, true),
	STYLE(GENERAL), INFLUENCE(GENERAL), INFRAVISION(GENERAL, new BooleanSpecializationValues(), true),
	NEGOTIATION(GENERAL), DEVELOPED_SMELL_SENSE(GENERAL), DIVE(GENERAL, true), PAIN_RESIST(GENERAL),
	DRUGS_RESIST(GENERAL), DISEASES_RESIST(GENERAL, new StandardSpecializationValues(5), true),
	SURVIVE_IN_HOSTILE(GENERAL), LIGHT_AMPLI_VISION(GENERAL, true),

	// Figther Specializations.
	// TODO : Add specific weapons
	HEAVY_WEAPONS(FIGHTER), MARTIAL_ART_HANSHI(FIGHTER), MARTIAL_ART_RENSHI(FIGHTER), SHIELD_TECHNICS(FIGHTER),
	BLIND_FIGHT(FIGHTER), PRECISE_HIT(FIGHTER), DEMOLITION(FIGHTER), RIFLEMAN(FIGHTER), GRENADES(FIGHTER),
	NANO_BLADES(FIGHTER), PARRY(FIGHTER), GUNSLINGER(FIGHTER), SNIPER(FIGHTER), TWO_HANDED_CUTTERS(FIGHTER),

	// Scientific specializations
	SYS_ADMIN(SCIENTIST), ALLOYS(SCIENTIST), ANTHROPOLOGY(SCIENTIST), ASTROPHYSIC(SCIENTIST),
	// TODO : ADD Compilations, Cybernetic Generation
	CRIMINOLOGY(SCIENTIST), CRYPTOGRAPHY(SCIENTIST), CYBER_MAPPER(SCIENTIST), GENETIC(SCIENTIST), HARDWARE(SCIENTIST),
	INVENTION(SCIENTIST, new ComplexSpecializationValues(2)),
	MEDECINE_SPECIALIZATION(SCIENTIST, new StandardSpecializationValues(8)), CONNECTED_OBJECTS(SCIENTIST),
	MEDICINAL_PLANTS(SCIENTIST), PHYSIOLOGY_HUMAN(SCIENTIST), PHYSIOLOGY_SEPHONILEANDIS(SCIENTIST),
	PHYSIOLOGY_SELOPHRETALS(SCIENTIST), PHYSIOLOGY_SEPHONILESILA(SCIENTIST), PHYSIOLOGY_SELOPHYLERS(SCIENTIST),
	PHYSIOLOGY_BARARS(SCIENTIST), PHYSIOLOGY_DHARAKS(SCIENTIST), PSYCHIATRY(SCIENTIST), PSYCHOLOGY(SCIENTIST),

	// Spy Specializations
	ROAD_ACE(SPY), CAMOUFLAGE(SPY), URBAN_DISCRETION(SPY), RURAL_DISCRETION(SPY), HIDE_IN_SHADOWS(SPY),
	EMOTIONS_CONCEALMENT(SPY), LOCAL_ECONOMY(SPY), BALANCE(SPY), CLIMBING(SPY), SURVEILLANCE_TAILING(SPY),
	FACE_DISGUISE(SPY), HACKING(SPY), INVESTIGATION(SPY), MANIPULATION(SPY),
	FAKE_DEATH(SPY, new ComplexSpecializationValues(1)), SILENT_KILL(SPY), PARKOUR(SPY), MASTER_LOCK_PICKING(SPY),
	// TODO : POISONS<XXXX>
	PRECISION(SPY), PRESTIDIGITATION(SPY), IMAGE_EDITING(SPY), SURVEILLANCE(SPY), AQUATIC_VIBES(SPY, true),

	// Mystic Specializations.
	ANIMAL_COMMUNICATION(MYSTIC, true), SPIRIT_NATURE_COMMUNICATION(MYSTIC, true), INNER_STRENGTH(MYSTIC),
	HOT_COLD_IMMUNITY(MYSTIC, true), SUMMON_NATURE_SPIRIT(MYSTIC, true), MEDITATION(MYSTIC),
	HEAT_RESISTANCE(MYSTIC, true), COLD_RESISTANCE(MYSTIC, true),

	// Species specialization
	HYPNOTIZE(MYSTIC, new BooleanSpecializationValues(), true),
	CONJURING_SPIRITS(MYSTIC, new BooleanSpecializationValues(), true), EARTH_SENSE(GENERAL, true),
	REPTILIAN_REGENERATION(GENERAL, true),

	// Work career specializations
	AUTORITY(FIGHTER, new CarerSpecializationValues()), CHARISMA(GENERAL, new CarerSpecializationValues()),
	CREDIBILITY(GENERAL, new CarerSpecializationValues()), RAT(SPY, new CarerSpecializationValues()),
	INTERFACE(SPY, new CarerSpecializationValues()), COMBAT_SENSE(FIGHTER, new CarerSpecializationValues()),
	INGENIOUS_TINKERING(SCIENTIST, new CarerSpecializationValues()),
	MEDICAL_TECHNICS(SCIENTIST, new CarerSpecializationValues());

	private @Getter CarreerEnum specializationCategory;
	private @Getter SpecializationValuesAbstract specializationValues = new StandardSpecializationValues();
	private @Getter Boolean species = false;

	SpecializationEnum(CarreerEnum specializationCategory) {
		this.specializationCategory = specializationCategory;
	}

	SpecializationEnum(CarreerEnum specializationCategory, SpecializationValuesAbstract values) {
		this(specializationCategory);
		this.specializationValues = values;
	}

	SpecializationEnum(CarreerEnum specializationCategory, SpecializationValuesAbstract values,
			boolean species) {
		this(specializationCategory, values);
		this.species = species;
	}

	SpecializationEnum(CarreerEnum specializationCategory, boolean species) {
		this(specializationCategory);
		this.species = species;
	}
}
