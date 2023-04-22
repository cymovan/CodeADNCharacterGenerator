package moon.adn.code.character.generator;

import moon.adn.code.model.character.skills.SkillEnum;

public class MedTechNPCGeneratorImpl extends NPCGeneratorImpl {

	public MedTechNPCGeneratorImpl() {
		super();
		initSkillToLearn();
	}

	private void initSkillToLearn() {
		skillsToLearn.add(SkillEnum.BIBLIO);
		skillsToLearn.add(SkillEnum.CHEMISTRY);
		skillsToLearn.add(SkillEnum.DIAG);
		skillsToLearn.add(SkillEnum.EDUCATION);
		skillsToLearn.add(SkillEnum.POISONS);
		skillsToLearn.add(SkillEnum.SEE);
		skillsToLearn.add(SkillEnum.CYBER_TECH);
		skillsToLearn.add(SkillEnum.PHARMA);
		skillsToLearn.add(SkillEnum.FIRST_AIDS);
		skillsToLearn.add(SkillEnum.HUMAN_PERCEPTION);
	}
}
