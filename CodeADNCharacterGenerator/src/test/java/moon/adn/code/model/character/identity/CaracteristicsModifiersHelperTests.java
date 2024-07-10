package moon.adn.code.model.character.identity;

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
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.builder.CaracteristicSpeciesModifiers;
import moon.adn.code.model.character.builder.CaracteristicsModifier;
import moon.adn.code.model.character.builder.Modifier;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

@SpringBootTest
class CaracteristicsModifiersHelperTests {

	private CaracteristicSpeciesModifiers csm;
	private Map<CaracteristicEnum, Modifier> caractsModifierMap;

	@Test
	void whenHumanModifiersCaractModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.humanModifiers();
		this.caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(1);
		compareCaracteristicsModifiers(2, LUCK);
	}

	@Test
	void whenSylvanElfModifiersCaractThenModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.sylvanElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(8);
		compareCaracteristicsModifiers(2, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(-1, INT);
		compareCaracteristicsModifiers(1, REF);
		compareCaracteristicsModifiers(1, 5, HEIGHT);
		compareCaracteristicsModifiers(-1, TECH);
	}

	@Test
	void whenUrbanElfModifiersCaractThenModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.urbanElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(4);
		compareCaracteristicsModifiers(1, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(-1, STR);
	}

	@Test
	void whenPaleElfModifiersCaractThenModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.paleElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(8);
		compareCaracteristicsModifiers(1, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(2, EMP);
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(1, POW);
		compareCaracteristicsModifiers(1, 5, HEIGHT);
		compareCaracteristicsModifiers(-2, TECH);
	}

	@Test
	void whenGreyElfModifiersCaractThenModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.greyElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(6);
		compareCaracteristicsModifiers(1, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(1, LUCK);
		compareCaracteristicsModifiers(-2, CON);
		compareCaracteristicsModifiers(-2, STR);
		compareCaracteristicsModifiers(2, POW);
	}

	@Test
	void whenGoldElfModifiersCaractThenModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.goldElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(7);
		compareCaracteristicsModifiers(2, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(2, POW);
		compareCaracteristicsModifiers(2, 6, HEIGHT);
		compareCaracteristicsModifiers(-2, TECH);
	}

	@Test
	void whenNightElfModifiersCaractThenModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.nightElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(5);
		compareCaracteristicsModifiers(2, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(1, 5, HEIGHT);
	}

	@Test
	void whenAquaticElfModifiersCaractThenModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.aquaticElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(5);
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(1, REF);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(1, AG);
		compareCaracteristicsModifiers(1, 6, HEIGHT);
	}

	@Test
	void whenDarkElfModifiersCaractThenModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.darkElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(6);
		compareCaracteristicsModifiers(1, AG);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(-1, EMP);
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(2, REF);
		compareCaracteristicsModifiers(-2, 1, 7, HEIGHT);
	}

	@Test
	void whenIronBararModifiersCaractThenModifiersAreGood() {
		this.csm = CaracteristicModifiersHelper.ironBararModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertThat(caractsModifierMap).hasSize(10);
		compareCaracteristicsModifiers(-1, AG);
		compareCaracteristicsModifiers(-2, BT);
		compareCaracteristicsModifiers(2, CON);
		compareCaracteristicsModifiers(-1, EMP);
		compareCaracteristicsModifiers(2, STR);
		compareCaracteristicsModifiers(-2, POW);
		compareCaracteristicsModifiers(-1, REF);
		compareCaracteristicsModifiers(-3, 1, 5, HEIGHT);
		compareCaracteristicsModifiers(2, TECH);
		compareCaracteristicsModifiers(2, WILL);
	}

	private void compareCaracteristicsModifiers(int score, CaracteristicEnum caract) {
		Modifier modifier = new CaracteristicsModifier(score);
		assertThat(caractsModifierMap).containsEntry(caract, modifier);
	}

	private void compareCaracteristicsModifiers(int score, int min, CaracteristicEnum caract) {
		Modifier modifier = new CaracteristicsModifier(score, min);
		assertThat(caractsModifierMap).containsEntry(caract, modifier);
	}

	private void compareCaracteristicsModifiers(int score, int min, int max, CaracteristicEnum caract) {
		Modifier modifier = new CaracteristicsModifier(score, min, max);
		assertThat(caractsModifierMap).containsEntry(caract, modifier);
	}
}
