package moon.adn.code.model.character.history;

public class HistoryBadLuckEvent extends HistoryEventAbstract {
	private int[] intervalValues = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
	private static final int MAX_INTERVAL = 100;
	private static final String BADLUCK_PREFIX = "badluck";

	public HistoryBadLuckEvent() {
		super(BADLUCK_PREFIX);
		for (int i : intervalValues) {
			segments.add(i);
		}
	}

	@Override
	public String randomEvent() {
		return i18nKey(getPositionFromIntervals(MAX_INTERVAL));
	}
}
