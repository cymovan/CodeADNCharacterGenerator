package moon.adn.code.model.character.history.raec;

import java.util.Random;

/**
 * EN : Family, Romance, Encouter, Friend, Ennemy, Contact.
 * FR : Famille, Romance, Ami, Ennemi, Contact
 * 
 * @author cdelr
 *
 */
public enum RAECEnum {
	BROTHER, SISTER, ROMANCE, CONTACT, FRIEND, ENEMY;

	private static Random random = new Random();

	public static RAECEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
