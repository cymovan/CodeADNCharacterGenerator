package moon.adn.code.model.character.history;

import java.util.Random;

public enum HistoryEventTypeEnum {
	LUCK, BADLUCK, FRIEND, ENEMY;
	// TODO : ROMANCE

	private static Random random = new Random();

	public static HistoryEventTypeEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
