package moon.adn.code.model.character.history.details.enemy;

import java.util.Random;

public enum DoYouKnowHimEnum {
	EX_FRIEND, EX_LOVER, FAMILY_MEMBER, SOMEONE_YOU_WORK, SOMEONE_WORKING_FOR_YOU, PARTNAIR_OR_COLLEAGUE, STRANGER;

	private static Random random = new Random();

	public static DoYouKnowHimEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
