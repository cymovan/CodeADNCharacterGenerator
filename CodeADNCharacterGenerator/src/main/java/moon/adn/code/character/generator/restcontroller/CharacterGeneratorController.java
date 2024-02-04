package moon.adn.code.character.generator.restcontroller;

import moon.adn.code.character.generator.CharacterParameters;
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
	Clazz createCharacter();

	/**
	 * @param carreer
	 * @return Archetype {@link Character} from {@link CarreerEnum}
	 */
	Clazz createFromArchetype(CarreerEnum carreer);

	/**
	 * Only for tests
	 * 
	 * @return Human {@link Character} with good stats.
	 */
	Clazz createHumanCharacter();
	
	/**
	 * Only for tests
	 * 
	 * @return Elf {@link Character} with good stats.
	 */
	Clazz createElfCharacter();

	Clazz createBararCharacter();

	/**
	 * @return {@link Character} with good stats.
	 */
	Clazz createHeroicCharacter();

	/**
	 * @return {@link Character} with weak attributes.
	 */
	Clazz createWeakCharacter();

	/**
	 * @return {@link CharacterParameters} from selected parameters.
	 */
	Clazz createParametrizedCharacter(CharacterParameters params);
	
	/**
	 * @return
	 */
	Clazz restoreCharacter();
}
