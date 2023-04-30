package moon.adn.code.model.character.history.raec;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * EN : Family, Romance, Encouter, Friend, Ennemy, Contact. 
 * FR : Famille, Romance, Ami, Ennemi, Contact
 * 
 * @author Cédric DELRUE
 *
 */
public enum RAECEnum {
	BROTHER, SISTER, ROMANCE, CONTACT, FRIEND, ENEMY;

	private static Random random = new Random();

	public static RAECEnum random() {
		return randomWithoutSibling();
	}

	private static RAECEnum randomWithoutSibling() {
		Set<RAECEnum> set = EnumSet.allOf(RAECEnum.class);
		set.removeAll(EnumSet.of(BROTHER, SISTER));
		List<RAECEnum> list = new ArrayList<>(set);
		return list.get(random.nextInt(list.size()));
	}
}
