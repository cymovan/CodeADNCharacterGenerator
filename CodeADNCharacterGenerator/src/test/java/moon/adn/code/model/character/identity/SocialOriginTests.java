package moon.adn.code.model.character.identity;

import static org.junit.jupiter.api.Assertions.*;

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

	private static final String SOCIAL_ORIGIN_MAX_DICE_ERROR = "Social origin max dice error";
	private static final String SOCIAL_ORIGIN_SCORE_ERROR = "Social origin score error";

	private SocialOriginEnum socialOrigin;

	@Test
	public void socialOriginStreetRulesChecked() {
		socialOrigin = SocialOriginEnum.STREET;
		assertEquals(MAX_D10_STREET, socialOrigin.getMaxD10Value(), SOCIAL_ORIGIN_MAX_DICE_ERROR);
		assertEquals(SOCIAL_SCORE_STREET, socialOrigin.getSocialOriginValue(), SOCIAL_ORIGIN_SCORE_ERROR);
	}

	@Test
	public void socialOriginLowClassRulesChecked() {
		socialOrigin = SocialOriginEnum.LOW_CLASS;
		assertEquals(MAX_D10_LOW_CLASS, socialOrigin.getMaxD10Value(), SOCIAL_ORIGIN_MAX_DICE_ERROR);
		assertEquals(SOCIAL_SCORE_LOW_CLASS, socialOrigin.getSocialOriginValue(), SOCIAL_ORIGIN_SCORE_ERROR);
	}

	@Test
	public void socialOriginMiddleClassRulesChecked() {
		socialOrigin = SocialOriginEnum.MIDDLE_CLASS;
		assertEquals(MAX_D10_MIDDLE_CLASS, socialOrigin.getMaxD10Value(), SOCIAL_ORIGIN_MAX_DICE_ERROR);
		assertEquals(SOCIAL_SCORE_MIDDLE_CLASS, socialOrigin.getSocialOriginValue(), SOCIAL_ORIGIN_SCORE_ERROR);
	}

	@Test
	public void socialOriginUpperClassRulesChecked() {
		socialOrigin = SocialOriginEnum.UPPER_CLASS;
		assertEquals(MAX_D10_UPPER_CLASS, socialOrigin.getMaxD10Value(), SOCIAL_ORIGIN_MAX_DICE_ERROR);
		assertEquals(SOCIAL_SCORE_UPPER_CLASS, socialOrigin.getSocialOriginValue(), SOCIAL_ORIGIN_SCORE_ERROR);
	}

	@Test
	public void socialOriginRichRulesChecked() {
		socialOrigin = SocialOriginEnum.RICH;
		assertEquals(MAX_D10_RICH, socialOrigin.getMaxD10Value(), SOCIAL_ORIGIN_MAX_DICE_ERROR);
		assertEquals(SOCIAL_SCORE_RICH, socialOrigin.getSocialOriginValue(), SOCIAL_ORIGIN_SCORE_ERROR);
	}

	@Test
	public void socialOriginNaohmRulesChecked() {
		socialOrigin = SocialOriginEnum.NAOHM;
		assertEquals(MAX_D10_NAOHM, socialOrigin.getMaxD10Value(), SOCIAL_ORIGIN_MAX_DICE_ERROR);
		assertEquals(SOCIAL_SCORE_NAOHM, socialOrigin.getSocialOriginValue(), SOCIAL_ORIGIN_SCORE_ERROR);
	}

	@Test
	public void whenRandmoSocialOriginCalledThenItsNeverNull() {
		for (int i = 0; i < 50; i++) {
			assertNotNull(SocialOriginEnum.randomSocialOrigin());
		}
	}
}
