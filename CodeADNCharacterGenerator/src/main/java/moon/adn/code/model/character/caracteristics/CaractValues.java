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
	private static final int DEFAULT_MIN = 1;
	private static final int DEFAULT_MAX = 10;
	private int creationValue, currentValue, min, max;
	private int speciesMin, speciesMax, speciesModificator;

	@JsonCreator
	public CaractValues() {

	}

	public CaractValues(int value) {
		this.creationValue = value;
		this.currentValue = value;
		this.speciesMax = DEFAULT_MAX;
		this.speciesMin = DEFAULT_MIN;
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
