package moon.adn.code.model.character.history.details.enemy;

import moon.adn.code.model.character.history.event.HistoryEnemyEvent;

public class ThirdParty extends HistoryEnemyEvent {
	private static final int[] INTERVAL_VALUES = { 5, 10, 15, 20, 25, 30, 35, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90,
			95, 100 };
	private static final String THIRD_PARTY = "thirdParty";

	public ThirdParty() {
		super(THIRD_PARTY, INTERVAL_VALUES, MAX_INTERVAL);
	}
}
