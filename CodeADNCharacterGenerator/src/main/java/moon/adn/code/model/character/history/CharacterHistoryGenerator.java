package moon.adn.code.model.character.history;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.history.raec.RAEC;
import moon.adn.code.model.character.history.raec.RAECProcedure;
import moon.adn.code.model.character.identity.SpeciesEnum;
import moon.adn.code.system.RandomDiceUtil;

/**
 * @author cdelr
 *
 */
@Getter
@Setter
public class CharacterHistoryGenerator {

	private int siblingCount = 0;
	private SpeciesEnum species;
	private int age;
	private List<HistoryEventAbstract> eventsList = new ArrayList<>();
	private Map<Integer, RAEC> siblingsMap = new TreeMap<>();

	CharacterHistory characterHistory = new CharacterHistory();

	public CharacterHistoryGenerator() {

	}

	public CharacterHistoryGenerator(Character character) {
		this(character.getIdentity().getSpecies(), 0);
	}

	/**
	 * @param species
	 */
	public CharacterHistoryGenerator(SpeciesEnum species, int age) {
		this.species = species;
		this.age = age;

	}

	public CharacterHistory generate() {
		generateSiblings();
		characterHistory.setSiblingsMap(siblingsMap);
		return characterHistory;
	}

	public void generateSiblings() {
		this.siblingCount = species.randomSibling();
		for (int i = 0; i < siblingCount; i++) {
			RAEC sibling = new RAECProcedure(species, age).generateSibling();
			siblingsMap.put(i+1, sibling);
		}
	}

	private int randomNbEvents() {
		return RandomDiceUtil.d6() * 2;
	}
}
