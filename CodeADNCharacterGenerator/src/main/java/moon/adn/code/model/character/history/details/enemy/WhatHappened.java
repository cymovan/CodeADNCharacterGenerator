package moon.adn.code.model.character.history.details.enemy;

import moon.adn.code.model.character.history.HistoryEventAbstract;

public class WhatHappened extends HistoryEventAbstract {
	private static final String WHAT_HAPPENED = "thirdParty";
	private static final int MAX = 15;

	public WhatHappened() {
		super(WHAT_HAPPENED, MAX);
	}
}
