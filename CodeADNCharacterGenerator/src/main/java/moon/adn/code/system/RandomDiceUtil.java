package moon.adn.code.system;

import java.util.Random;

/**
 * Utility class for random launch dices.
 * 
 * @author cdelr
 *
 */
public class RandomDiceUtil {
	private static final int MAX_D2 = 2;
	private static final int MAX_D3 = 3;
	private static final int MAX_D4 = 4;
	private static final int MAX_D6 = 6;
	private static final int MAX_D8 = 8;
	private static final int MAX_D10 = 10;
	private static final int MAX_D100 = 100;

	private static final int MAX_WEAK = 7;
	private static Random random = new Random();

	/**
	 * @return value beetwen 1 and 2.
	 */
	public static int d2() {
		return random(MAX_D2);
	}

	/**
	 * @return value beetwen 1 and 3.
	 */
	public static int d3() {
		return random(MAX_D3);
	}

	/**
	 * @return value beetwen 1 and 4.
	 */
	public static int d4() {
		return random(MAX_D4);
	}

	/**
	 * @return value beetwen 1 and 6.
	 */
	public static int d6() {
		return random(MAX_D6);
	}

	/**
	 * @return value beetwen 1 and 8.
	 */
	public static int d8() {
		return random(MAX_D8);
	}
	
	/**
	 * @return value beetwen 1 and 10.
	 */
	public static int d10() {
		return random(MAX_D10);
	}

	public static int d4Explode() {
		return diceExplode(MAX_D4, 0);
	}
	
	public static int d10Explode() {
		return diceExplode(MAX_D10, 0);
	}

	private static int diceExplode(int diceValue, int score) {
		int result = random(diceValue);
		if (result == diceValue) {
			return diceExplode(diceValue, score + diceValue);
		}
		return result + score;
	}

	/**
	 * @return value beetwen 1 and 100.
	 */
	public static int d100() {
		return random(MAX_D100);
	}

	/**
	 * @return value beetwen 3 and 10.
	 */
	public static int d10Heroic() {
		int result = random(MAX_D10);
		if (result <= 2) {
			result = 3;
		}
		return result;
	}

	/**
	 * @return value beetwen 1 and 7.
	 */
	public static int d10Weak() {
		return random(MAX_WEAK);
	}

	public static int random(int maxDiceSide) {
		return random.nextInt(maxDiceSide) + 1;
	}
	
	public static int random(int min, int maxDiceSide) {
		return random.nextInt(min, maxDiceSide) + 1;
	}
}
