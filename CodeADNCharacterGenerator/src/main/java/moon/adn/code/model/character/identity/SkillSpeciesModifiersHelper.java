package moon.adn.code.model.character.identity;

import java.util.HashMap;
import java.util.Map;

import moon.adn.code.model.character.builder.Modifier;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.skills.SkillsSpeciesModifiers;

public class SkillSpeciesModifiersHelper {
	static SkillsSpeciesModifiers urbanElfSkills() {
		Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(SkillEnum.BIO, new Modifier(-1));
		modifiersMap.put(SkillEnum.INVEST, new Modifier(1));
		modifiersMap.put(SkillEnum.READ_SELENITE, new Modifier(2));
		modifiersMap.put(SkillEnum.READ_SEPHONILEANDIS, new Modifier(2));
		modifiersMap.put(SkillEnum.MINERALS, new Modifier(-2));
		modifiersMap.put(SkillEnum.SPEAK_SELENITE, new Modifier(2));
		modifiersMap.put(SkillEnum.SPEAK_SEPHONILEANDIS, new Modifier(2));
		modifiersMap.put(SkillEnum.RIFFLES, new Modifier(-1));
		modifiersMap.put(SkillEnum.GUNS, new Modifier(1));
		modifiersMap.put(SkillEnum.DANCE, new Modifier(1));
		modifiersMap.put(SkillEnum.STUNT, new Modifier(1));
		modifiersMap.put(SkillEnum.SOCIAL, new Modifier(2));
		modifiersMap.put(SkillEnum.STREET_KNOWLEDGE, new Modifier(1));
		SkillsSpeciesModifiers ssm = new SkillsSpeciesModifiers();
		ssm.setModifiersMap(modifiersMap);
		return ssm;
	}

	static SkillsSpeciesModifiers sylvanElfSkills() {
		Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(SkillEnum.BOTA, new Modifier(2));
		modifiersMap.put(SkillEnum.MINERALS, new Modifier(-2));
		modifiersMap.put(SkillEnum.RIFFLES, new Modifier(-1));
		modifiersMap.put(SkillEnum.BOWS, new Modifier(2));
		modifiersMap.put(SkillEnum.ART_SINGING, new Modifier(1));
		modifiersMap.put(SkillEnum.WEAPON_AUTO, new Modifier(-1));
		modifiersMap.put(SkillEnum.CYBER_TECH, new Modifier(-2));
		modifiersMap.put(SkillEnum.MUSIC, new Modifier(1));
		modifiersMap.put(SkillEnum.DANCE, new Modifier(1));
		modifiersMap.put(SkillEnum.MORAL_CODE_SPIRITUAL_TREES, new Modifier(2));
		SkillsSpeciesModifiers ssm = new SkillsSpeciesModifiers();
		ssm.setModifiersMap(modifiersMap);
		return ssm;
	}

	static SkillsSpeciesModifiers paleElfSkills() {
		Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(SkillEnum.BOTA, new Modifier(3));
		modifiersMap.put(SkillEnum.MINERALS, new Modifier(-3));
		modifiersMap.put(SkillEnum.CODING, new Modifier(-2));
		modifiersMap.put(SkillEnum.RIFFLES, new Modifier(-1));
		modifiersMap.put(SkillEnum.BOWS, new Modifier(2));
		modifiersMap.put(SkillEnum.ART_SINGING, new Modifier(1));
		modifiersMap.put(SkillEnum.CYBER_TECH, new Modifier(-2));
		modifiersMap.put(SkillEnum.ELECTRONIC, new Modifier(-2));
		modifiersMap.put(SkillEnum.MUSIC, new Modifier(1));
		modifiersMap.put(SkillEnum.DANCE, new Modifier(1));
		modifiersMap.put(SkillEnum.CLIMB, new Modifier(1));
		modifiersMap.put(SkillEnum.HUMAN_PERCEPTION, new Modifier(2));
		modifiersMap.put(SkillEnum.MORAL_CODE_SPIRITUAL_TREES, new Modifier(3));
		modifiersMap.put(SkillEnum.HYPNOTIZE, new Modifier(1, 0.3d));
		SkillsSpeciesModifiers ssm = new SkillsSpeciesModifiers();
		ssm.setModifiersMap(modifiersMap);
		return ssm;
	}

	static SkillsSpeciesModifiers greyElfSkills() {
		Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(SkillEnum.ASTRONOMY, new Modifier(-2));
		modifiersMap.put(SkillEnum.BOTA, new Modifier(2));
		modifiersMap.put(SkillEnum.MINERALS, new Modifier(-2));
		modifiersMap.put(SkillEnum.CODING, new Modifier(-2));
		modifiersMap.put(SkillEnum.RIFFLES, new Modifier(-2));
		modifiersMap.put(SkillEnum.ART_SINGING, new Modifier(3));
		modifiersMap.put(SkillEnum.BOWS, new Modifier(2));
		modifiersMap.put(SkillEnum.ART_SINGING, new Modifier(3));
		modifiersMap.put(SkillEnum.CYBER_TECH, new Modifier(-3));
		modifiersMap.put(SkillEnum.MUSIC, new Modifier(3));
		modifiersMap.put(SkillEnum.GRAPHISM, new Modifier(3));
		modifiersMap.put(SkillEnum.SECURITY, new Modifier(-2));
		modifiersMap.put(SkillEnum.DANCE, new Modifier(1));
		modifiersMap.put(SkillEnum.PERFORMANCE, new Modifier(1));
		modifiersMap.put(SkillEnum.SEDUCTION, new Modifier(1));
		modifiersMap.put(SkillEnum.ELOQUENCE, new Modifier(2));
		modifiersMap.put(SkillEnum.MORAL_CODE_SPIRITUAL_TREES, new Modifier(4));
		SkillsSpeciesModifiers ssm = new SkillsSpeciesModifiers();
		ssm.setModifiersMap(modifiersMap);
		return ssm;
	}

