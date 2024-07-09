package moon.adn.code.model.character.builder;

import static moon.adn.code.model.character.identity.SocialOriginEnum.*;
import static moon.adn.code.model.character.skills.SkillEnum.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.identity.SocialOriginEnum;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillValues;

@SpringBootTest
class SocialOriginTests {

	private SocialOriginSkillsHelper socOrigHelper;
	private SocialOriginEnum socialOrigin;
	private Map<SkillEnum, SkillValues> socialOriginSkillsMap;
	private Map<SkillEnum, SkillValues> socialOriginSkillsMapToCompare;

	@BeforeEach
	void initTests() {
		socOrigHelper = new SocialOriginSkillsHelper();
		socialOriginSkillsMap = new HashMap<>();
		socialOriginSkillsMapToCompare = new HashMap<>();
	}

	@Test
	void whenAskingStreetOriginSkillsThenTheyAreAsExpectedByRules() {
		socialOrigin = STREET;
		socOrigHelper.initSocialSkills(socialOrigin);
		socialOriginSkillsMap = socOrigHelper.getInitSkillMap();
		addEntryToCompareMap(EDUCATION, 0);
		addEntryToCompareMap(READ_SELENITE, 1);
		addEntryToCompareMap(SPEAK_SELENITE, 1);
		addEntryToCompareMap(SPEAK_SELENITE, 1);
		addEntryToCompareMap(STREET_KNOWLEDGE, 2);
		addEntryToCompareMap(STEAL, 1);
		addEntryToCompareMap(FORGERY, 1);
		addEntryToCompareMap(DODGE, 2);
		addEntryToCompareMap(BRAWL, 2);
		// TODO : add Expert drugs
		// addEntryToCompareMap(EXPERT_DRUGS, 2);
		assertAllIsCorrect();
	}

	@Test
	void whenAskingLowClassOriginSkillsThenTheyAreAsExpectedByRules() {
		socialOrigin = LOW_CLASS;
		socOrigHelper.initSocialSkills(socialOrigin);
		socialOriginSkillsMap = socOrigHelper.getInitSkillMap();
		addEntryToCompareMap(EDUCATION, 1);
		addEntryToCompareMap(READ_SELENITE, 3);
		addEntryToCompareMap(SPEAK_SELENITE, 3);
		addEntryToCompareMap(STREET_KNOWLEDGE, 1);
		addEntryToCompareMap(CHAT, 1);
		addEntryToCompareMap(DIY, 2);
		addEntryToCompareMap(TECH_GEN, 1);
		addEntryToCompareMap(ELECTRONIC, 1);
		addEntryToCompareMap(HUMAN_PERCEPTION, 1);
		assertAllIsCorrect();
	}

	@Test
	void whenAskingMiddleClassOriginSkillsThenTheyAreAsExpectedByRules() {
		socialOrigin = MIDDLE_CLASS;
		socOrigHelper.initSocialSkills(socialOrigin);
		socialOriginSkillsMap = socOrigHelper.getInitSkillMap();
		addEntryToCompareMap(EDUCATION, 3);
		addEntryToCompareMap(READ_SELENITE, 5);
		addEntryToCompareMap(SPEAK_SELENITE, 5);
		addEntryToCompareMap(EVAL, 1);
		addEntryToCompareMap(CHAT, 2);
		addEntryToCompareMap(MANAGEMENT, 1);
		addEntryToCompareMap(DRIVE_CAR, 2);
		addEntryToCompareMap(LAW, 1);
		addEntryToCompareMap(MATH, 1);
		assertAllIsCorrect();
	}

	@Test
	void whenAskingUpperClassOriginSkillsThenTheyAreAsExpectedByRules() {
		socialOrigin = UPPER_CLASS;
		socOrigHelper.initSocialSkills(socialOrigin);
		socialOriginSkillsMap = socOrigHelper.getInitSkillMap();
		addEntryToCompareMap(EDUCATION, 4);
		addEntryToCompareMap(READ_SELENITE, 6);
		addEntryToCompareMap(SPEAK_SELENITE, 6);
		addEntryToCompareMap(LAW, 1);
		addEntryToCompareMap(CHAT, 1);
		addEntryToCompareMap(MANAGEMENT, 2);
		addEntryToCompareMap(DRIVE_CAR, 2);
		addEntryToCompareMap(COMEDY, 1);
		addEntryToCompareMap(MORAL_CODE_CORPO, 1);
		assertAllIsCorrect();
	}

	@Test
	void whenAskingRichOriginSkillsThenTheyAreAsExpectedByRules() {
		socialOrigin = RICH;
		socOrigHelper.initSocialSkills(socialOrigin);
		socialOriginSkillsMap = socOrigHelper.getInitSkillMap();
		addEntryToCompareMap(EDUCATION, 4);
		addEntryToCompareMap(READ_SELENITE, 8);
		addEntryToCompareMap(SPEAK_SELENITE, 8);
		addEntryToCompareMap(SOCIAL, 1);
		addEntryToCompareMap(ELOQUENCE, 1);
		addEntryToCompareMap(TECH_GEN, 2);
		addEntryToCompareMap(MORAL_CODE_CORPO, 2);
		addEntryToCompareMap(EVAL, 2);
		assertAllIsCorrect();
	}

	@Test
	void whenAskingNaohmOriginSkillsThenTheyAreAsExpectedByRules() {
		socialOrigin = NAOHM;
		socOrigHelper.initSocialSkills(socialOrigin);
		socialOriginSkillsMap = socOrigHelper.getInitSkillMap();
		addEntryToCompareMap(EDUCATION, 5);
		addEntryToCompareMap(READ_SELENITE, 9);
		addEntryToCompareMap(SPEAK_SELENITE, 9);
		addEntryToCompareMap(SOCIAL, 2);
		addEntryToCompareMap(ELOQUENCE, 2);
		addEntryToCompareMap(LAW, 2);
		addEntryToCompareMap(MORAL_CODE_NAOHM, 2);
		assertAllIsCorrect();
	}

	private void addEntryToCompareMap(SkillEnum skill, int value) {
		socialOriginSkillsMapToCompare.put(skill, new SkillValues(value));
	}

	private void assertAllIsCorrect() {
		assertThat(socialOriginSkillsMap).containsOnlyKeys(socialOriginSkillsMapToCompare.keySet());
		assertThat(socialOriginSkillsMap).containsAllEntriesOf(socialOriginSkillsMapToCompare);
	}
}
