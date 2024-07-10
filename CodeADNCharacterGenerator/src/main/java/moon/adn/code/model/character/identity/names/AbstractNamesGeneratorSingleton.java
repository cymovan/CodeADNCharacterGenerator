package moon.adn.code.model.character.identity.names;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import moon.adn.code.model.character.identity.SexEnum;

abstract class AbstractNamesGeneratorSingleton implements NamesGenerator {
	private static final String FILES_ROOT = "names/";
	private static final String DEFAULT_FEMALE_FILE = "HumanFemaleFirstNames.txt";
	private static final String DEFAULT_MALE_FILE = "HumanMaleFirstNames.txt";
	private static final String DEFAULT_NEUTRAL_FILE = "HumanNeutralFirstNames.txt";
	private static final String DEFAULT_NAMES_FILE = "HumanNames.txt";

	private static final Logger logger = LoggerFactory.getLogger(AbstractNamesGeneratorSingleton.class);

	protected boolean keepDefautFirstNames = true;
	protected boolean keepDefautNames = true;

	private final Random random = new Random();

	protected final List<String> firstNamesFemale = new ArrayList<>();
	protected final List<String> firstNamesMale = new ArrayList<>();
	protected final List<String> firstNamesNeutral = new ArrayList<>();
	protected final List<String> names = new ArrayList<>();

	protected Set<String> firstNamesFemaleFiles = new HashSet<>();
	protected Set<String> firstNamesMaleFiles = new HashSet<>();
	protected Set<String> firstNamesNeutralFiles = new HashSet<>();
	protected Set<String> namesFiles = new HashSet<>();

	protected AbstractNamesGeneratorSingleton() {
		defaultFirstNamesFiles();
		defaultNamesFiles();
		initializeLists();
	}

	private void defaultFirstNamesFiles() {
		firstNamesFemaleFiles.add(FILES_ROOT + DEFAULT_FEMALE_FILE);
		firstNamesMaleFiles.add(FILES_ROOT + DEFAULT_MALE_FILE);
		firstNamesNeutralFiles.add(FILES_ROOT + DEFAULT_NEUTRAL_FILE);
	}

	private void defaultNamesFiles() {
		namesFiles.add(FILES_ROOT + DEFAULT_NAMES_FILE);
	}

	protected void initializeLists() {
		for (String firstNamesFile : firstNamesFemaleFiles) {
			firstNamesFemale.addAll(readFile(firstNamesFile));
		}
		for (String firstNamesFile : firstNamesMaleFiles) {
			firstNamesMale.addAll(readFile(firstNamesFile));
		}
		for (String firstNamesFile : firstNamesNeutralFiles) {
			firstNamesNeutral.addAll(readFile(firstNamesFile));
		}
		for (String namesFile : namesFiles) {
			names.addAll(readFile(namesFile));
		}
	}

	protected Set<String> readFile(String classPathFile) {
		Set<String> namesSet = new TreeSet<>();
		if (classPathFile == null) {
			return namesSet;
		}

		// using ClassLoader to load file from the classpath
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(classPathFile);
				Scanner scanner = new Scanner(inputStream)) {

			while (scanner.hasNextLine()) {
				namesSet.add(scanner.nextLine());
			}
		} catch (IOException e) {
			logger.error("Unable to read File {} from classPath.", classPathFile);
		}
		return namesSet;
	}

	protected AbstractNamesGeneratorSingleton(String firstNamesFemaleFile, String firstNamesMaleFile,
			String firstNamesNeutralFile, String namesFile, boolean keepDefautFirstNames, boolean keepDefautNames) {
		this.keepDefautFirstNames = keepDefautFirstNames;
		this.keepDefautNames = keepDefautNames;
		if (keepDefautFirstNames) {
			defaultFirstNamesFiles();
		}
		if (keepDefautNames) {
			defaultNamesFiles();
		}
		if (null != firstNamesFemaleFile) {
			this.firstNamesFemaleFiles.add(FILES_ROOT + firstNamesFemaleFile);
		}
		if (null != firstNamesMaleFile) {
			this.firstNamesMaleFiles.add(FILES_ROOT + firstNamesMaleFile);
		}
		if (null != firstNamesNeutralFile) {
			this.firstNamesNeutralFiles.add(FILES_ROOT + firstNamesNeutralFile);
		}
		if (null != namesFile) {
			this.namesFiles.add(FILES_ROOT + namesFile);
		}
		initializeLists();
	}

	protected AbstractNamesGeneratorSingleton(List<String> firstNamesFemaleFiles, List<String> firstNamesMaleFiles,
			List<String> firstNamesNeutralFiles, List<String> namesFiles) {
		this.firstNamesFemaleFiles.addAll(firstNamesFemaleFiles);
		this.firstNamesMaleFiles.addAll(firstNamesMaleFiles);
		this.firstNamesNeutralFiles.addAll(firstNamesNeutralFiles);
		this.namesFiles.addAll(namesFiles);
		initializeLists();
	}

	public String generateCompleteName(SexEnum sex) {
		String first = generateFirstName(sex);
		String lastName = "";
		if (!names.isEmpty()) {
			lastName = names.get(random.nextInt(names.size())).toUpperCase();
		}
		return first + " " + lastName;
	}

	public String generateFirstName(SexEnum sex) {
		List<String> searchFirstNames = new ArrayList<>(firstNamesNeutral);
		String first = "";
		if (SexEnum.F == sex) {
			searchFirstNames.addAll(firstNamesFemale);
		} else {
			searchFirstNames.addAll(firstNamesMale);
		}
		if (!searchFirstNames.isEmpty()) {
			first = searchFirstNames.get(random.nextInt(searchFirstNames.size()));
		}
		return first;
	}
}
