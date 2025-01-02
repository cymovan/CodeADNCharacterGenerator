package moon.adn.code.model.character.history.details.enemy;

import java.security.SecureRandom;

public enum WhatWillYouDoEnum {
	CRITISIZE, CRUCIFY_VERBALLY, BEAT_UP, KILL_HIM_HER, AVOID, SABOTAGE, MAKE_HIS_HER_LIFE_HELL, REVENGE,
	SYMPATHIZE_THEN_BERTRAY_HIM_HER, IGNORE;

	private static SecureRandom random = new SecureRandom();

	public static WhatWillYouDoEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
