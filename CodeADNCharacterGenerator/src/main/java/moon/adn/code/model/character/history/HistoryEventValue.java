package moon.adn.code.model.character.history;

import lombok.Data;

@Data
public class HistoryEventValue {
	private String i18nCode;
	private HistoryEventEnum historyEvent;
	private int idRAEC = 0;
}
