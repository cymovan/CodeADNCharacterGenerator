package moon.adn.code.model.character.specializations;

import java.util.EnumMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class used on process creation that contains {@link SpecializationEnum} and
 * their {@link SpecializationValues} at creation.
 * 
 * @author Cédric DELRUE
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecializationsAtCreation {
	private Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new EnumMap<>(
			SpecializationEnum.class);
}