	static SkillsSpeciesModifiers goldElfSkills() {
		Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(SkillEnum.BOTA, new Modifier(3));
		modifiersMap.put(SkillEnum.BOWS, new Modifier(2));
		modifiersMap.put(SkillEnum.CYBER_TECH, new Modifier(-5));
		modifiersMap.put(SkillEnum.FIRST_AIDS, new Modifier(1));
		modifiersMap.put(SkillEnum.SOCIAL, new Modifier(-3));
		modifiersMap.put(SkillEnum.HUMAN_PERCEPTION, new Modifier(3));
		modifiersMap.put(SkillEnum.MAGICAL_RESISTANCE, new Modifier(3));
		modifiersMap.put(SkillEnum.MORAL_CODE_SPIRITUAL_TREES, new Modifier(5));
		SkillsSpeciesModifiers ssm = new SkillsSpeciesModifiers();
		ssm.setModifiersMap(modifiersMap);
		return ssm;
	}

	static SkillsSpeciesModifiers nightElfSkills() {
		Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(SkillEnum.ASTRONOMY, new Modifier(2));
		modifiersMap.put(SkillEnum.ORIENTATION, new Modifier(1));
		modifiersMap.put(SkillEnum.STAMINA, new Modifier(3));
		modifiersMap.put(SkillEnum.SNEAK, new Modifier(-2));
		modifiersMap.put(SkillEnum.DODGE, new Modifier(-1));
		modifiersMap.put(SkillEnum.HIDE, new Modifier(-3));
		modifiersMap.put(SkillEnum.SEE, new Modifier(2));
		modifiersMap.put(SkillEnum.FLY, new Modifier(5));
		modifiersMap.put(SkillEnum.MORAL_CODE_MOON, new Modifier(5));
		SkillsSpeciesModifiers ssm = new SkillsSpeciesModifiers();
		ssm.setModifiersMap(modifiersMap);
		return ssm;
	}

	static SkillsSpeciesModifiers aquaticElfSkills() {
		Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(SkillEnum.ASTRONOMY, new Modifier(-3));
		modifiersMap.put(SkillEnum.LISTEN, new Modifier(2));
		modifiersMap.put(SkillEnum.SMELLING, new Modifier(-1));
		modifiersMap.put(SkillEnum.RIFFLES, new Modifier(2));
		modifiersMap.put(SkillEnum.BOWS, new Modifier(-2));
		modifiersMap.put(SkillEnum.SWIMMING, new Modifier(10));
		modifiersMap.put(SkillEnum.RIDING, new Modifier(-5));
		modifiersMap.put(SkillEnum.SIXTH_SENSE, new Modifier(2));
		SkillsSpeciesModifiers ssm = new SkillsSpeciesModifiers();
		ssm.setModifiersMap(modifiersMap);
		return ssm;
	}

	static SkillsSpeciesModifiers darkElfSkills() {
		Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(SkillEnum.EDUCATION, new Modifier(-2));
		modifiersMap.put(SkillEnum.LISTEN, new Modifier(1));
		modifiersMap.put(SkillEnum.ORIENTATION, new Modifier(1));
		modifiersMap.put(SkillEnum.SPEAK_SIGNS_LANGUAGE, new Modifier(2));
		modifiersMap.put(SkillEnum.SMELLING, new Modifier(-2));
		modifiersMap.put(SkillEnum.SEE, new Modifier(1));
		modifiersMap.put(SkillEnum.BOWS, new Modifier(-3));
		modifiersMap.put(SkillEnum.SWIMMING, new Modifier(-2));
		modifiersMap.put(SkillEnum.CHAT, new Modifier(1));
		modifiersMap.put(SkillEnum.MAGICAL_RESISTANCE, new Modifier(5));
		modifiersMap.put(SkillEnum.SIXTH_SENSE, new Modifier(2));
		SkillsSpeciesModifiers ssm = new SkillsSpeciesModifiers();
		ssm.setModifiersMap(modifiersMap);
		return ssm;
	}
	
	static SkillsSpeciesModifiers ironBararSkills() {
		Map<SkillEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(SkillEnum.ASTRONOMY, new Modifier(-5));
		modifiersMap.put(SkillEnum.BIO, new Modifier(-2));
		modifiersMap.put(SkillEnum.BOTA, new Modifier(-4));
		modifiersMap.put(SkillEnum.MINERALS, new Modifier(5));
		modifiersMap.put(SkillEnum.ORIENTATION, new Modifier(2));
		modifiersMap.put(SkillEnum.SHIELD, new Modifier(1));
		modifiersMap.put(SkillEnum.RIFFLES, new Modifier(1));
		modifiersMap.put(SkillEnum.WEAPON, new Modifier(1));
		modifiersMap.put(SkillEnum.DIY, new Modifier(2));
		modifiersMap.put(SkillEnum.TECH_GEN, new Modifier(1));
		modifiersMap.put(SkillEnum.EXPLOSIVES, new Modifier(1));
		modifiersMap.put(SkillEnum.CLIMB, new Modifier(-1));
		modifiersMap.put(SkillEnum.COMEDY, new Modifier(-1));
		SkillsSpeciesModifiers ssm = new SkillsSpeciesModifiers();
		ssm.setModifiersMap(modifiersMap);
		return ssm;
	}
}
