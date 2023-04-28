package moon.adn.code.model.character.identity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SocialOriginTests {

	private static final int MAX_D10_STREET = 2;
	private static final int MAX_D10_LOW_CLASS = 5;
	private static final int MAX_D10_MIDDLE_CLASS = 7;
	private static final int MAX_D10_UPPER_CLASS = 8;
	private static final int MAX_D10_RICH = 9;
	private static final int MAX_D10_NAOHM = 10;

	private static final int SOCIAL_SCORE_STREET = 1;
	private static final int SOCIAL_SCORE_LOW_CLASS = 3;
	private static final int SOCIAL_SCORE_MIDDLE_CLASS = 6;
	private static final int SOCIAL_SCORE_UPPER_CLASS = 10;
	private static final int SOCIAL_SCORE_RICH = 13;
	private static final int SOCIAL_SCORE_NAOHM = 16;

	private SocialOriginEnum socialOrigin;

	@Test
	public void socialOriginStreetRulesChecked() {
		socialOrigin = SocialOriginEnum.STREET;
		assertThat(socialOrigin.getMaxD10Value()).isEqualTo(MAX_D10_STREET);
		assertThat(socialOrigin.getSocialOriginValue()).isEqualTo(SOCIAL_SCORE_STREET);
	}

	@Test
	public void socialOriginLowClassRulesChecked() {
		socialOrigin = SocialOriginEnum.LOW_CLASS;
		assertThat(socialOrigin.getMaxD10Value()).isEqualTo(MAX_D10_LOW_CLASS);
		assertThat(socialOrigin.getSocialOriginValue()).isEqualTo(SOCIAL_SCORE_LOW_CLASS);
	}

	@Test
	public void socialOriginMiddleClassRulesChecked() {
		socialOrigin = SocialOriginEnum.MIDDLE_CLASS;
		assertThat(socialOrigin.getMaxD10Value()).isEqualTo(MAX_D10_MIDDLE_CLASS);
		assertThat(socialOrigin.getSocialOriginValue()).isEqualTo(SOCIAL_SCORE_MIDDLE_CLASS);
	}

	@Test
	public void socialOriginUpperClassRulesChecked() {
		socialOrigin = SocialOriginEnum.UPPER_CLASS;
		assertThat(socialOrigin.getMaxD10Value()).isEqualTo(MAX_D10_UPPER_CLASS);
		assertThat(socialOrigin.getSocialOriginValue()).isEqualTo(SOCIAL_SCORE_UPPER_CLASS);
	}

	@Test
	public void socialOriginRichRulesChecked() {
		socialOrigin = SocialOriginEnum.RICH;
		assertThat(socialOrigin.getMaxD10Value()).isEqualTo(MAX_D10_RICH);
		assertThat(socialOrigin.getSocialOriginValue()).isEqualTo(SOCIAL_SCORE_RICH);
	}

	@Test
	public void socialOriginNaohmRulesChecked() {
		socialOrigin = SocialOriginEnum.NAOHM;
		assertThat(socialOrigin.getMaxD10Value()).isEqualTo(MAX_D10_NAOHM);
		assertThat(socialOrigin.getSocialOriginValue()).isEqualTo(SOCIAL_SCORE_NAOHM);
	}

	@Test
	public void whenRandmoSocialOriginCalledThenItsNeverNull() {
		for (int i = 0; i < 50; i++) {
			assertThat(SocialOriginEnum.randomSocialOrigin()).isNotNull();
		}
	}
}
