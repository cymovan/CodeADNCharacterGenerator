package moon.adn.code.model.character.builder;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import moon.adn.code.model.character.identity.SocialOriginEnum;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillValues;

/**
 * 
 * @author cdelr
 *
 */
/**
 * @author cdelr
 *
 */
public class SocialOriginSkillsHelper {
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
		initSkillMap.put(SkillEnum.EDUCATION, new SkillValues(0));
		initSkillMap.put(SkillEnum.STREET_KNOWLEDGE, new SkillValues(2));
		initSkillMap.put(SkillEnum.STEAL, new SkillValues(1));
		initSkillMap.put(SkillEnum.FORGERY, new SkillValues(1));
		initSkillMap.put(SkillEnum.DODGE, new SkillValues(2));
		initSkillMap.put(SkillEnum.BRAWL, new SkillValues(2));
//			initSkillMap.put(SkillEnum.EXPERT_DRUGS, new SkillValues(2));
	}

	private void lowClassSkills() {
		initSkillMap.put(SkillEnum.EDUCATION, new SkillValues(1));
		initSkillMap.put(SkillEnum.STREET_KNOWLEDGE, new SkillValues(1));
		initSkillMap.put(SkillEnum.CHAT, new SkillValues(1));
		initSkillMap.put(SkillEnum.DIY, new SkillValues(2));
		initSkillMap.put(SkillEnum.TECH_GEN, new SkillValues(1));
		initSkillMap.put(SkillEnum.ELECTRONIC, new SkillValues(1));
		initSkillMap.put(SkillEnum.HUMAN_PERCEPTION, new SkillValues(1));
	}

	private void middleClassSkills() {
		initSkillMap.put(SkillEnum.EDUCATION, new SkillValues(5));
		initSkillMap.put(SkillEnum.EVAL, new SkillValues(1));
		initSkillMap.put(SkillEnum.CHAT, new SkillValues(2));
		initSkillMap.put(SkillEnum.MANAGEMENT, new SkillValues(1));
		initSkillMap.put(SkillEnum.DRIVE_CAR, new SkillValues(2));
		initSkillMap.put(SkillEnum.LAW, new SkillValues(1));
		initSkillMap.put(SkillEnum.MATH, new SkillValues(1));
	}

	private void upperClassSkills() {
		initSkillMap.put(SkillEnum.EDUCATION, new SkillValues(6));
		initSkillMap.put(SkillEnum.EVAL, new SkillValues(1));
		initSkillMap.put(SkillEnum.CHAT, new SkillValues(2));
		initSkillMap.put(SkillEnum.MANAGEMENT, new SkillValues(2));
		initSkillMap.put(SkillEnum.DRIVE_CAR, new SkillValues(2));
		initSkillMap.put(SkillEnum.COMEDY, new SkillValues(1));
		initSkillMap.put(SkillEnum.MORAL_CODE_CORPO, new SkillValues(1));
	}

	private void richClassSkills() {
		initSkillMap.put(SkillEnum.EDUCATION, new SkillValues(8));
		initSkillMap.put(SkillEnum.SOCIAL, new SkillValues(1));
		initSkillMap.put(SkillEnum.ELOQUENCE, new SkillValues(1));
		initSkillMap.put(SkillEnum.TECH_GEN, new SkillValues(2));
		initSkillMap.put(SkillEnum.MORAL_CODE_CORPO, new SkillValues(1));
		initSkillMap.put(SkillEnum.EVAL, new SkillValues(1));
	}

	private void naohmClassSkills() {
		initSkillMap.put(SkillEnum.EDUCATION, new SkillValues(9));
		initSkillMap.put(SkillEnum.SOCIAL, new SkillValues(2));
		initSkillMap.put(SkillEnum.ELOQUENCE, new SkillValues(2));
		initSkillMap.put(SkillEnum.LAW, new SkillValues(2));
		initSkillMap.put(SkillEnum.MORAL_CODE_NAOHM, new SkillValues(2));
	}
}
