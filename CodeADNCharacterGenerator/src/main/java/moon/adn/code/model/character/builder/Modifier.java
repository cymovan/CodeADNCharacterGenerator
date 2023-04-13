package moon.adn.code.model.character.builder;

import lombok.Data;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

/**
 * Modifier class used for species modifier of {@link CaracteristicEnum}.
 * 
 * @author cdelr
 *
 */
@Data
public class Modifier {
	private int value, min = 0, max = 10;
	private double probabiltyPercent = 0.0d;

	public Modifier(int value) {
		this.value = value;
		this.max += value;
	}

	public Modifier(int value, int min) {
		this.value = value;
		this.min = min;
		this.max += value;
	}

	public Modifier(int value, int min, int max) {
		this.value = value;
		this.min = min;
		this.max = max;
	}

	public Modifier(int value, double probabiltyPercent) {
		this.value = value;
		this.max += value;
		this.probabiltyPercent = probabiltyPercent;
	}
}
