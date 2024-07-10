package moon.adn.code.model.character.identity.names;

public class HumanNamesGeneratorSingleton extends AbstractNamesGeneratorSingleton {
	
	private static NamesGenerator instance;
	
	private HumanNamesGeneratorSingleton() {
		super();
	}

	public static NamesGenerator getInstance() {
		if (instance == null) {
			instance = new HumanNamesGeneratorSingleton();
		}
		return instance;
	}
}
