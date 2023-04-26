package moon.adn.code.model.character.identity;

import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.builder.CaracteristicSpeciesModifiers;
import moon.adn.code.model.character.builder.CaracteristicsModifier;
import moon.adn.code.model.character.builder.Modifier;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

@SpringBootTest
public class CaracteristicsModifiersHelperTests {

	private static final String BAD = "Bad ";

	private static final String MODIFIER_COUNT_FOR = "caractModifiers count for ";
	private static final String MODIFIER_FOR = "modifier for ";

	private SpeciesEnum species;
	private CaracteristicSpeciesModifiers csm;
	private Map<CaracteristicEnum, Modifier> caractsModifierMap;

	@Test
	public void whenHumanModifiersCaractModifiersAreGood() {
		this.species = SpeciesEnum.HUMAN;
		this.csm = CaracteristicModifiersHelper.humanModifiers();
		this.caractsModifierMap = csm.getModifiersMap();
		assertEquals(1, caractsModifierMap.size(), constructErrorModifierCountMessage(species));
		compareCaracteristicsModifiers(2, LUCK);
	}

	@Test
	public void whenSylvanElfModifiersCaractThenModifiersAreGood() {
		this.species = SpeciesEnum.S_SYLV;
		this.csm = CaracteristicModifiersHelper.sylvanElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertEquals(8, caractsModifierMap.size(), constructErrorModifierCountMessage(species));
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
	public void whenUrbanElfModifiersCaractThenModifiersAreGood() {
		this.species = SpeciesEnum.S_URB;
		this.csm = CaracteristicModifiersHelper.urbanElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertEquals(4, caractsModifierMap.size(), constructErrorModifierCountMessage(species));
		compareCaracteristicsModifiers(1, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(-1, STR);
	}

	@Test
	public void whenPaleElfModifiersCaractThenModifiersAreGood() {
		this.species = SpeciesEnum.S_PALE;
		this.csm = CaracteristicModifiersHelper.paleElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertEquals(8, caractsModifierMap.size(), constructErrorModifierCountMessage(species));
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
	public void whenGreyElfModifiersCaractThenModifiersAreGood() {
		this.species = SpeciesEnum.S_GREY;
		this.csm = CaracteristicModifiersHelper.greyElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertEquals(6, caractsModifierMap.size(), constructErrorModifierCountMessage(species));
		compareCaracteristicsModifiers(1, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(1, LUCK);
		compareCaracteristicsModifiers(-2, CON);
		compareCaracteristicsModifiers(-2, STR);
		compareCaracteristicsModifiers(2, POW);
	}

	@Test
	public void whenGoldElfModifiersCaractThenModifiersAreGood() {
		this.species = SpeciesEnum.S_GOLD;
		this.csm = CaracteristicModifiersHelper.goldElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertEquals(7, caractsModifierMap.size(), constructErrorModifierCountMessage(species));
		compareCaracteristicsModifiers(2, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(2, POW);
		compareCaracteristicsModifiers(2, 6, HEIGHT);
		compareCaracteristicsModifiers(-2, TECH);
	}

	@Test
	public void whenNightElfModifiersCaractThenModifiersAreGood() {
		this.species = SpeciesEnum.S_NIGHT;
		this.csm = CaracteristicModifiersHelper.nightElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertEquals(5, caractsModifierMap.size(), constructErrorModifierCountMessage(species));
		compareCaracteristicsModifiers(2, AG);
		compareCaracteristicsModifiers(1, BT);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(1, 5, HEIGHT);
	}

	@Test
	public void whenAquaticElfModifiersCaractThenModifiersAreGood() {
		this.species = SpeciesEnum.S_AQUA;
		this.csm = CaracteristicModifiersHelper.aquaticElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertEquals(5, caractsModifierMap.size(), constructErrorModifierCountMessage(species));
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(1, REF);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(1, AG);
		compareCaracteristicsModifiers(1, 6, HEIGHT);
	}

	@Test
	public void whenDarkElfModifiersCaractThenModifiersAreGood() {
		this.species = SpeciesEnum.S_DARK;
		this.csm = CaracteristicModifiersHelper.darkElfModifiers();
		caractsModifierMap = csm.getModifiersMap();
		assertEquals(6, caractsModifierMap.size(), constructErrorModifierCountMessage(species));
		compareCaracteristicsModifiers(1, AG);
		compareCaracteristicsModifiers(-1, CON);
		compareCaracteristicsModifiers(-1, EMP);
		compareCaracteristicsModifiers(-1, STR);
		compareCaracteristicsModifiers(2, REF);
		compareCaracteristicsModifiers(-2, 1, 7, HEIGHT);
	}

	private String constructErrorModifierCountMessage(SpeciesEnum species) {
		return BAD + MODIFIER_COUNT_FOR + species;
	}

	private String constructErrorModifierMessage(CaracteristicEnum caracteristicEnum, SpeciesEnum species) {
		return BAD + caracteristicEnum.name() + MODIFIER_FOR + species;
	}

	private void compareCaracteristicsModifiers(int score, CaracteristicEnum caract) {
		Modifier modifier = new CaracteristicsModifier(score);
		assertEquals(modifier, caractsModifierMap.get(caract), constructErrorModifierMessage(caract, species));
	}

	private void compareCaracteristicsModifiers(int score, int min, CaracteristicEnum caract) {
		Modifier modifier = new CaracteristicsModifier(score, min);
		assertEquals(modifier, caractsModifierMap.get(caract), constructErrorModifierMessage(caract, species));
	}

	private void compareCaracteristicsModifiers(int score, int min, int max, CaracteristicEnum caract) {
		Modifier modifier = new CaracteristicsModifier(score, min, max);
		assertEquals(modifier, caractsModifierMap.get(caract), constructErrorModifierMessage(caract, species));
	}

	
}
