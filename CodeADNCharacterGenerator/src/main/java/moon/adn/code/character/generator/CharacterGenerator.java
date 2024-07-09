package moon.adn.code.character.generator;

import moon.adn.code.model.archetypes.Archetype;
import moon.adn.code.model.character.AbstractCharacter;

public interface CharacterGenerator<T extends AbstractCharacter> {
	T build();

	T buildFromArchetype(Archetype archetype);
	
	T buildFromParameters(CharacterParameters params);
}
