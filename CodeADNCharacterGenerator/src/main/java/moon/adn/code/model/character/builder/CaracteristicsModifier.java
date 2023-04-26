package moon.adn.code.model.character.builder;

public class CaracteristicsModifier extends Modifier {
	private static final int ABSOLUTE_CARACT_MIN = 1;

	public CaracteristicsModifier(int value) {
		super(value);
		this.min = ABSOLUTE_CARACT_MIN;
	}

	public CaracteristicsModifier(int value, int min) {
		this(value);
		if (min > ABSOLUTE_CARACT_MIN) {
			this.min = min;
		}
	}

	/**
	 * @param value Modifier value applied
	 * @param min   Define min score, can't be under absoluteMin
	 * @param max   Fix max score
	 */
	public CaracteristicsModifier(int value, int min, int max) {
		super(value, min);
		this.max = max;
	}
}
