package moon.adn.code.model.character;

import java.util.Map;
import java.util.TreeMap;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.history.HistoryEventValue;
import moon.adn.code.model.character.history.raec.RAEC;

/**
 * Character class for a PC in Code 🧬.
 * 
 * @author Cédric DELRUE
 */
@Getter
@Setter
public class Character extends AbstractCharacter {
	private Map<Integer, HistoryEventValue> eventsMap = new TreeMap<>();
	private Map<Integer, RAEC> raecMap = new TreeMap<>();
}
