package moon.adn.code.character.generator;

import moon.adn.code.model.character.history.CharacterHistory;
import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * @author Cédric DELRUE
 *
 */
public interface HistoryGenerator {

	/**
	 * @param species
	 * @param age
	 * @return
	 */
	public CharacterHistory generate(SpeciesEnum species, int age);
}
