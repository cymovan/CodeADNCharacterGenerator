package moon.adn.code.model.character.identity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AgeCategoryEnumTests {
	private static int MAX_CHILD_AGE = 13;
	private static int MAX_TEEN_AGE = 19;
	private static int MAX_YOUNG_ADULT_AGE = 29;
	private static int MAX_ADULT_AGE = 49;
	private static int MAX_EXPERIMENTED_ADULT = 74;
	private static int MAX_OLD = 99;
	private static int MAX_OLDSTER = 124;
	private static int MAX_HUMAN = 149;
	private static int BEYOND_HUMAN_MAX = 9000;

	@Test
	public void whenAgeIsInChildAgeThenCategoryIsCorrect() {
		ageTests(0, MAX_CHILD_AGE, AgeCategoryEnum.CHILD);
	}

	@Test
	public void whenAgeIsInTeenAgeThenCategoryIsCorrect() {
		ageTests(MAX_CHILD_AGE + 1, MAX_TEEN_AGE, AgeCategoryEnum.TEENAGER);
	}

	@Test
	public void whenAgeIsInYoungAdultAgeThenCategoryIsCorrect() {
		ageTests(MAX_TEEN_AGE + 1, MAX_YOUNG_ADULT_AGE, AgeCategoryEnum.YOUNG_ADULT);
	}

	@Test
	public void whenAgeIsInAdultAgeThenCategoryIsCorrect() {
		ageTests(MAX_YOUNG_ADULT_AGE + 1, MAX_ADULT_AGE, AgeCategoryEnum.ADULT);

	}

	@Test
	public void whenAgeIsInExperimentedAdultAgeThenCategoryIsCorrect() {
		ageTests(MAX_ADULT_AGE + 1, MAX_EXPERIMENTED_ADULT, AgeCategoryEnum.EXPERIMENTED_ADULT);
	}

	@Test
	public void whenAgeIsInOldAgeThenCategoryIsCorrect() {
		ageTests(MAX_EXPERIMENTED_ADULT + 1, MAX_OLD, AgeCategoryEnum.OLD);
	}

	@Test
	public void whenAgeIsInOldsterAgeThenCategoryIsCorrect() {
		ageTests(MAX_OLD + 1, MAX_OLDSTER, AgeCategoryEnum.OLDSTER);
	}

	@Test
	public void whenAgeIsInMaxHumanAgeThenCategoryIsCorrect() {
		ageTests(MAX_OLDSTER + 1, MAX_HUMAN, AgeCategoryEnum.HUMAN_MAX);
	}

	@Test
	public void whenAgeIsBeyondHumanAgeThenCategoryIsCorrect() {
		ageTests(MAX_HUMAN + 1, BEYOND_HUMAN_MAX, AgeCategoryEnum.BEYOND_HUMAN_MAX);
	}

	private void ageTests(int minAgeForTests, int maxAgeForTest, AgeCategoryEnum ageCategory) {
		for (int i = minAgeForTests; i < maxAgeForTest; i++) {
			assertThat(AgeCategoryEnum.getAgeCategory(i)).isEqualTo(ageCategory);
		}
	}
}
