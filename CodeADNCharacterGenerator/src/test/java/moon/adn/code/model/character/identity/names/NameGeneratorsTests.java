package moon.adn.code.model.character.identity.names;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.identity.SexEnum;

@SpringBootTest
class NameGeneratorsTests extends AbstractNamesGeneratorSingleton {
	private static final String FILES_ROOT = "names/";
	private static final String HUMAN_FEMALE_FILE = "HumanFemaleFirstNames.txt";
	private static final String HUMAN_MALE_FILE = "HumanMaleFirstNames.txt";
	private static final String HUMAN_NEUTRAL_FILE = "HumanNeutralFirstNames.txt";
	private static final String SEPHONILEANDIS_FEMALE_FILE = "SephonileandisFemaleFirstNames.txt";
	private static final String SEPHONILEANDIS_MALE_FILE = "SephonileandisMaleFirstNames.txt";
	private static final String SEPHONILEANDIS_NEUTRAL_FILE = "SephonileandisNeutralFirstNames.txt";
	private static final String DARK_ELVES_FEMALE_FILE = "DarkElvesFemaleFirstNames.txt";
	private static final String DARK_ELVES_MALE_FILE = "DarkElvesMaleFirstNames.txt";

	private Set<String> femaleHumanNamesSet = readFile(FILES_ROOT + HUMAN_FEMALE_FILE);
	private Set<String> maleHumanNamesSet = readFile(FILES_ROOT + HUMAN_MALE_FILE);
	private Set<String> neutralHumanNamesSet = readFile(FILES_ROOT + HUMAN_NEUTRAL_FILE);
	private Set<String> femaleSephonileandisNamesSet = readFile(FILES_ROOT + SEPHONILEANDIS_FEMALE_FILE);
	private Set<String> maleSephonileandisNamesSet = readFile(FILES_ROOT + SEPHONILEANDIS_MALE_FILE);
	private Set<String> neutralSephonileandisNamesSet = readFile(FILES_ROOT + SEPHONILEANDIS_NEUTRAL_FILE);
	private Set<String> femaleDarkElvesNamesSet = readFile(FILES_ROOT + DARK_ELVES_FEMALE_FILE);
	private Set<String> maleDarkElvesNamesSet = readFile(FILES_ROOT + DARK_ELVES_MALE_FILE);

	private static final int MAX_ITERATIONS = 15000;

	private static NamesGenerator humanNamesGenerator;
	private static NamesGenerator sephonileandisNamesGenerator;
	private static NamesGenerator darkElvesNamesGenerator;

	@BeforeAll
	static void initSingletons() {
		humanNamesGenerator = HumanNamesGeneratorSingleton.getInstance();
		sephonileandisNamesGenerator = SephonileandisNamesGeneratorSingleton.getInstance();
		darkElvesNamesGenerator = DarkElvesNamesGeneratorSingleton.getInstance();
	}

	@Test
	void whenAskingHumanFemaleNamesThenItHasOnlyHumanFemaleOrNeutralNames() {
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assertNameIsInSets(humanNamesGenerator, SexEnum.F, femaleHumanNamesSet, neutralHumanNamesSet);
		}
	}

	@Test
	void whenAskingHumanMaleNamesThenItHasOnlyHumanMaleOrNeutralNames() {
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assertNameIsInSets(humanNamesGenerator, SexEnum.M, maleHumanNamesSet, neutralHumanNamesSet);
		}
	}

	@Test
	void whenAskingSephonileandisFemaleNamesThenItHasOnlyHumanFemaleOrNeutralNames() {
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assertNameIsInSets(sephonileandisNamesGenerator, SexEnum.F, femaleHumanNamesSet, neutralHumanNamesSet,
					femaleSephonileandisNamesSet, neutralSephonileandisNamesSet);
		}
	}

	@Test
	void whenAskingSephonileandisMaleNamesThenItHasOnlyHumanMaleOrNeutralNames() {
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assertNameIsInSets(sephonileandisNamesGenerator, SexEnum.M, maleHumanNamesSet, neutralHumanNamesSet,
					maleSephonileandisNamesSet, neutralSephonileandisNamesSet);
		}
	}

	@Test
	void whenAskingDarkElfFemaleNamesThenItHasOnlyHumanFemaleOrNeutralNames() {
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assertNameIsInSets(darkElvesNamesGenerator, SexEnum.F, femaleDarkElvesNamesSet);
		}
	}

	@Test
	void whenAskingDarkElfMaleNamesThenItHasOnlyHumanMaleOrNeutralNames() {
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			assertNameIsInSets(darkElvesNamesGenerator, SexEnum.M, maleDarkElvesNamesSet);
		}
	}

	@SafeVarargs
	private void assertNameIsInSets(NamesGenerator namesGenerator, SexEnum sex, Set<String>... set) {
		Set<String> checkList = new TreeSet<>();
		for (Set<String> element : set) {
			checkList.addAll(element);
		}
		String generatedFirstName = namesGenerator.generateFirstName(sex);
		assertThat(generatedFirstName).isIn(checkList);
	}
}
