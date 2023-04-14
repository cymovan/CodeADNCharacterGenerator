package moon.adn.code.model.character.history;

import java.util.Map;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.history.raec.RAEC;
import moon.adn.code.model.character.history.raec.RAECEnum;
import moon.adn.code.model.character.history.raec.RAECProcedure;
import moon.adn.code.model.character.identity.SpeciesEnum;
import moon.adn.code.system.RandomDiceUtil;
import static moon.adn.code.model.character.history.raec.RAECEnum.*;

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
	private Map<Integer, String> eventsMap = new TreeMap<>();
	private Map<Integer, RAEC> raecMap = new TreeMap<>();

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
		generateHistoryEvents();
		characterHistory.setRaecMap(raecMap);
		characterHistory.setEventsMap(eventsMap);
		return characterHistory;
	}

	public void generateSiblings() {
		this.siblingCount = species.randomSibling();
		for (int i = 0; i < siblingCount; i++) {
			RAEC sibling = new RAECProcedure(species, age).generateSibling();
			raecMap.put(i + 1, sibling);
		}
	}

	private void generateHistoryEvents() {
		int nb = randomNbEvents();
		for (int i = 0; i < nb; i++) {
			eventsMap.put(i + 1, generateRandomEvent());
		}
	}

	private String generateRandomEvent() {
		HistoryEventTypeEnum randomEvent = HistoryEventTypeEnum.random();

		switch (randomEvent) {
		case LUCK: {
			return new HistoryLuckEvent().randomEvent();
		}
		case BADLUCK: {
			return new HistoryBadLuckEvent().randomEvent();
		}
		case FRIEND: {
			generateRAEC(RAECEnum.FRIEND);
			return new HistoryFriendEvent().randomEvent();
		} case ENEMY: {
			generateRAEC(RAECEnum.ENEMY);
			return "Not Implemented yet !";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + randomEvent);
		}
	}

	private void generateRAEC(RAECEnum raecEnum) {
		int count = raecMap.size();
		RAEC raec = new RAECProcedure(species, age).generate(raecEnum);
		raecMap.put(count + 1, raec);
	}

	private int randomNbEvents() {
		return RandomDiceUtil.d6() * 2;
	}
}
