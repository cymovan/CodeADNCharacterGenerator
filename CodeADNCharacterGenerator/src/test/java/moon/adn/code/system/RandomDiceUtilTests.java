package moon.adn.code.system;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static moon.adn.code.system.RandomDiceUtil.*;

@SpringBootTest
public class RandomDiceUtilTests {

	private static int MAX_ITERATIONS = 50;
	private int minDice = 1, maxDice;
	
	@Test
	void d2MethodReturnsAlwaysNumberBetween1And2() throws Exception {
		maxDice = 2;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d2();
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void d3MethodReturnsAlwaysNumberBetween1And3() throws Exception {
		maxDice = 3;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d3();
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void d4MethodReturnsAlwaysNumberBetween1And4() throws Exception {
		maxDice = 4;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d4();
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void d6MethodReturnsAlwaysNumberBetween1And6() throws Exception {
		maxDice = 6;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d6();
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void d8MethodReturnsAlwaysNumberBetween1And8() throws Exception {
		maxDice = 8;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d8();
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void d10MethodReturnsAlwaysNumberBetween1And10() throws Exception {
		maxDice = 10;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d10();
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void d10HeroicMethodReturnsAlwaysNumberBetween3And10() throws Exception {
		minDice = 3;
		maxDice = 10;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d10Heroic();
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void d10WeakMethodReturnsAlwaysNumberBetween1And7() throws Exception {
		minDice = 1;
		maxDice = 7;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d10Weak();
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void d100MethodReturnsAlwaysNumberBetween1And100() throws Exception {
		maxDice = 100;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d100();
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void randomValuesBetweenMinAndMaxGiveGoodValues() throws Exception {
		maxDice = 437;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			minDice = d100();
			int diceValue = random(minDice, maxDice);
			assertTrue(diceValue >= minDice && diceValue <= maxDice );
		}
 	}
	
	@Test
	void d4ExplodeMethodReturnsNumberBetween1And4AndExplodeOn4() throws Exception {
		maxDice = 4;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d4Explode();
			assertTrue(diceValue >= minDice);
		}
 	}
	
	@Test
	void d10ExplodeMethodReturnsNumberBetween1And10AndExplodeOn10() throws Exception {
		maxDice = 10;
		for(int i =0; i < MAX_ITERATIONS; i++) {
			int diceValue = d10Explode();
			assertTrue(diceValue >= minDice);
		}
 	}
}
