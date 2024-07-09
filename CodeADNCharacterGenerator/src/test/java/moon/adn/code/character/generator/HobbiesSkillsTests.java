package moon.adn.code.character.generator;

import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.AG;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.CON;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.EMP;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.INT;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.LUCK;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.POW;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.REF;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.STR;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.TECH;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.WILL;
import static moon.adn.code.model.character.specializations.CareerEnum.FIGHTER;
import static moon.adn.code.model.character.specializations.CareerEnum.GENERAL;
import static moon.adn.code.model.character.specializations.CareerEnum.MYSTIC;
import static moon.adn.code.model.character.specializations.CareerEnum.SCIENTIST;
import static moon.adn.code.model.character.specializations.CareerEnum.SPY;
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
import moon.adn.code.model.character.specializations.CareerEnum;

@SpringBootTest
class HobbiesSkillsTests {

	private CareerEnum career;
	private AbstractCharacter character;
	private final Map<CaracteristicEnum, CaractValues> mapCaracteristicsWithValues = new TreeMap<>();

	@BeforeEach
	void init() {
		character = new Character();
		initCaracteristicsMapWithRandomValues();
		character.setCaracteristicsMap(mapCaracteristicsWithValues);
	}

	@Test
	void whenCalculaterHobbiesPointsFromGeneralcareerThenItsCorrect() {
		career = GENERAL;
		assertByComparingHobbiesPointToExpectedValues(CON, WILL);
	}

	@Test
	void whenCalculaterHobbiesPointsFromFightercareerThenItsCorrect() {
		career = FIGHTER;
		assertByComparingHobbiesPointToExpectedValues(STR, REF);
	}

	@Test
	void whenCalculaterHobbiesPointsFromScientitscareerThenItsCorrect() {
		career = SCIENTIST;
		assertByComparingHobbiesPointToExpectedValues(INT, EMP);
	}

	@Test
	void whenCalculaterHobbiesPointsFromSpycareerThenItsCorrect() {
		career = SPY;
		assertByComparingHobbiesPointToExpectedValues(TECH, AG);
	}

	@Test
	void whenCalculaterHobbiesPointsFromMysticcareerThenItsCorrect() {
		career = MYSTIC;
		assertByComparingHobbiesPointToExpectedValues(POW, LUCK);
	}

	private void assertByComparingHobbiesPointToExpectedValues(CaracteristicEnum car1, CaracteristicEnum car2) {
		int score = CareerEnum.getHobbiesPoints(career, character);
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
