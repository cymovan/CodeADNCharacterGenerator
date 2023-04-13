package moon.adn.code.model.character;

import java.util.Map;
import java.util.TreeMap;

import lombok.Data;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.history.CharacterHistory;
import moon.adn.code.model.character.history.raec.RAEC;
import moon.adn.code.model.character.identity.Identity;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillValues;
import moon.adn.code.model.character.specializations.SpecializationEnum;
import moon.adn.code.model.character.specializations.SpecializationValuesAbstract;

/**
 * Character class for a PC or NPC in Code 🧬.
 * 
 * @author cdelr
 */
@Data
public class Character {
	private Identity identity;
	private Map<CaracteristicEnum, CaractValues> caracteristicsMap;
	private Map<SkillEnum, SkillValues> skillsMap;
	private Map<Integer, RAEC> siblingsMap = new TreeMap<>();
	private Map<Integer, CharacterHistory> eventsMap = new TreeMap<>();
	private Map<SpecializationEnum, SpecializationValuesAbstract> specializations;
}
