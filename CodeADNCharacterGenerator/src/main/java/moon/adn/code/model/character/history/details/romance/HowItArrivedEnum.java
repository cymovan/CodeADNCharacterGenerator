package moon.adn.code.model.character.history.details.romance;

import java.util.Random;

public enum HowItArrivedEnum {
	PARTNAIR, COLLEAGUE, CONTACT, EX_LOVER, OLD_ENEMY, OLD_CHILDHOOD_FRIEND, COMMON_INTEREST, SAVED_LIFE,
	SAVED_YOUR_LIFE, PARTY_OR_TRIP, SOMEONE_YOU_WORKED_FOR, SOMEONE_WHO_WORKED_FOR_YOU, FRIEND_IN_COMMON, SPEED_DATING,
	SCHOOL, CONCERT, BAR, MALL, COMMON_LOVER;

	private static Random random = new Random();

	public static HowItArrivedEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
