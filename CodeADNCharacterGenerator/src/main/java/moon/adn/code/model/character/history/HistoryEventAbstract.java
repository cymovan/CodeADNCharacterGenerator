package moon.adn.code.model.character.history;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import moon.adn.code.system.RandomDiceUtil;

/**
 * @author cdelr
 *
 */
public abstract class HistoryEventAbstract {
	private static final String NUMBER_FORMAT = "00";
	private static final String ROOT_I18n = "hist.";
	protected final int maxInterval;

	protected int[] intervalValues = { 0 };
	protected List<Integer> segments = new ArrayList<>();
	protected String i18nPrefix;

	protected HistoryEventAbstract(String i18nPrefix, int[] intervalValues, int maxInterval) {
		this.i18nPrefix = ROOT_I18n + i18nPrefix;
		this.maxInterval = maxInterval;
		this.intervalValues = intervalValues;
		if (intervalValues.length == 1) {
			initIntervalValues();
		}
		initFromIntervalValues();
	}

	protected HistoryEventAbstract(String i18nPrefix, int maxInterval) {
		this.i18nPrefix = ROOT_I18n + i18nPrefix;
		this.maxInterval = maxInterval;
		if (intervalValues.length == 1) {
			initIntervalValues();
		}
		initFromIntervalValues();
	}

	private void initIntervalValues() {
		intervalValues = new int[maxInterval];
		for (int i = 0; i < maxInterval; i++) {
			intervalValues[i] = i + 1;
		}
	}

	private void initFromIntervalValues() {
		for (int i : intervalValues) {
			segments.add(i);
		}
	}

	public String randomEvent() {
		return i18nKey(getPositionFromIntervals(maxInterval));
	}

	protected int getPositionFromIntervals(int MaxSides) {
		int valeur = RandomDiceUtil.random(MaxSides);
		for (int i = 0; i < segments.size(); i++) {
			if (valeur <= segments.get(i)) {
				return i;
			}
		}
		return 0;
	}

	protected String i18nKey(int keyNumber) {
		DecimalFormat df = new DecimalFormat(NUMBER_FORMAT);
		return i18nPrefix + df.format(keyNumber);
	}
}