package moon.adn.code.model.character.history.raec;

import static moon.adn.code.model.character.history.HistoryHelper.getPositionFromIntervals;

import java.security.SecureRandom;
import java.util.Random;

import lombok.Getter;
import moon.adn.code.model.character.history.HistoryHelper;
import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * Age categories for random RAEC character generation
 * 
 * @author Cédric DELRUE
 *
 */
public enum RAECAgeCategoriesEnum {
	OLDSTER(40, 60), RETIRED(25, 40), OLDER(10, 25), ALMOST_SAME(-5, 10), YOUNGER(-10, -5), TEENAGER(-20, -10),
	CHILD(-50, -20);

	private static int[] ageInterval = { 5, 15, 40, 60, 80, 95, 100 };
	private static int MIN_AGE = 13;
	private Random random = new SecureRandom();

	private @Getter int min = 0, max = 0;

	private RAECAgeCategoriesEnum(int max) {
		this.max = max;
	}

	private RAECAgeCategoriesEnum(int min, int max) {
		this(max);
		this.min = min;
	}

	public static RAECAgeCategoriesEnum random() {
		return values()[getPositionFromIntervals(ageInterval)];
	}

	public int ageDiff(SpeciesEnum species, int age) {
		int diff = HistoryHelper.randomValuesBetween(min, max);
		if (age + diff < MIN_AGE) {
			diff = age - MIN_AGE;
		}
		return diff;
	}

	public int ageDiffSibling(SpeciesEnum species, int age) {
		int diff = species.ageDiffSibling();
		boolean invert = false;
		if (age - diff >= 0) {
			invert = true;
		}
		if (invert && random.nextInt(2) == 0) {
			diff = -diff;
		}
		return diff;
	}
}
