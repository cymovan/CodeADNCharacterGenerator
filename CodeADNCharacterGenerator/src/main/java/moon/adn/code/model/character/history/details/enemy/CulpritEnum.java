package moon.adn.code.model.character.history.details.enemy;

import java.util.Random;

public enum CulpritEnum {
	YOU, HIM_HER, TIERS_FOOLS_YOU, TIERS_FOOLS_ENNEMY;
	
	private static Random random = new Random();

	public static CulpritEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
