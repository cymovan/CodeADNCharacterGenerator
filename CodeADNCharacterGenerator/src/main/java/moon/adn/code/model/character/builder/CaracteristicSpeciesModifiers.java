package moon.adn.code.model.character.builder;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

/**
 * Class used to stock species modifiers applied on Character build process.
 * 
 * @author cdelr
 *
 */
@Getter
@Setter
public class CaracteristicSpeciesModifiers {
	private Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
}
