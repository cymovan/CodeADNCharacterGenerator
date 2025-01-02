package moon.adn.code.model.character.history.details.enemy;

import java.security.SecureRandom;

import moon.adn.code.model.character.Character;

/**
 * Enum on how the {@link Character} know this Enemy.
 * 
 * @author Cédric DELRUE
 *
 */
public enum DoYouKnowHimEnum {
	EX_FRIEND, EX_LOVER, FAMILY_MEMBER, SOMEONE_YOU_WORK, SOMEONE_WORKING_FOR_YOU, PARTNAIR_OR_COLLEAGUE, STRANGER;

	private static SecureRandom random = new SecureRandom();

	public static DoYouKnowHimEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
