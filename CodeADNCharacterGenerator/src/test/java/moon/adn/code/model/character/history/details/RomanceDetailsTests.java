package moon.adn.code.model.character.history.details;

import static moon.adn.code.model.character.history.details.romance.HistoryRomanceEnum.PROBLEMATIC_STORY;
import static moon.adn.code.model.character.history.details.romance.HistoryRomanceEnum.TRAGIC_STORY;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import moon.adn.code.model.character.history.details.romance.HistoryRomanceEnum;
import moon.adn.code.model.character.history.details.romance.Romance;
import moon.adn.code.model.character.history.details.romance.RomanceDurationEnum;

class RomanceDetailsTests {
	private static final Pattern ROOT_I18N_TRAGIC_OR_PROBLEMATIC_PATTERN = Pattern
			.compile("^hist\\.(tragic|problematic)LoveStory(0[0-9]|1[0-4])$");

	private Romance romance;

	@Test
	void whenInstanctiatingARomanceDetailsThenRulesAreRespected() {
		for (int i = 0; i < 15000; i++) {
			romance = Romance.randomRomance();
			HistoryRomanceEnum kindOfRomance = romance.getKindOfRomance();
			assertThat(kindOfRomance).isNotNull();
			assertThat(romance.getHowItArrived()).isNotNull();
			assertThatDurationIsCorrect(romance.getDuration(), romance.getDurationInMonths(),
					romance.getDurationInYears());
			assertThat(romance.getMutualFeelings()).isNotNull();
			assertTragicOrProblematicIsCorrect(kindOfRomance, romance.getTragicOrProblematicStory());
		}
	}

	private void assertTragicOrProblematicIsCorrect(HistoryRomanceEnum kindOfRomance, String tragicOrProblematicStory) {
		if (TRAGIC_STORY == kindOfRomance || PROBLEMATIC_STORY == kindOfRomance) {
			assertThat(tragicOrProblematicStory).matches(ROOT_I18N_TRAGIC_OR_PROBLEMATIC_PATTERN);
		} else {
			assertThat(tragicOrProblematicStory).isNull();
		}
	}

	private void assertThatDurationIsCorrect(RomanceDurationEnum duration, int durationInMonths, int durationInYears) {
		assertThat(duration).isNotNull();
		switch (duration) {
		case FOREVER:
			assertThat(durationInMonths).isZero();
			assertThat(durationInYears).isZero();
			break;
		case SEVERAL_TIMES, COUPLE_OF_WEEKS_MONTHS:
			assertThat(durationInMonths).isGreaterThan(0);
			assertThat(durationInYears).isZero();
			break;
		case FEW_YEARS, LONG_STORY, SOME_YEARS:
			assertThat(durationInMonths).isZero();
			assertThat(durationInYears).isGreaterThan(0);
			break;
		default:
			throw new RuntimeException("New duration with no test : " + duration.name());
		}
	}
}
