package moon.adn.code.model.character.caracteristics;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;
import moon.adn.code.model.character.builder.Modifier;

/**
 * Values for caracteristics
 * 
 * @author cdelr
 */
@Data
public class CaractValues {
	public static final int DEFAULT_MIN = 1;
	public static final int DEFAULT_MAX = 10;
	private int creationValue, currentValue;
	private int speciesMin = DEFAULT_MIN, speciesMax = DEFAULT_MAX, speciesModificator;

	@JsonCreator
	public CaractValues() {

	}

	public CaractValues(int value) {
		this.creationValue = value;
		this.currentValue = value;
	}

	public void applyCaractModifier(Modifier modifier) {
		speciesMax = modifier.getMax();
		speciesMin = modifier.getMin();
		speciesModificator = modifier.getValue();
		computeCurrentValueFromCaractModifier();
	}

	private void computeCurrentValueFromCaractModifier() {
		int computedValue = currentValue + speciesModificator;
		if (computedValue < speciesMin) {
			computedValue = speciesMin;
		}
		if (computedValue > speciesMax) {
			computedValue = speciesMax;
		}
		currentValue = computedValue;
	}
}
