package moon.adn.code.model.character;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.identity.Identity;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillValues;
import moon.adn.code.model.character.specializations.CarreerEnum;
import moon.adn.code.model.character.specializations.SpecializationEnum;
import moon.adn.code.model.character.specializations.SpecializationValuesAbstract;

@Getter
@Setter
public class AbstractCharacter {
	protected Identity identity;
	protected Map<CaracteristicEnum, CaractValues> caracteristicsMap;
	protected Map<SkillEnum, SkillValues> skillsMap;
	protected Map<SpecializationEnum, SpecializationValuesAbstract> specializations;
	protected Map<CarreerEnum, Integer> carreersMap;
}
