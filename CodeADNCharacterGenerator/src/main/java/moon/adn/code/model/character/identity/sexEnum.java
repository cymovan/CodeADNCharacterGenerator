package moon.adn.code.model.character.identity;

import java.util.Random;

public enum sexEnum {
	M, F;

	private static Random random = new Random();

	public static final String MESSAGE_PREFIX = "sex.";
	
	public static sexEnum randomSpecies() {
		return values()[random.nextInt(values().length)];
	}
}
