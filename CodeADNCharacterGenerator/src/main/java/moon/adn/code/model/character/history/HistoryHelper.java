package moon.adn.code.model.character.history;

import static moon.adn.code.system.RandomDiceUtil.random;

import java.security.SecureRandom;
import java.util.Random;

public class HistoryHelper {

	private HistoryHelper() {
		throw new IllegalStateException("Utility class");
	}

	public static int getPositionFromIntervals(int[] intervalValues, int maxSides) {
		int valeur = random(maxSides);
		for (int i = 0; i < intervalValues.length - 1; i++) {
			if (valeur <= intervalValues[i]) {
				return i;
			}
		}
		return intervalValues.length - 1;
	}

	public static int getPositionFromIntervals(int[] intervalValues) {
		int valeur = random(intervalValues[intervalValues.length - 1]);
		for (int i = 0; i < intervalValues.length - 1; i++) {
			if (valeur <= intervalValues[i]) {
				return i;
			}
		}
		return intervalValues.length - 1;
	}

	public static int randomValuesBetween(int min, int max) {
		Random r = new SecureRandom();
		return r.nextInt(min, max);
	}
}
