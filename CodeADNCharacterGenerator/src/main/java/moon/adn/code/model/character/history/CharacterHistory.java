package moon.adn.code.model.character.history;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import moon.adn.code.model.character.history.raec.RAEC;

@Data
@NoArgsConstructor
public class CharacterHistory {
	private Map<Integer, String> eventsMap;
	private Map<Integer, RAEC> raecMap;
}
