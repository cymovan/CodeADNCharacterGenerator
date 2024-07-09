package moon.adn.code.character.generator.restcontroller;

import moon.adn.code.character.generator.CharacterParameters;
import moon.adn.code.model.character.AbstractCharacter;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.identity.SpeciesEnum;
import moon.adn.code.model.character.specializations.CareerEnum;

/**
 * Interface for a CharacterGenerator
 * 
 * @author Cédric DELRUE
 *
 */
public interface CharacterGeneratorController<T extends AbstractCharacter> {

	/**
	 * @return Standard {@link Character}
	 */
	T createCharacter();

	/**
	 * @param career
	 * @return Archetype {@link Character} from {@link CareerEnum}
	 */
	T createFromArchetype(CareerEnum career);

	/**
	 * @param career
	 * @return Archetype {@link Character} from {@link CareerEnum}
	 */
	T createFromSpeciesAndArchetype(SpeciesEnum species, CareerEnum career);	
	
	/**
	 * Only for tests
	 * 
	 * @return Human {@link Character} with good stats.
	 */
	T createHumanCharacter();
	
	/**
	 * Only for tests
	 * 
	 * @return Elf {@link Character} with good stats.
	 */
	T createElfCharacter();

	T createBararCharacter();

	/**
	 * @return {@link Character} with good stats.
	 */
	T createHeroicCharacter();

	/**
	 * @return {@link Character} with weak attributes.
	 */
	T createWeakCharacter();

	/**
	 * @return {@link CharacterParameters} from selected parameters.
	 */
	T createParametrizedCharacter(CharacterParameters params);
	
	/**
	 * @return
	 */
	T restoreCharacter();
}
