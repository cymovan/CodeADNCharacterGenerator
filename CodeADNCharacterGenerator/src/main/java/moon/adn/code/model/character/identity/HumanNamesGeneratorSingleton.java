package moon.adn.code.model.character.identity;

public class HumanNamesGeneratorSingleton extends AbstractNamesGeneratorSingleton {
	
	private static NamesGenerator INSTANCE;
	
	private HumanNamesGeneratorSingleton() {
		super();
	}

	public static NamesGenerator getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new HumanNamesGeneratorSingleton();
		}
		return INSTANCE;
	}
}
