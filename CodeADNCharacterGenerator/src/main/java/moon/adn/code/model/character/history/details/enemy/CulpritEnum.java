package moon.adn.code.model.character.history.details.enemy;

import java.security.SecureRandom;

/**
 * Define who is the culprit that leads to create this enemy.
 * 
 * @author Cédric DELRUE
 *
 */
public enum CulpritEnum {
	YOU, HIM_HER, TIERS_FOOLS_YOU, TIERS_FOOLS_ENNEMY;

	private static SecureRandom random = new SecureRandom();

	public static CulpritEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
