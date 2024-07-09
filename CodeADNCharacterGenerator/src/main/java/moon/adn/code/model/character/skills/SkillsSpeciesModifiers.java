package moon.adn.code.model.character.skills;

import java.util.EnumMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.builder.Modifier;

/**
 * Class used to stock species modifiers applied on Character build process.
 * 
 * @author Cédric DELRUE
 *
 */
@Getter
@Setter
public class SkillsSpeciesModifiers {
	private Map<SkillEnum, Modifier> modifiersMap = new EnumMap<>(SkillEnum.class);

}
