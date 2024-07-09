package moon.adn.code.model.character.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CaracteristicsModifierTests {

	private static final String MODIFIER_VALUE_ERROR = "Modifier value error";
	private static final String MODIFIER_MAX_VALUE_ERROR = "Modifier maxValue error";
	private static final String MODIFIER_MIN_VALUE_ERROR = "Modifier minValue error";

	private static final int MIN_CARACT_SCORE = 1;
	private static final int MAX_SCORE = 10;

	private int modifierValue = 0, minValue = 0;
	private CaracteristicsModifier modifier;

	@BeforeEach
	void initTests() {
	}

	@Test
	void whenCreatingModifierWithConstructorAndZeroValueThenDatasAreCorrects() {
		modifier = new CaracteristicsModifier(modifierValue);
		assertEquals(modifierValue, modifier.getValue(), MODIFIER_VALUE_ERROR);
		assertEquals(MIN_CARACT_SCORE, modifier.getMin(), MODIFIER_MIN_VALUE_ERROR);
		assertEquals(MAX_SCORE, modifier.getMax(), MODIFIER_MAX_VALUE_ERROR);
	}

	@Test
	void whenCreatingModifierWithConstructorAndPositiveValueThenDatasAreCorrects() {
		modifierValue = 5;
		modifier = new CaracteristicsModifier(modifierValue);
		assertEquals(modifierValue, modifier.getValue(), MODIFIER_VALUE_ERROR);
		assertEquals(MIN_CARACT_SCORE, modifier.getMin(), MODIFIER_MIN_VALUE_ERROR);
		assertEquals(MAX_SCORE + modifierValue, modifier.getMax(), MODIFIER_MAX_VALUE_ERROR);
	}

	@Test
	void whenCreatingModifierWithConstructorAndNegativeValueThenDatasAreCorrects() {
		modifierValue = -5;
		modifier = new CaracteristicsModifier(modifierValue);
		assertEquals(modifierValue, modifier.getValue(), MODIFIER_VALUE_ERROR);
		assertEquals(MIN_CARACT_SCORE, modifier.getMin(), MODIFIER_MIN_VALUE_ERROR);
		assertEquals(MAX_SCORE + modifierValue, modifier.getMax(), MODIFIER_MAX_VALUE_ERROR);
	}

	@Test
	void whenCreatingModifierWithPositiveValueAndMinValueThenDatasAreCorrects() {
		modifierValue = 4;
		minValue = 2;
		modifier = new CaracteristicsModifier(modifierValue, minValue);
		assertEquals(modifierValue, modifier.getValue(), MODIFIER_VALUE_ERROR);
		assertEquals(minValue, modifier.getMin(), MODIFIER_MIN_VALUE_ERROR);
		assertEquals(MAX_SCORE + modifierValue, modifier.getMax(), MODIFIER_MAX_VALUE_ERROR);
	}

	@Test
	void whenCreatingModifierWithNegativeValueAndMinValueThenDatasAreCorrects() {
		modifierValue = -3;
		minValue = 1;
		modifier = new CaracteristicsModifier(modifierValue, minValue);
		assertEquals(modifierValue, modifier.getValue(), MODIFIER_VALUE_ERROR);
		assertEquals(minValue, modifier.getMin(), MODIFIER_MIN_VALUE_ERROR);
		assertEquals(MAX_SCORE + modifierValue, modifier.getMax(), MODIFIER_MAX_VALUE_ERROR);
	}
}
