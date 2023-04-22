package moon.adn.code.character.generator.restcontroller;

import moon.adn.code.model.character.AbstractCharacter;
import moon.adn.code.model.character.Character;

/**
 * Interface for a CharacterGenerator
 * 
 * @author cdelr
 *
 */
public interface CharacterGeneratorController<Clazz extends AbstractCharacter>{

	/**
	 * @return Standard {@link Character}
	 */
	Clazz createCaracter();

	/**
	 * Only for tests
	 * 
	 * @return Elf {@link Character} with good stats.
	 */
	Clazz createElfCaracter();

	/**
	 * @return {@link Character} with good stats.
	 */
	Clazz createHeroicCaracter();

	/**
	 * @return {@link Character} with weak attributes.
	 */
	Clazz createWeakCaracter();

	/**
	 * @return
	 */
	Clazz restoreCaracter();
}
