package moon.adn.code.model.character.caracteristics;

import java.io.Serializable;

import lombok.Getter;

/**
 * Enum for caracteristics in Code🧬.
 * 
 * @author Cédric DELRUE
 *
 */
public enum CaracteristicEnum implements Serializable {
	INT(1), REF(2), TECH(3), EMP(4), BT(5), STR(6), CON(7), LUCK(8), AG(9), HEIGHT(10), WILL(11), POW(12);

	private @Getter int position;

	private CaracteristicEnum(int position) {
		this.position = position;
	}
}
