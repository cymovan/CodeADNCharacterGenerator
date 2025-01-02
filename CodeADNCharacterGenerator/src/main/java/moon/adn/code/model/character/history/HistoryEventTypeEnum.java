package moon.adn.code.model.character.history;

import java.security.SecureRandom;

public enum HistoryEventTypeEnum {
	LUCK, BADLUCK, FRIEND, ENEMY, ROMANCE;

	private static SecureRandom random = new SecureRandom();

	public static HistoryEventTypeEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
