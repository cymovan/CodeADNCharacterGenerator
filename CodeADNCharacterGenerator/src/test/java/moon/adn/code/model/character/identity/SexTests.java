package moon.adn.code.model.character.identity;

import static moon.adn.code.model.character.identity.SexEnum.F;
import static moon.adn.code.model.character.identity.SexEnum.M;
import static moon.adn.code.model.character.identity.SexEnum.values;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SexTests {

	private static final int MAX_ITERATIONS_COUNT = 25;
	private static final int MAX_SEX_COUNT = 2;

	private static final String I18N_ROOT_SEX = "sex.";

	private SexEnum sex;
	private Set<SexEnum> sexEnumSet, verificationSet;

	@BeforeEach
	void init() {
		sexEnumSet = EnumSet.noneOf(SexEnum.class);
		verificationSet = EnumSet.noneOf(SexEnum.class);
		verificationSet.add(F);
		verificationSet.add(M);
	}

	@Test
	void checkSexEnumCountIsCorrect() {
		assertThat(values()).hasSize(MAX_SEX_COUNT);
	}

	@Test
	void whenAskedRandomSexItsOnlyMaleOrFemale() {
		for (int i = 0; i < MAX_ITERATIONS_COUNT; i++) {
			sex = SexEnum.random();
			sexEnumSet.add(sex);
		}
		assertThat(sexEnumSet).containsAll(verificationSet);
	}

	@Test
	void verifyI18NPrefix() {
		sex = SexEnum.random();
		String[] split = sex.i18nKey().split(sex.toString());
		assertThat(split[0]).isEqualTo(I18N_ROOT_SEX);
	}
}
