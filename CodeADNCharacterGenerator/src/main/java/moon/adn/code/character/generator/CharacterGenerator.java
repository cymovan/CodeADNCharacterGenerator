package moon.adn.code.character.generator;

import moon.adn.code.model.character.Character;

/**
 * Interface for a CharacterGenerator
 * 
 * @author cdelr
 *
 */
public interface CharacterGenerator {

	/**
	 * @return Standard {@link Character}
	 */
	Character createCaracter();

	/**
	 * Only for tests
	 * 
	 * @return Elf {@link Character} with good stats.
	 */
	Character createElfCaracter();

	/**
	 * @return {@link Character} with good stats.
	 */
	Character createHeroicCaracter();

	/**
	 * @return {@link Character} with weak attributes.
	 */
	Character createWeakCaracter();

	/**
	 * @return
	 */
	Character restoreCaracter();
}
