package moon.adn.code.model.character.history;

import java.util.Random;

import moon.adn.code.system.RandomDiceUtil;
import static moon.adn.code.system.RandomDiceUtil.*;

public class HistoryHelper {

	public static int getPositionFromIntervals(int[] intervalValues, int MaxSides) {
		int valeur = random(MaxSides);
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
		Random r = new Random();
		int diff = r.nextInt((max - min) + 1) + min;
		return diff;
	}
}
