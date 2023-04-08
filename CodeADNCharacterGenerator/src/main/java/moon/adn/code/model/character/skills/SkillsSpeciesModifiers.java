package moon.adn.code.model.character.skills;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.builder.Modifier;

/**
 * Class used to stock species modifiers applied on Character build process.
 * 
 * @author cdelr
 *
 */
@Getter
@Setter
public class SkillsSpeciesModifiers {
	private Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();

}
