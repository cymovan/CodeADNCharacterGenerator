package moon.adn.code.model.character.history.details;

import static moon.adn.code.model.character.history.details.enemy.CulpritEnum.TIERS_FOOLS_ENNEMY;
import static moon.adn.code.model.character.history.details.enemy.CulpritEnum.TIERS_FOOLS_YOU;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.history.details.enemy.CulpritEnum;
import moon.adn.code.model.character.history.details.enemy.EnemyDetails;

@SpringBootTest
public class EnemyDetailsTests {
	private static final Pattern ROOT_I18N_THIRD_PARTY_PATTERN = Pattern.compile("^hist\\.enemy\\.thirdParty.*[0-1][0-9]$");
	private static final Pattern ROOT_I18N_WHAT_HAPPENED_PATTERN = Pattern.compile("hist\\.enemy\\.whatHappened.*([0-1][0-9]|2[0-4])$");

	@Test
	public void whenInstanctiatingAnEnemyDetailsThenRulesAreRespected() {
		for (int i = 0; i < 15000; i++) {
			EnemyDetails enemyDetails = EnemyDetails.random();
			assertThat(enemyDetails.getDoYouknowHim()).isNotNull();
			assertThat(enemyDetails.getWhoIsOffensed()).isNotNull();
			assertThat(enemyDetails.getWhatWillYouDo()).isNotNull();
			assertThat(enemyDetails.getWhatHappened()).matches(ROOT_I18N_WHAT_HAPPENED_PATTERN);

			CulpritEnum whoIsTheCulprit = enemyDetails.getWhoIsTheCulprit();
			assertThat(whoIsTheCulprit).isNotNull();

			String thirdPartyInvolved = enemyDetails.getThirdPartyInvolved();
			assertThirdPartyInvolvedIsCorrect(whoIsTheCulprit, thirdPartyInvolved);
		}
	}

	private void assertThirdPartyInvolvedIsCorrect(CulpritEnum whoIsTheCulprit, String thirdPartyInvolved) {
		if (TIERS_FOOLS_ENNEMY == whoIsTheCulprit || TIERS_FOOLS_YOU == whoIsTheCulprit) {
			assertThat(thirdPartyInvolved).matches(ROOT_I18N_THIRD_PARTY_PATTERN);
		} else {
			// No Tiers involved.
			assertThat(thirdPartyInvolved).isNull();
		}
	}
}
