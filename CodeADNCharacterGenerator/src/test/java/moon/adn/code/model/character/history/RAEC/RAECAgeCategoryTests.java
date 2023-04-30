package moon.adn.code.model.character.history.RAEC;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.history.raec.RAECAgeCategoriesEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;

@SpringBootTest
public class RAECAgeCategoryTests {

	private static final int MIN_AGE = 13;
	private SpeciesEnum species;

	@Test
	public void whenAgeDiffAskedThenItsNeverUnderMinAge() {
		int result = 0;
		int age = 15;
		species = SpeciesEnum.HUMAN;
		for (RAECAgeCategoriesEnum ageCategoryEnum : RAECAgeCategoriesEnum.values()) {
			for (int i = 0; i < 150; i++) {
				result = ageCategoryEnum.ageDiff(species, age);
				assertThat(result + age).isGreaterThanOrEqualTo(MIN_AGE);
			}
		}
	}
}
