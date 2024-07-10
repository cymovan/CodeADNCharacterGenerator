package moon.adn.code.model.character.caracteristics;

import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.AG;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.BT;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.CON;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.EMP;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.HEIGHT;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.INT;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.LUCK;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.POW;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.REF;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.STR;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.TECH;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.WILL;
import static moon.adn.code.system.RandomDiceUtil.d10;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.builder.CaracteristicsModifier;

@SpringBootTest
class CaracteristicsTests {

	private static final String MODIFIED_SCORE_ERRORS = "Modified Score errors";
	private static final int INIT_SCORE = 0;
	private static final int MIN_SCORE = 1;
	private static final int MAX_SCORE = 10;
	private static final int CARACTERISTICS_COUNT = 12;

	private TestsInitialization init = new TestsInitialization();

	private final Map<Integer, CaracteristicEnum> mapCaracteristics = new TreeMap<>();
	private final Map<CaracteristicEnum, CaractValues> mapCaracteristicsWithValues = new TreeMap<>();

	// Error codes
	private static final String MAXIMUM_CARACT_VALUES_ERROR = "Maximum caractValues error";
	private static final String CREATION_SCORE_CARACT_VALUES_ERROR = "Creation score caractValues error";
	private static final String CURRENT_SCORE_CARACT_VALUES_ERROR = "Current score caractValues error";
	private static final String MINIMUM_CARACT_VALUES_ERROR = "Minimum caractValues error";

	@BeforeEach
	void initTests() {
		init.initCaracts();
		init.initCaracteristicsMapValues();
	}

	@Test
	void thereAre12CaracteristicsAndPositionsAreCorrects() {
		assertEquals(CARACTERISTICS_COUNT, CaracteristicEnum.values().length,"Bad caractEnum count");
		for (CaracteristicEnum caract : CaracteristicEnum.values()) {
			assertEquals(caract, mapCaracteristics.get(caract.getPosition()), "Bad CaracteristicEnum position");
		}
	}

	@Test
	void whenCreatingCaractValuesThenScoresAreCorrects() {
		CaractValues caractValues = new CaractValues();
		assertEquals(INIT_SCORE, caractValues.getCreationValue(), CREATION_SCORE_CARACT_VALUES_ERROR);
		assertEquals(INIT_SCORE, caractValues.getCurrentValue(), CURRENT_SCORE_CARACT_VALUES_ERROR);
		assertEquals(MIN_SCORE, caractValues.getSpeciesMin(), MINIMUM_CARACT_VALUES_ERROR);
		assertEquals(MAX_SCORE, caractValues.getSpeciesMax(), MAXIMUM_CARACT_VALUES_ERROR);
	}

	@Test
	void whenCreatingCaractValuesWithInitialScoreThenScoresAreCorrects() {
		int initScore = d10();
		CaractValues caractValues = new CaractValues(initScore);
		assertEquals(initScore, caractValues.getCreationValue(), CREATION_SCORE_CARACT_VALUES_ERROR);
		assertEquals(initScore, caractValues.getCurrentValue(), CURRENT_SCORE_CARACT_VALUES_ERROR);
		assertEquals(MIN_SCORE, caractValues.getSpeciesMin(), MINIMUM_CARACT_VALUES_ERROR);
		assertEquals(MAX_SCORE, caractValues.getSpeciesMax(), MAXIMUM_CARACT_VALUES_ERROR);
	}

	@Test
	void whenApplyingCaracteristicSpeciesModifiersThenScoresAreCorrects() {
		int caractValue = 5;
		int modifierValue = -1;
		CaractValues caractValues = new CaractValues(caractValue);
		CaracteristicsModifier modifier = new CaracteristicsModifier(modifierValue);
		caractValues.applyCaractModifier(modifier);
		assertEquals(caractValue, caractValues.getCreationValue(), CREATION_SCORE_CARACT_VALUES_ERROR);
		assertEquals(caractValue + modifierValue, caractValues.getCurrentValue(), MODIFIED_SCORE_ERRORS);
		assertEquals(MIN_SCORE, caractValues.getSpeciesMin(), MINIMUM_CARACT_VALUES_ERROR);
		assertEquals(MAX_SCORE + modifierValue, caractValues.getSpeciesMax(), MAXIMUM_CARACT_VALUES_ERROR);
	}

	@Test
	void whenApplyingCaracteristicSpeciesModifiersBeyondMinDontGoUnderMinAndThenScoresAreCorrects() {
		int caractValue = 1;
		int modifierValue = -3;
		CaractValues caractValues = new CaractValues(caractValue);
		CaracteristicsModifier modifier = new CaracteristicsModifier(modifierValue);
		caractValues.applyCaractModifier(modifier);
		assertEquals(caractValue, caractValues.getCreationValue(), CREATION_SCORE_CARACT_VALUES_ERROR);
		assertEquals(MIN_SCORE, caractValues.getCurrentValue(), MODIFIED_SCORE_ERRORS);
		assertEquals(MIN_SCORE, caractValues.getSpeciesMin(), MINIMUM_CARACT_VALUES_ERROR);
		assertEquals(MAX_SCORE + modifierValue, caractValues.getSpeciesMax(), MAXIMUM_CARACT_VALUES_ERROR);
	}

	protected class TestsInitialization {
		private void initCaracts() {
			mapCaracteristics.put(1, INT);
			mapCaracteristics.put(2, REF);
			mapCaracteristics.put(3, TECH);
			mapCaracteristics.put(4, EMP);
			mapCaracteristics.put(5, BT);
			mapCaracteristics.put(6, STR);
			mapCaracteristics.put(7, CON);
			mapCaracteristics.put(8, LUCK);
			mapCaracteristics.put(9, AG);
			mapCaracteristics.put(10, HEIGHT);
			mapCaracteristics.put(11, WILL);
			mapCaracteristics.put(12, POW);
		}

		private void initCaracteristicsMapValues() {
			for (CaracteristicEnum caracts : CaracteristicEnum.values()) {
				mapCaracteristicsWithValues.put(caracts, new CaractValues(d10()));
			}
		}
	}
}
