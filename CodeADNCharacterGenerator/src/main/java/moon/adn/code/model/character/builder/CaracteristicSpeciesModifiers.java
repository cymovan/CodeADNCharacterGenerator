package moon.adn.code.model.character.builder;

import java.util.EnumMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

/**
 * Class used to stock species modifiers applied on Character build process.
 * 
 * @author Cédric DELRUE
 *
 */
@Getter
@Setter
public class CaracteristicSpeciesModifiers {
	private Map<CaracteristicEnum, Modifier> modifiersMap = new EnumMap<>(CaracteristicEnum.class);
}
