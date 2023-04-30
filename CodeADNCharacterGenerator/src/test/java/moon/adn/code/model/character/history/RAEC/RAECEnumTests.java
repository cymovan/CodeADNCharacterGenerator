package moon.adn.code.model.character.history.RAEC;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.history.raec.RAECEnum;

@SpringBootTest
public class RAECEnumTests {

	@Test
	public void whenAskingForRandomRAECSiblingThenItsWithoutSibling() {
		RAECEnum test = RAECEnum.random();
		Set<RAECEnum> setNotInResult = EnumSet.of(RAECEnum.BROTHER, RAECEnum.SISTER);
		for(int i =0; i < 500; i++) {
			assertThat(test).isNotIn(setNotInResult);
		}
		
	}
}
