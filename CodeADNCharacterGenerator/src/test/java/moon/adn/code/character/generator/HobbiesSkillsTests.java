package moon.adn.code.character.generator;

import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.*;
import static moon.adn.code.model.character.specializations.CarreerEnum.*;
import static moon.adn.code.system.RandomDiceUtil.d10;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.AbstractCharacter;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.specializations.CarreerEnum;

@SpringBootTest
public class HobbiesSkillsTests {

	private CarreerEnum carreer;
	private AbstractCharacter character;
	private final Map<CaracteristicEnum, CaractValues> mapCaracteristicsWithValues = new TreeMap<>();

	@BeforeEach
	public void init() {
		character = new Character();
		initCaracteristicsMapWithRandomValues();
		character.setCaracteristicsMap(mapCaracteristicsWithValues);
	}

	@Test
	public void whenCalculaterHobbiesPointsFromGeneralCarreerThenItsCorrect() {
		carreer = GENERAL;
		assertByComparingHobbiesPointToExpectedValues(CON, WILL);
	}

	@Test
	public void whenCalculaterHobbiesPointsFromFighterCarreerThenItsCorrect() {
		carreer = FIGHTER;
		assertByComparingHobbiesPointToExpectedValues(STR, REF);
	}

	@Test
	public void whenCalculaterHobbiesPointsFromScientitsCarreerThenItsCorrect() {
		carreer = SCIENTIST;
		assertByComparingHobbiesPointToExpectedValues(INT, EMP);
	}

	@Test
	public void whenCalculaterHobbiesPointsFromSpyCarreerThenItsCorrect() {
		carreer = SPY;
		assertByComparingHobbiesPointToExpectedValues(TECH, AG);
	}

	@Test
	public void whenCalculaterHobbiesPointsFromMysticCarreerThenItsCorrect() {
		carreer = MYSTIC;
		assertByComparingHobbiesPointToExpectedValues(POW, LUCK);
	}

	private void assertByComparingHobbiesPointToExpectedValues(CaracteristicEnum car1, CaracteristicEnum car2) {
		int score = CarreerEnum.getHobbiesPoints(carreer, character);
		int car1Score = mapCaracteristicsWithValues.get(car1).getCurrentValue();
		int car2Score = mapCaracteristicsWithValues.get(car2).getCurrentValue();
		int scoreToCompare = (car1Score + car2Score) * 2;
		assertThat(score).isEqualTo(scoreToCompare);
	}

	private void initCaracteristicsMapWithRandomValues() {
		for (CaracteristicEnum caracts : CaracteristicEnum.values()) {
			mapCaracteristicsWithValues.put(caracts, new CaractValues(d10()));
		}
	}
}
