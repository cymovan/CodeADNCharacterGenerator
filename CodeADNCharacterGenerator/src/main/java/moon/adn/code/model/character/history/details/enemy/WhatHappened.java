package moon.adn.code.model.character.history.details.enemy;

import moon.adn.code.model.character.history.HistoryEventAbstract;

public class WhatHappened extends HistoryEventAbstract {
	private static final String WHAT_HAPPENED = "enemy.whatHappened";
	private static final int MAX = 24;

	public WhatHappened() {
		super(WHAT_HAPPENED, MAX);
	}
}
