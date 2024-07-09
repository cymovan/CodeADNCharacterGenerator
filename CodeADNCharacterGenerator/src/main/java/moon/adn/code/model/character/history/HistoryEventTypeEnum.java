package moon.adn.code.model.character.history;

import java.security.SecureRandom;
import java.util.Random;

public enum HistoryEventTypeEnum {
	LUCK, BADLUCK, FRIEND, ENEMY, ROMANCE;

	private static Random random = new SecureRandom();

	public static HistoryEventTypeEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
