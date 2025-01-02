package moon.adn.code.model.character.history.details.romance;

import java.security.SecureRandom;

public enum HistoryRomanceEnum {
	HAPPY_STORY, TRAGIC_STORY, PROBLEMATIC_STORY, HOT_STORY;

	private static SecureRandom random = new SecureRandom();

	public static HistoryRomanceEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
