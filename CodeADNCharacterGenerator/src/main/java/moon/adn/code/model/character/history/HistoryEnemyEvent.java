package moon.adn.code.model.character.history;

public class HistoryEnemyEvent extends HistoryEventAbstract {
	protected int[] intervalValues = { 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 56, 60, 64, 68, 72, 76, 80, 84,
			88, 92, 96, 100 };
	private static final int MAX_INTERVAL = 100;
	private static final String ENEMY_PREFIX = "ennemy";

	public HistoryEnemyEvent() {
		super(ENEMY_PREFIX, MAX_INTERVAL);
	}
}
