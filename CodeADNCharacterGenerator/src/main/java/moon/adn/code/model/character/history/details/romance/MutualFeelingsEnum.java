package moon.adn.code.model.character.history.details.romance;

import java.security.SecureRandom;

public enum MutualFeelingsEnum {
	STILL_LOVES_YOU, YOU_STILL_LOVE_HIM_OR_HER, STILL_LOVE_EACH_OTHER, HATE_HIM_OR_HER, HATE_EACH_OTHER, STILL_FRIENDS,
	IT_S_OVER, YOU_LOVE_HIM_OR_HER_HATES_YOU, LOVES_YOU_BUT_YOU_HATE_HIM_OR_HER;

	private static SecureRandom random = new SecureRandom();

	public static MutualFeelingsEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
