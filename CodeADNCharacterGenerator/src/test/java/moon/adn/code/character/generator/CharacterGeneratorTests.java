package moon.adn.code.character.generator;

import static moon.adn.code.system.RandomDiceUtil.d10;
import static org.assertj.core.api.Assertions.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.archetypes.fighters.RoninArchetype;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.identity.Identity;

@SpringBootTest
public class CharacterGeneratorTests {

	private static final int CARACTERISTICS_COUNT = 12;
	private CharacterGeneratorImpl characterGenerator;
	private Character character;

	@BeforeEach
	public void initTests() {
		this.characterGenerator = new CharacterGeneratorImpl();
	}

	@Test
	public void whenGenerateARandomCaractersThenRulesAreCorrectAndCharacterIsCorrect() {
		characterGenerator.setCaracteristicsMap(randomCaracteristics());
		this.character = this.characterGenerator.build();
		assertThat(character.getCaracteristicsMap()).size().isEqualTo(CARACTERISTICS_COUNT);
		identityAssertions(character.getIdentity());
		assertThat(character.getSkillsMap()).size().isGreaterThan(5);
		assertThat(character.getSpecializations()).size().isGreaterThanOrEqualTo(1);
		assertThat(character.getEventsMap()).size().isPositive();
		assertThat(character.getRaecMap()).size().isPositive();
		assertThat(character.getCareersMap()).size().isPositive();
	}

	@Test
	public void whenGenerateARandomCaractersFromArchetypeThenRulesAreCorrectAndCharacterIsCorrect() {
		this.character = this.characterGenerator.buildFromArchetype(new RoninArchetype().getArchetype());
		assertThat(character.getCaracteristicsMap()).size().isEqualTo(CARACTERISTICS_COUNT);
		identityAssertions(character.getIdentity());
		assertThat(character.getSkillsMap()).size().isGreaterThan(5);
//		assertThat(character.getSpecializations().size()).isGreaterThan(3);
		assertThat(character.getEventsMap()).size().isPositive();
		assertThat(character.getRaecMap()).size().isPositive();
		assertThat(character.getCareersMap()).size().isPositive();

	}

	private void identityAssertions(Identity identity) {
		assertThat(identity).hasNoNullFieldsOrProperties();
		assertThat(identity.getSocialOrigin()).isPositive();
	}

	private Map<CaracteristicEnum, CaractValues> randomCaracteristics() {
		Map<CaracteristicEnum, CaractValues> mapCaracteristics = new TreeMap<>();
		for (CaracteristicEnum caract : CaracteristicEnum.values()) {
			mapCaracteristics.put(caract, new CaractValues(d10()));
		}
		return mapCaracteristics;
	}
}
