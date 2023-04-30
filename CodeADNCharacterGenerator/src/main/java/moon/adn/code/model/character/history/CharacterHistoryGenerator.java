package moon.adn.code.model.character.history;

import java.util.Map;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.history.event.HistoryBadLuckEvent;
import moon.adn.code.model.character.history.event.HistoryEnemyEvent;
import moon.adn.code.model.character.history.event.HistoryFriendEvent;
import moon.adn.code.model.character.history.event.HistoryLuckEvent;
import moon.adn.code.model.character.history.event.HistoryRomanceEvent;
import moon.adn.code.model.character.history.raec.RAEC;
import moon.adn.code.model.character.history.raec.RAECEnum;
import moon.adn.code.model.character.history.raec.RAECProcedure;
import moon.adn.code.model.character.identity.AgeCategoryEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * @author Cédric DELRUE
 *
 */
@Getter
@Setter
public class CharacterHistoryGenerator {

	private int siblingCount = 0;
	private SpeciesEnum species;
	private int age;
	private Map<Integer, HistoryEventValue> eventsMap = new TreeMap<>();
	private Map<Integer, RAEC> raecMap = new TreeMap<>();

	CharacterHistory characterHistory = new CharacterHistory();

	public CharacterHistoryGenerator() {

	}

	public CharacterHistoryGenerator(Character character) {
		this(character.getIdentity().getSpecies(), character.getIdentity().getAge());
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

	private HistoryEventValue generateRandomEvent() {
		HistoryEventTypeEnum randomEvent = HistoryEventTypeEnum.random();
		HistoryEventValue hev = new HistoryEventValue();
		switch (randomEvent) {
		case LUCK: {
			HistoryLuckEvent hle = new HistoryLuckEvent();
			hev.setI18nCode(hle.randomEvent());
			break;
		}
		case BADLUCK: {
			HistoryBadLuckEvent hle = new HistoryBadLuckEvent();
			hev.setI18nCode(hle.randomEvent());
			break;
		}
		case FRIEND: {
			generateRAEC(RAECEnum.FRIEND);
			HistoryFriendEvent hle = new HistoryFriendEvent();
			hev.setI18nCode(hle.randomEvent());
			hev.setIdRAEC(getRaecMap().size());
			break;
		}
		case ENEMY: {
			generateRAEC(RAECEnum.ENEMY);
			HistoryEnemyEvent hle = new HistoryEnemyEvent();
			hev.setI18nCode(hle.randomEvent());
			hev.setIdRAEC(getRaecMap().size());
			break;
		}
		case ROMANCE: {
			generateRAEC(RAECEnum.ROMANCE);
			HistoryRomanceEvent hle = new HistoryRomanceEvent();
			hev.setI18nCode(hle.randomEvent());
			hev.setIdRAEC(getRaecMap().size());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + randomEvent);
		}
		return hev;
	}

	private void generateRAEC(RAECEnum raecEnum) {
		int count = raecMap.size();
		RAEC raec = new RAECProcedure(species, age).generate(raecEnum);
		raecMap.put(count + 1, raec);
	}

	private int randomNbEvents() {
		int result = 0;
		AgeCategoryEnum ageCategoryEnum = AgeCategoryEnum.getAgeCategory(age);
		for (AgeCategoryEnum age : ageCategoryEnum.getAgeCategoriesList()) {
			result += species.nbEventsbyAge(age);
		}
		return result;
	}
}
