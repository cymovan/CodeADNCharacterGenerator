package moon.adn.code.model.character.history;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import moon.adn.code.model.character.history.raec.RAEC;

@Data
@NoArgsConstructor
public class CharacterHistory {
	private List<HistoryEventAbstract> eventsList;
	private Map<Integer, RAEC> siblingsMap;
}
