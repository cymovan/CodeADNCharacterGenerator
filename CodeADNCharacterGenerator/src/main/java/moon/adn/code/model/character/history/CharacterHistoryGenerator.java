package moon.adn.code.model.character.history;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * @author cdelr
 *
 */
@Getter
@Setter
public class CharacterHistoryGenerator {

	private int siblingCount = 0;
	private SpeciesEnum species;
	private List<HistoryEventAbstract> eventsList = new ArrayList<>();

	public CharacterHistoryGenerator() {

	}

	/**
	 * @param species
	 */
	public CharacterHistoryGenerator(SpeciesEnum species) {
		this.species = species;
		this.siblingCount = species.randomSibling();
	}

	
	public String generate() {
		return new HistoryLuckEvent().randomEvent();
	}
}
