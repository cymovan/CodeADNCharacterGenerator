package moon.adn.code.character.generator.restcontroller;

import moon.adn.code.model.character.AbstractCharacter;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.specializations.CarreerEnum;

/**
 * Interface for a CharacterGenerator
 * 
 * @author Cédric DELRUE
 *
 */
public interface CharacterGeneratorController<Clazz extends AbstractCharacter> {

	/**
	 * @return Standard {@link Character}
	 */
	Clazz createCaracter();

	/**
	 * @param carreer
	 * @return Archetype {@link Character} from {@link CarreerEnum}
	 */
	Clazz createFromArchetype(CarreerEnum carreer);

	/**
	 * Only for tests
	 * 
	 * @return Elf {@link Character} with good stats.
	 */
	Clazz createElfCaracter();

	Character createBararCaracter();

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
