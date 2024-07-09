package moon.adn.code.system;

import static moon.adn.code.system.RandomDiceUtil.d10;
import static moon.adn.code.system.RandomDiceUtil.d100;
import static moon.adn.code.system.RandomDiceUtil.d10Explode;
import static moon.adn.code.system.RandomDiceUtil.d10Heroic;
import static moon.adn.code.system.RandomDiceUtil.d10Weak;
import static moon.adn.code.system.RandomDiceUtil.d2;
import static moon.adn.code.system.RandomDiceUtil.d3;
import static moon.adn.code.system.RandomDiceUtil.d4;
import static moon.adn.code.system.RandomDiceUtil.d4Explode;
import static moon.adn.code.system.RandomDiceUtil.d5;
import static moon.adn.code.system.RandomDiceUtil.d6;
import static moon.adn.code.system.RandomDiceUtil.d8;
import static moon.adn.code.system.RandomDiceUtil.random;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RandomDiceUtilTests {

	private static int MAX_ITERATIONS = 50;
	private int minDice = 1, maxDice;

	@Test
	void d2MethodReturnsAlwaysNumberBetween1And2() {
		maxDice = 2;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d2();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d3MethodReturnsAlwaysNumberBetween1And3() {
		maxDice = 3;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d3();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d4MethodReturnsAlwaysNumberBetween1And4() {
		maxDice = 4;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d4();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d5MethodReturnsAlwaysNumberBetween1And5() {
		maxDice = 5;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d5();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d6MethodReturnsAlwaysNumberBetween1And6() {
		maxDice = 6;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d6();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d8MethodReturnsAlwaysNumberBetween1And8() {
		maxDice = 8;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d8();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d10MethodReturnsAlwaysNumberBetween1And10() {
		maxDice = 10;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d10();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d10HeroicMethodReturnsAlwaysNumberBetween3And10() {
		minDice = 3;
		maxDice = 10;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d10Heroic();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d10WeakMethodReturnsAlwaysNumberBetween1And7() {
		minDice = 1;
		maxDice = 7;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d10Weak();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d100MethodReturnsAlwaysNumberBetween1And100() {
		maxDice = 100;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d100();
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void randomValuesBetweenMinAndMaxGiveGoodValues() {
		maxDice = 437;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			minDice = d100();
			int diceValue = random(minDice, maxDice);
			assertThat(diceValue).isBetween(minDice, maxDice);
		}
	}

	@Test
	void d4ExplodeMethodReturnsNumberBetween1And4AndExplodeOn4() {
		maxDice = 4;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d4Explode();
			assertThat(diceValue).isGreaterThanOrEqualTo(minDice);
		}
	}

	@Test
	void d10ExplodeMethodReturnsNumberBetween1And10AndExplodeOn10() {
		maxDice = 10;
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			int diceValue = d10Explode();
			assertThat(diceValue).isGreaterThanOrEqualTo(minDice);
		}
	}
}
