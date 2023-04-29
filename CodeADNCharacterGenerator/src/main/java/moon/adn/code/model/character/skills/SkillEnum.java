package moon.adn.code.model.character.skills;

import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.AG;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.CON;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.EMP;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.INT;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.LUCK;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.POW;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.REF;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.STR;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.TECH;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.WILL;

import java.util.Random;

import lombok.Getter;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

/**
 * All skills
 * 
 * @author Cédric DELRUE
 *
 */
public enum SkillEnum {
	// INT SKILLS
	ASTRONOMY(INT), BIBLIO(INT), BIO(INT), BOTA(INT), CHEMISTRY(INT), DECODE(INT), DIAG(INT), LAW(INT), LISTEN(INT),
	EDUCATION(INT, false), TEACH(INT), EVAL(INT), MANAGEMENT(INT), HIST(INT), INVEST(INT),
	READ_SEPHONILEANDIS(INT, false), READ_SELENITE(INT), MATH(INT), MINERALS(INT), ORIENTATION(INT),
	SPEAK_SELENITE(INT), SPEAK_SEPHONILEANDIS(INT, false), SPEAK_SIGNS_LANGUAGE(INT), PHYSIC(INT), TRAPS(INT),
	POISONS(INT), CODING(INT), NET(INT), SMELLING(INT), SEE(INT),

	// REF SKILLS
	/**
	 * 
	 */
	THROW(REF), SHIELD(REF), DRIVE_CAR(REF), DRIVE_HEAVY(REF), KNIFE(REF), STEAL(REF), RIFFLES(REF), BRAWL(REF),
	POISON_MANIP(REF), AV_PILOT(REF), GYRO_PILOT(REF), JET_PILOT(REF), GUNS(REF), BOWS(REF),

	// STR Skills
	WEAPON(STR), FENCING(STR),

	// CON Skills
	ATHLETISM(CON), STAMINA(CON), SWIMMING(CON),

	// LUCK Skills
	GAMBLE(LUCK),

	// TECH Skills
	ART(TECH), ART_SINGING(TECH, false), WEAPON_AUTO(TECH), ARMOURER(TECH), DIY(TECH), COMPOSITION(TECH),
	/**
	 * Falsification
	 */
	FORGERY(TECH), LOCK_PICKING(TECH), CYBER_TECH(TECH), DISGUISE(TECH), DISMARM(TECH), ELECTRONIC(TECH),
	EXPLOSIVES(TECH), GRAPHISM(TECH), MUSIC(TECH), PICS(TECH), PICKPOCKET(TECH), PHARMA(TECH), FIRST_AIDS(TECH),
	SECURITY(TECH), TECH_GEN(TECH),

	// AG Skills
	STUNT(AG), MARTIAL_ART(AG), DANCE(AG), SNEAK(AG), RIDING(AG, false), DODGE(AG), CLIMB(AG), HIDE(AG), FLY(AG),

	// EMP Skills
	CHAT(EMP), COMEDY(EMP), ANIMAL_TRAINING(EMP), SOCIAL(EMP), INTERVIEW(EMP), BARGAIN(EMP), HUMAN_PERCEPTION(EMP),
	PERFORMANCE(EMP), SEDUCTION(EMP),

	// WILLPOWER Skills
	MORAL_CODE_SPIRITUAL_TREES(WILL), MORAL_CODE_MOON(WILL, false), MORAL_CODE_CORPO(WILL, false),
	MORAL_CODE_NAOHM(WILL, false), STREET_KNOWLEDGE(WILL), COMMANDMENT(WILL), CORRUPTION(WILL), ELOQUENCE(WILL),
	INTERROGATOIRE(WILL), TRACKING(WILL), TORTURE_RESISTANCE(WILL),

	// POWER Skills
	SIXTH_SENSE(POW), HYPNOTIZE(POW, false), MAGICAL_RESISTANCE(POW, false);

	private @Getter CaracteristicEnum caracteristic;
	private @Getter boolean forRandom = true;

	private static Random random = new Random();

	public static final String MESSAGE_PREFIX = "skill.";

	SkillEnum(CaracteristicEnum caracteristic) {
		this.caracteristic = caracteristic;
	}

	SkillEnum(CaracteristicEnum caracteristic, boolean forRandom) {
		this(caracteristic);
		this.forRandom = forRandom;
	}

	public static SkillEnum random() {
		return values()[random.nextInt(values().length)];
	}

	public static SkillEnum randomOnlyPossibleSkills() {
		SkillEnum result = null;
		while (result == null) {
			result = values()[random.nextInt(values().length)];
			if (!result.forRandom) {
				result = null;
			}
		}
		return values()[random.nextInt(values().length)];
	}
}
