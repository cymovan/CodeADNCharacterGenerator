package moon.adn.code.model.character.identity.names;

public class DarkElvesNamesGeneratorSingleton extends AbstractNamesGeneratorSingleton {
	private static final String FEMALE_FILES = "DarkElvesFemaleFirstNames.txt";
	private static final String MALE_FILES = "DarkElvesMaleFirstNames.txt";
	private static final String NAMES_FILES = "DarkElvesNames.txt";

	private static NamesGenerator instance;
	
	private DarkElvesNamesGeneratorSingleton() {
		super(FEMALE_FILES, MALE_FILES, null, NAMES_FILES, false, false);
	}

	public static NamesGenerator getInstance() {
		if (instance == null) {
			instance = new DarkElvesNamesGeneratorSingleton();
		}
		return instance;
	}
}
