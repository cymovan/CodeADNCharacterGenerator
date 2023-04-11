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
	
	protected List<Integer> segments = new ArrayList<>();
	protected String i18nPrefix;

	protected HistoryEventAbstract(String i18nPrefix) {
		this.i18nPrefix = ROOT_I18n + i18nPrefix;
	}

	abstract String randomEvent();

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