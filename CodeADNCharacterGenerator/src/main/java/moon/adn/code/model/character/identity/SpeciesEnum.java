package moon.adn.code.model.character.identity;

import static moon.adn.code.model.character.identity.CaracteristicModifiersHelper.aquaticElfModifiers;
import static moon.adn.code.model.character.identity.CaracteristicModifiersHelper.darkElfModifiers;
import static moon.adn.code.model.character.identity.CaracteristicModifiersHelper.goldElfModifiers;
import static moon.adn.code.model.character.identity.CaracteristicModifiersHelper.greyElfModifiers;
import static moon.adn.code.model.character.identity.CaracteristicModifiersHelper.humanModifiers;
import static moon.adn.code.model.character.identity.CaracteristicModifiersHelper.nightElfModifiers;
import static moon.adn.code.model.character.identity.CaracteristicModifiersHelper.paleElfModifiers;
import static moon.adn.code.model.character.identity.CaracteristicModifiersHelper.sylvanElfModifiers;
import static moon.adn.code.model.character.identity.CaracteristicModifiersHelper.urbanElfModifiers;
import static moon.adn.code.model.character.identity.SkillSpeciesModifiersHelper.aquaticElfSkills;
import static moon.adn.code.model.character.identity.SkillSpeciesModifiersHelper.darkElfSkills;
import static moon.adn.code.model.character.identity.SkillSpeciesModifiersHelper.goldElfSkills;
import static moon.adn.code.model.character.identity.SkillSpeciesModifiersHelper.greyElfSkills;
import static moon.adn.code.model.character.identity.SkillSpeciesModifiersHelper.nightElfSkills;
import static moon.adn.code.model.character.identity.SkillSpeciesModifiersHelper.paleElfSkills;
import static moon.adn.code.model.character.identity.SkillSpeciesModifiersHelper.sylvanElfSkills;
import static moon.adn.code.model.character.identity.SkillSpeciesModifiersHelper.urbanElfSkills;
import static moon.adn.code.system.RandomDiceUtil.d2;
import static moon.adn.code.system.RandomDiceUtil.d3;
import static moon.adn.code.system.RandomDiceUtil.d4;

import static moon.adn.code.model.character.specializations.SpecializationsCreationHelper.*;

import java.util.Random;

import lombok.Getter;
import moon.adn.code.model.character.builder.CaracteristicSpeciesModifiers;
import moon.adn.code.model.character.history.HistoryHelper;
import moon.adn.code.model.character.skills.SkillsSpeciesModifiers;
import moon.adn.code.model.character.specializations.SpecializationsAtCreation;

/**
 * All species of Code 🧬.
 * 
 * @author cdelr
 *
 */
public enum SpeciesEnum {
	HUMAN(humanModifiers()), S_URB(urbanElfModifiers(), urbanElfSkills(), urbanElfSpecializations()),
	S_SYLV(sylvanElfModifiers(), sylvanElfSkills(), sylvanElfSpecializations()),
	S_PALE(paleElfModifiers(), paleElfSkills(), paleElfSpecializations()),
	S_GREY(greyElfModifiers(), greyElfSkills(), greyElfSpecializations()),
	S_GOLD(goldElfModifiers(), goldElfSkills(), goldElfSpecializations()),
	S_NIGHT(nightElfModifiers(), nightElfSkills(), nightElfSpecializations()),
	S_AQUA(aquaticElfModifiers(), aquaticElfSkills(), aquaticElfSpecializations()),
	S_DARK(darkElfModifiers(), darkElfSkills(), darkElfSpecializations());

	private @Getter CaracteristicSpeciesModifiers caractModifiers;
	private @Getter SkillsSpeciesModifiers SkillModifiers;
	private @Getter SpecializationsAtCreation specializations = new SpecializationsAtCreation();

//	private int[] destinyInterval = {19, 29, 49, 74, 99, 124, 125, 1000};
//	private int[] destinyElfDices = {2, 3, 8, 6, 5, 8, 5, 4};

	private static Random random = new Random();
	public static final String MESSAGE_PREFIX = "species.";

	public static SpeciesEnum random() {
		return values()[random.nextInt(values().length)];
	}

	/**
	 * Constructor of {@link SpeciesEnum}
	 * 
	 * @param csm
	 */
	private SpeciesEnum(CaracteristicSpeciesModifiers csm) {
		this.caractModifiers = csm;
	}

	/**
	 * Constructor of {@link SpeciesEnum} with {@link SkillsSpeciesModifiers}. Other
	 * species than humans have modifier specifics for their species.
	 * 
	 * @param caractSpeciesModifier
	 * @param skillSpecicesModifier
	 */
	private SpeciesEnum(CaracteristicSpeciesModifiers caractSpeciesModifier,
			SkillsSpeciesModifiers skillSpecicesModifier) {
		this.caractModifiers = caractSpeciesModifier;
		this.SkillModifiers = skillSpecicesModifier;
	}

	SpeciesEnum(CaracteristicSpeciesModifiers caractSpeciesModifier, SkillsSpeciesModifiers skillSpecicesModifier,
			SpecializationsAtCreation specializations) {
		this(caractSpeciesModifier, skillSpecicesModifier);
		this.specializations = specializations;
	}

	/**
	 * @return size of sibling depending of the {@link SpeciesEnum}.
	 */
	public int randomSibling() {
		int siblingCount = 0;
		switch (this) {
		case HUMAN, S_SYLV, S_DARK: {
			siblingCount = d4() - 1;
			break;
		}
		case S_URB, S_PALE, S_GREY, S_NIGHT, S_AQUA: {
			siblingCount = d3() - 1;
			break;
		}
		case S_GOLD: {
			siblingCount = d2() - 1;
			break;
		}
		default:
			return siblingCount;
		}
		return siblingCount;
	}

	public int ageDiffSibling() {
		int minDiff = 0, maxDiff = 20;
		int ageDiff = 2;
		switch (this) {
		case HUMAN: {
			maxDiff = 20;
			break;
		}
		case S_DARK: {
			maxDiff = 150;
			break;
		}
		case S_SYLV, S_URB: {
			minDiff = 25;
			maxDiff = 150;
			break;
		}
		case S_PALE, S_GREY: {
			minDiff = 80;
			maxDiff = 100;
			break;
		}
		case S_NIGHT, S_AQUA: {
			minDiff = 80;
			maxDiff = 100;
			break;
		}
		case S_GOLD: {
			minDiff = 100;
			maxDiff = 200;
			break;
		}
		default:
			return ageDiff;
		}
		return HistoryHelper.randomValuesBetween(minDiff, maxDiff);
	}
}
