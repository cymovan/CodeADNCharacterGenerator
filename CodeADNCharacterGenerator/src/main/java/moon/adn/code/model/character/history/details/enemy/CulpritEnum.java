package moon.adn.code.model.character.history.details.enemy;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Define who is the culprit that leads to create this enemy.
 * 
 * @author Cédric DELRUE
 *
 */
public enum CulpritEnum {
	YOU, HIM_HER, TIERS_FOOLS_YOU, TIERS_FOOLS_ENNEMY;

	private static Random random = new SecureRandom();

	public static CulpritEnum SecureRandom() {
		return values()[random.nextInt(values().length)];
	}
}
