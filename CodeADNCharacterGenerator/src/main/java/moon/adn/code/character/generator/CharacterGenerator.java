package moon.adn.code.character.generator;

import moon.adn.code.model.character.AbstractCharacter;

public interface CharacterGenerator<Clazz extends AbstractCharacter> {
	Clazz build();
}
