package moon.adn.code.model.character.builder;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import moon.adn.code.model.character.identity.SocialOriginEnum;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillValues;

/**
 * 
 * @author Cédric DELRUE
 *
 */
/**
 * @author Cédric DELRUE
 *
 */
public class SocialOriginSkillsHelper {
	private static final int NO_EDUCATION = 0;
	
	public @Getter Map<SkillEnum, SkillValues> initSkillMap = new HashMap<>();

	public void initSocialSkills(SocialOriginEnum socialOrigin) {
		switch (socialOrigin) {
		case STREET: {
			streetClassSkills();
			break;
		}
		case LOW_CLASS: {
			lowClassSkills();
			break;
		}
		case MIDDLE_CLASS: {
			middleClassSkills();
			break;
		}
		case UPPER_CLASS: {
			upperClassSkills();
			break;
		}
		case RICH: {
			richClassSkills();
			break;
		}
		case NAOHM: {
			naohmClassSkills();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + socialOrigin);
		}
	}

	private void streetClassSkills() {
		educationAndMaternalLanguageLevel(NO_EDUCATION, 1);
		initSkillMap.put(SkillEnum.STREET_KNOWLEDGE, new SkillValues(2));
		initSkillMap.put(SkillEnum.STEAL, new SkillValues(1));
		initSkillMap.put(SkillEnum.FORGERY, new SkillValues(1));
		initSkillMap.put(SkillEnum.DODGE, new SkillValues(2));
		initSkillMap.put(SkillEnum.BRAWL, new SkillValues(2));
//			initSkillMap.put(SkillEnum.EXPERT_DRUGS, new SkillValues(2));
	}

	private void lowClassSkills() {
		educationAndMaternalLanguageLevel(1, 3);
		initSkillMap.put(SkillEnum.STREET_KNOWLEDGE, new SkillValues(1));
		initSkillMap.put(SkillEnum.CHAT, new SkillValues(1));
		initSkillMap.put(SkillEnum.DIY, new SkillValues(2));
		initSkillMap.put(SkillEnum.TECH_GEN, new SkillValues(1));
		initSkillMap.put(SkillEnum.ELECTRONIC, new SkillValues(1));
		initSkillMap.put(SkillEnum.HUMAN_PERCEPTION, new SkillValues(1));
	}

	private void middleClassSkills() {
		educationAndMaternalLanguageLevel(3, 5);
		initSkillMap.put(SkillEnum.EVAL, new SkillValues(1));
		initSkillMap.put(SkillEnum.CHAT, new SkillValues(2));
		initSkillMap.put(SkillEnum.MANAGEMENT, new SkillValues(1));
		initSkillMap.put(SkillEnum.DRIVE_CAR, new SkillValues(2));
		initSkillMap.put(SkillEnum.LAW, new SkillValues(1));
		initSkillMap.put(SkillEnum.MATH, new SkillValues(1));
	}

	private void upperClassSkills() {
		educationAndMaternalLanguageLevel(4, 6);
		initSkillMap.put(SkillEnum.LAW, new SkillValues(1));
		initSkillMap.put(SkillEnum.CHAT, new SkillValues(1));
		initSkillMap.put(SkillEnum.MANAGEMENT, new SkillValues(2));
		initSkillMap.put(SkillEnum.DRIVE_CAR, new SkillValues(2));
		initSkillMap.put(SkillEnum.COMEDY, new SkillValues(1));
		initSkillMap.put(SkillEnum.MORAL_CODE_CORPO, new SkillValues(1));
	}

	private void richClassSkills() {
		educationAndMaternalLanguageLevel(4, 8);
		initSkillMap.put(SkillEnum.SOCIAL, new SkillValues(1));
		initSkillMap.put(SkillEnum.ELOQUENCE, new SkillValues(1));
		initSkillMap.put(SkillEnum.TECH_GEN, new SkillValues(2));
		initSkillMap.put(SkillEnum.MORAL_CODE_CORPO, new SkillValues(2));
		initSkillMap.put(SkillEnum.EVAL, new SkillValues(2));
	}

	private void naohmClassSkills() {
		educationAndMaternalLanguageLevel(5, 9);
		initSkillMap.put(SkillEnum.SOCIAL, new SkillValues(2));
		initSkillMap.put(SkillEnum.ELOQUENCE, new SkillValues(2));
		initSkillMap.put(SkillEnum.LAW, new SkillValues(2));
		initSkillMap.put(SkillEnum.MORAL_CODE_NAOHM, new SkillValues(2));
	}

	private void educationAndMaternalLanguageLevel(int education, int maternalLanguage) {
		initSkillMap.put(SkillEnum.EDUCATION, new SkillValues(education));
		initSkillMap.put(SkillEnum.READ_SELENITE, new SkillValues(maternalLanguage));
		initSkillMap.put(SkillEnum.SPEAK_SELENITE, new SkillValues(maternalLanguage));
	}

}
