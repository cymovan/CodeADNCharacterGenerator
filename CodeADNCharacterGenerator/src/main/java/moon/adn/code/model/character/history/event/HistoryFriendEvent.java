package moon.adn.code.model.character.history.event;

import moon.adn.code.model.character.history.HistoryEventAbstract;

public class HistoryFriendEvent extends HistoryEventAbstract {
	private static final int[] INTERVAL_VALUES = { 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 56, 60, 64, 68, 72,
			76, 80, 84, 88, 92, 96, 100 };
	private static final int MAX_INTERVAL = 100;
	private static final String FRIEND_PREFIX = "friend";

	public HistoryFriendEvent() {
		super(FRIEND_PREFIX, INTERVAL_VALUES, MAX_INTERVAL);
	}
}
