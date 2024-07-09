package moon.adn.code.model.character.history.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnemyEventTests {

	private static final int MAX_COUNT_I18N = 6;
	private static final String I18N_ROOT = "hist.enemy";

	@Test
	void whenInitializingRandomEnemyEventThenItsInRangeDefinedInRulesBook() {
		HistoryEnemyEvent hee = new HistoryEnemyEvent();
		for (int i = 0; i < 100; i++) {
			String result = hee.randomEvent();
			int value = Integer.parseInt(result.substring(10));
			assertThat(value).isBetween(0, MAX_COUNT_I18N);
		}
	}

}
