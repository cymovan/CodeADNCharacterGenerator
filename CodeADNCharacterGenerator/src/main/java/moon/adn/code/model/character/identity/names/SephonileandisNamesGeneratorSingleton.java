package moon.adn.code.model.character.identity.names;

public class SephonileandisNamesGeneratorSingleton extends AbstractNamesGeneratorSingleton {
	private static final String FEMALE_FILES = "SephonileandisFemaleFirstNames.txt";
	private static final String MALE_FILES = "SephonileandisMaleFirstNames.txt";
	private static final String NEUTRAL_FILES = "SephonileandisNeutralFirstNames.txt";
	private static final String NAMES_FILES = "SephonileandisNames.txt";

	private static NamesGenerator instance;

	private SephonileandisNamesGeneratorSingleton() {
		super(FEMALE_FILES, MALE_FILES, NEUTRAL_FILES, NAMES_FILES, false, false);
	}

	public static NamesGenerator getInstance() {
		if (instance == null) {
			instance = new SephonileandisNamesGeneratorSingleton();
		}
		return instance;
	}
}
