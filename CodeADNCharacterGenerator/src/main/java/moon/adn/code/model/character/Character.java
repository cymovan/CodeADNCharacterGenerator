package moon.adn.code.model.character;

import java.util.Map;

import lombok.Data;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.identity.Identity;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillValues;

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
}
