package moon.adn.code.model.character.history.details;

import lombok.Data;
import moon.adn.code.model.character.history.HistoryRomanceEnum;

@Data
public class Romance {
	private HistoryRomanceEnum kindOfRomance;
	private String howItArrived;
	private int durationInMonths, durationInYears;

	public static Romance randomRomance() {
		Romance romance = new Romance();
		romance.setKindOfRomance(HistoryRomanceEnum.random());
		romance.setHowItArrived("Test");
		romance.setDurationInYears(5);
		return romance;
	}
}
