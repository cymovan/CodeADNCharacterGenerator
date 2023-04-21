package moon.adn.code.model.character.history.details.romance;

import static moon.adn.code.model.character.history.details.romance.HistoryRomanceEnum.HOT_STORY;
import static moon.adn.code.model.character.history.details.romance.HistoryRomanceEnum.PROBLEMATIC_STORY;
import static moon.adn.code.model.character.history.details.romance.HistoryRomanceEnum.TRAGIC_STORY;

import lombok.Data;

@Data
public class Romance {
	private HistoryRomanceEnum kindOfRomance;
	private HowItArrivedEnum howItArrived;
	private RomanceDurationEnum duration;
	private int durationInMonths, durationInYears;
	private String tragicOrProblematicStory;
	private MutualFeelingsEnum mutualFeelings;

	public static Romance randomRomance() {
		Romance romance = new Romance();
		romance.kindOfRomance = HistoryRomanceEnum.random();
		romance.howItArrived = HowItArrivedEnum.random();
		romance.mutualFeelings = MutualFeelingsEnum.random();
		storyDuration(romance);
		tragicOrProblematicStory(romance);
		return romance;
	}

	private static void storyDuration(Romance romance) {
		if (HOT_STORY == romance.kindOfRomance) {
			romance.duration = RomanceDurationEnum.randomHotRelation();
		} else {
			romance.duration = RomanceDurationEnum.randomFromRules();
		}
		RomanceDurationEnum.defineRomanceDurationInMonthsAndYears(romance);
	}

	private static void tragicOrProblematicStory(Romance romance) {
		if (PROBLEMATIC_STORY == romance.kindOfRomance) {
			romance.tragicOrProblematicStory = new ProblematicLoveStory().randomEvent();
		} else if (TRAGIC_STORY == romance.kindOfRomance) {
			romance.tragicOrProblematicStory = new TragicLoveStory().randomEvent();
		}
	}
	
}
