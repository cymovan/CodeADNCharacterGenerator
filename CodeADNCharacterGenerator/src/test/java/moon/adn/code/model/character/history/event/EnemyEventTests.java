package moon.adn.code.model.character.history.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnemyEventTests {

	private static final int maxCountI18N = 6;
	private static final String I18NRoot = "hist.enemy";

	@Test
	public void whenInitializingRandomEnemyEventThenItsInRangeDefinedInRulesBook() {
		HistoryEnemyEvent hee = new HistoryEnemyEvent();
		for (int i = 0; i < 100; i++) {
			String result = hee.randomEvent();
			int value = Integer.parseInt(result.substring(10));
			assertThat(value).isBetween(0, maxCountI18N);
		}
	}

}
