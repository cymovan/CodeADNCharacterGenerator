package moon.adn.code.model.character.history.raec;

import static moon.adn.code.model.character.history.HistoryHelper.getPositionFromIntervals;

import moon.adn.code.system.I18N;

public enum JobCategoryEnum implements I18N {
	STANDARD, STREET, LAW, ILLEGAL, CORPO, ENTERTAINMENT, GOVERNMENT, NAOHM;

	private static final int[] jobCategoryIntervals = { 20, 35, 50, 65, 79, 89, 99, 100 };
	private static final String I18N_ROOT = "jobs.category.";

	public static JobCategoryEnum random() {
		int randomCat = getPositionFromIntervals(jobCategoryIntervals, 100);
		return JobCategoryEnum.values()[randomCat];
	}

	@Override
	public String i18nKey() {
		return I18N_ROOT + name();
	}

}
