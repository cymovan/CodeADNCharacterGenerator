package moon.adn.code.model.character.history.event;

import moon.adn.code.model.character.history.HistoryEventAbstract;

public class HistoryLuckEvent extends HistoryEventAbstract {
	private static final int[] INTERVAL_VALUES = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85,
			90, 94, 98, 100 };
	private static final int MAX_INTERVAL = 100;
	private static final String LUCK_PREFIX = "luck";

	public HistoryLuckEvent() {
		super(LUCK_PREFIX, INTERVAL_VALUES, MAX_INTERVAL);
	}
}
