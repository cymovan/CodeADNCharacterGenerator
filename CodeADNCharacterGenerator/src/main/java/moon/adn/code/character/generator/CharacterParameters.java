package moon.adn.code.character.generator;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.archetypes.ArchetypeEnum;
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;

@Getter
@Setter
public class CharacterParameters {
	private Set<ArchetypeEnum> archetypesSet;
	private Set<SpeciesEnum> speciesSet;
	private SexEnum sex;
}
