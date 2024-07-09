package moon.adn.code.character.generator;

import java.util.Map;

import moon.adn.code.model.character.history.raec.RAEC;
import moon.adn.code.model.character.identity.SpeciesEnum;

public interface RAECGenerator {
	/**
	 * @param species
	 * @param age
	 * @return
	 */
	RAEC generateRAEC(SpeciesEnum species, Integer age);

	/**
	 * Generate a sibling
	 * 
	 * @param species
	 * @param age
	 * @return
	 */
	Map<Integer, RAEC> generateSibling(SpeciesEnum species, Integer age);
}
