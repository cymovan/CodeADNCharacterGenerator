package moon.adn.code.model.character.history.details.romance;

import moon.adn.code.model.character.history.HistoryEventAbstract;

public class ProblematicLoveStory extends HistoryEventAbstract {
	private static final String LABEL_I18N = "problematicLoveStory";
	private static final int MAX = 14;

	public ProblematicLoveStory() {
		super(LABEL_I18N, MAX);
	}
}
