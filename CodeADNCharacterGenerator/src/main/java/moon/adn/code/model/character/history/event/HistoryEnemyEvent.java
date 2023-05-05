package moon.adn.code.model.character.history.event;

import moon.adn.code.model.character.history.HistoryEventAbstract;

public class HistoryEnemyEvent extends HistoryEventAbstract {
	private static final int[] INTERVAL_VALUES = { 10, 20, 30, 40, 50, 60, 100 };
	protected static final int MAX_INTERVAL = 100;
	private static final String ENEMY_PREFIX = "enemy";

	public HistoryEnemyEvent() {
		super(ENEMY_PREFIX, INTERVAL_VALUES, MAX_INTERVAL);
	}

	public HistoryEnemyEvent(String i18nPrefix, int[] intervalValues, int maxInterval) {
		super(ENEMY_PREFIX + "." + i18nPrefix, intervalValues, maxInterval);
	}
}
