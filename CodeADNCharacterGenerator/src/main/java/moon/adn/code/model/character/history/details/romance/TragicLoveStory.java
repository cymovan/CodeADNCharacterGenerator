package moon.adn.code.model.character.history.details.romance;

import moon.adn.code.model.character.history.HistoryEventAbstract;

public class TragicLoveStory extends HistoryEventAbstract {
	private static final String LABEL_I18N = "tragicLoveStory";
	private static final int MAX = 15;

	public TragicLoveStory() {
		super(LABEL_I18N, MAX);
	}
}
