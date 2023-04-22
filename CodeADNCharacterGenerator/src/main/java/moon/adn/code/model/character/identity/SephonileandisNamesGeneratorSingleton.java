package moon.adn.code.model.character.identity;

public class SephonileandisNamesGeneratorSingleton extends AbstractNamesGeneratorSingleton {
	private static final String FEMALE_FILES = "SephonileandisFemaleFirstNames.txt";
	private static final String MALE_FILES = "SephonileandisMaleFirstNames.txt";
	private static final String NEUTRAL_FILES = "SephonileandisNeutralFirstNames.txt";
	private static final String NAMES_FILES = "SephonileandisNames.txt";

	private static NamesGenerator INSTANCE;

	private SephonileandisNamesGeneratorSingleton() {
		super(FEMALE_FILES, MALE_FILES, NEUTRAL_FILES, NAMES_FILES, false, false);
	}

	public static NamesGenerator getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SephonileandisNamesGeneratorSingleton();
		}
		return INSTANCE;
	}
}
