package moon.adn.code.character.generator;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.identity.SpeciesEnum;

@Getter
@Setter
public class CharacterParameters {
	Set<SpeciesEnum> speciesSet;
}
