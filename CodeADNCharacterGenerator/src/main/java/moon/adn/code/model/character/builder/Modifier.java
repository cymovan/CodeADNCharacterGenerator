package moon.adn.code.model.character.builder;

import lombok.Data;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

/**
 * Modifier class used for species modifier of {@link CaracteristicEnum}. Don't
 * use this modifier for {@link CaractValues} because of the absoluteMin not
 * implemented in this class. Prefer use {@link CaracteristicsModifier}.
 * 
 * @author Cédric DELRUE
 *
 */
@Data
public class Modifier {
	private static final int ABSOLUTE_MIN = 0;
	protected int value;
	protected int min = ABSOLUTE_MIN;
	protected int max = CaractValues.DEFAULT_MAX;
	// Probabilty to acquire
	private double probabiltyPercent = 0.0d;

	/**
	 * @param value Modifier value applied to max and applied when modifier will be
	 *              used on value.
	 */
	public Modifier(int value) {
		this.value = value;
		this.max += value;
	}

	/**
	 * @param value Modifier value applied
	 * @param min   Set the min score allowed
	 */
	public Modifier(int value, int min) {
		this.value = value;
		if (min >= ABSOLUTE_MIN) {
			this.min = min;
		}
		this.max += value;
	}

	public Modifier(int value, double probabiltyPercent) {
		this(value);
		this.probabiltyPercent = probabiltyPercent;
	}
}
