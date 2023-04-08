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
	private static final int MAX_D10 = 10;
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
	 * @return value beetwen 1 and 10.
	 */
	public static int d10() {
		return random(MAX_D10);
	}

	/**
	 * @return value beetwen 2 and 10.
	 */
	public static int d10Heroic() {
		int result = random(MAX_D10);
		if (result <= 1) {
			result = 2;
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
}
