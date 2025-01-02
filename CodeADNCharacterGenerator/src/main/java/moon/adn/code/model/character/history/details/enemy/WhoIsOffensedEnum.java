package moon.adn.code.model.character.history.details.enemy;

import java.security.SecureRandom;

public enum WhoIsOffensedEnum {
	YOU_HATED_HIM_HER, HE_OR_SHE_HATED_YOU, MUTUAL_HATRED;

	private static SecureRandom random = new SecureRandom();

	public static WhoIsOffensedEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
