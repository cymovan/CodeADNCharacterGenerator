package moon.adn.code.model.character.history.details.romance;

import static moon.adn.code.system.RandomDiceUtil.d10;
import static moon.adn.code.system.RandomDiceUtil.d10Explode;
import static moon.adn.code.system.RandomDiceUtil.d4Explode;

import java.util.Random;

import lombok.Getter;

public enum RomanceDurationEnum {
	COUPLE_OF_WEEKS_MONTHS(2), SEVERAL_TIMES(3), FEW_YEARS(5), SOME_YEARS(7), LONG_STORY(9), FOREVER(10);

	private static Random random = new Random();
	private @Getter int maxD10Value;

	RomanceDurationEnum(int maxD10Value) {
		this.maxD10Value = maxD10Value;
	}

	public static RomanceDurationEnum randomFromRules() {
		RomanceDurationEnum result = COUPLE_OF_WEEKS_MONTHS;
		int d10 = d10();
		for (RomanceDurationEnum it : values()) {
			if (it.maxD10Value - d10 >= 0) {
				return it;
			}
		}
		return result;
	}

	public static RomanceDurationEnum randomHotRelation() {
		return values()[random.nextInt(3)];
	}

	public static RomanceDurationEnum random() {
		return values()[random.nextInt(values().length)];
	}

	public static void defineRomanceDurationInMonthsAndYears(Romance romance) {
		int months = 0;
		switch (romance.getDuration()) {
		case COUPLE_OF_WEEKS_MONTHS:
			months = d4Explode();
			romance.setDurationInMonths(months);
			break;
		case SEVERAL_TIMES:
			int episodes = d4Explode();
			for (int i = 1; i <= episodes; i++) {
				months += d4Explode();
			}
			romance.setDurationInMonths(months);
			break;
		case FEW_YEARS:
			romance.setDurationInYears(d4Explode());
			break;
		case SOME_YEARS:
			romance.setDurationInYears(d4Explode() + 5);
			break;
		case LONG_STORY:
			romance.setDurationInYears(d10Explode() + 5);
			break;
		case FOREVER:
			// nothing : stay at 0 months, 0 years.
		default:
			break;
		}
	}
}
