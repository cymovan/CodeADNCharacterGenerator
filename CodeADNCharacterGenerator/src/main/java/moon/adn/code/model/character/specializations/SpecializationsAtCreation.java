package moon.adn.code.model.character.specializations;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecializationsAtCreation {
	Map<SpecializationEnum, SpecializationValuesAbstract> specializationsMap = new HashMap<>();
}
