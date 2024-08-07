package moon.adn.code.model.character.caracteristics;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;
import moon.adn.code.model.character.builder.Modifier;

/**
 * Values for caracteristics
 * 
 * @author Cédric DELRUE
 */
@Getter
public class CaractValues implements Serializable {
	private static final long serialVersionUID = -6078819957592308659L;

	public static final int DEFAULT_MIN = 1;
	public static final int DEFAULT_MAX = 10;

	private int creationValue;
	private int currentValue;
	private int speciesMin = DEFAULT_MIN;
	private int speciesMax = DEFAULT_MAX;
	private int speciesModificator;

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
