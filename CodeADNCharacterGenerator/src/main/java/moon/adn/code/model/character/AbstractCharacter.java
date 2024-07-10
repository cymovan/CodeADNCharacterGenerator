package moon.adn.code.model.character;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonKey;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.identity.Identity;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillValues;
import moon.adn.code.model.character.specializations.CareerEnum;
import moon.adn.code.model.character.specializations.SpecializationEnum;
import moon.adn.code.model.character.specializations.SpecializationValuesAbstract;

@Getter
@Setter
public class AbstractCharacter implements Serializable {
	private static final long serialVersionUID = -2650578762828235904L;

	protected Identity identity;
	@JsonKey
	private Map<CaracteristicEnum, CaractValues> caracteristicsMap;

	@JsonKey
	private Map<SkillEnum, SkillValues> skillsMap;

	@JsonKey
	private Map<SpecializationEnum, SpecializationValuesAbstract> specializations;

	@JsonKey
	private Map<CareerEnum, Integer> careersMap;
}
