package moon.adn.code.model.character.history;

import java.util.Random;

public enum HistoryRomanceEnum {
	HAPPY_STORY, TRAGIC_STORY, PROBLEMATIC_STORY, HOT_STORY;

	private static Random random = new Random();

	public static HistoryRomanceEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
