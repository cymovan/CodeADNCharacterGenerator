package moon.adn.code.model.character.identity;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpeciesEnumTests {

	private static final int MAX_RANDOM_ITERATIONS = 1000;
	private static final int MAX_ITERATIONS = 25;

	private static final int MINIMUM_SIBLING_COUNT = 0;
	private static final int D2_MINUS_1_MAX = 1;
	private static final int D3_MINUS_1_MAX = 2;
	private static final int D4_MINUS_1_MAX = 3;

	private SpeciesEnum species;

	@Test
	void whenGeneratingRandomSpeciesThenAllSpeciesCanBeReturned() {
		Set<SpeciesEnum> speciesSet = EnumSet.allOf(SpeciesEnum.class);
		Set<SpeciesEnum> returnedSpeciesSet = EnumSet.noneOf(SpeciesEnum.class);
		for (int i = 0; i < MAX_RANDOM_ITERATIONS; i++) {
			returnedSpeciesSet.add(SpeciesEnum.random());
		}
		assertThat(returnedSpeciesSet).containsAll(speciesSet);
	}

	@Test
	void whenGeneratingSiblingsCountForHumanThenItsInGoodRange() {
		species = SpeciesEnum.HUMAN;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d4Minus1();
		}
	}

	@Test
	void whenGeneratingSiblingsCountForSylvanElfThenItsInGoodRange() {
		species = SpeciesEnum.S_SYLV;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d4Minus1();
		}
	}

	@Test
	void whenGeneratingSiblingsCountForDarkElfThenItsInGoodRange() {
		species = SpeciesEnum.S_DARK;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d4Minus1();
		}
	}

	@Test
	void whenGeneratingSiblingsCountForUrbanElfThenItsInGoodRange() {
		species = SpeciesEnum.S_URB;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d3Minus1();
		}
	}

	@Test
	void whenGeneratingSiblingsCountForPaleElfThenItsInGoodRange() {
		species = SpeciesEnum.S_PALE;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d3Minus1();
		}
	}

	@Test
	void whenGeneratingSiblingsCountForGreyElfThenItsInGoodRange() {
		species = SpeciesEnum.S_GREY;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d3Minus1();
		}
	}

	@Test
	void whenGeneratingSiblingsCountForNightElfThenItsInGoodRange() {
		species = SpeciesEnum.S_NIGHT;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d3Minus1();
		}
	}

	@Test
	void whenGeneratingSiblingsCountForAquaticElfThenItsInGoodRange() {
		species = SpeciesEnum.S_AQUA;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d3Minus1();
		}
	}

	@Test
	void whenGeneratingSiblingsCountForGoldElfThenItsInGoodRange() {
		species = SpeciesEnum.S_GOLD;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d2Minus1();
		}
	}

	@Test
	void whenGeneratingSiblingsCountForIronBararThenItsInGoodRange() {
		species = SpeciesEnum.B_IRON;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assert1d4Minus1();
		}
	}

	private void assert1d4Minus1() {
		assertThat(species.randomSibling()).isBetween(MINIMUM_SIBLING_COUNT, D4_MINUS_1_MAX);
	}

	private void assert1d3Minus1() {
		assertThat(species.randomSibling()).isBetween(MINIMUM_SIBLING_COUNT, D3_MINUS_1_MAX);
	}

	private void assert1d2Minus1() {
		assertThat(species.randomSibling()).isBetween(MINIMUM_SIBLING_COUNT, D2_MINUS_1_MAX);
	}
}
