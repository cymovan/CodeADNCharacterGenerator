package moon.adn.code.model.character.identity;

import java.security.SecureRandom;

import moon.adn.code.system.I18N;

public enum SexEnum implements I18N {
	M, F;

	private static SecureRandom random = new SecureRandom();

	public static final String MESSAGE_PREFIX = "sex.";

	public static SexEnum random() {
		return values()[random.nextInt(values().length)];
	}

	@Override
	public String i18nKey() {
		return MESSAGE_PREFIX + name();
	}
}
