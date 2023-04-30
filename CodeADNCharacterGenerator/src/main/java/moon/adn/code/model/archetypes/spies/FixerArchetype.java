package moon.adn.code.model.archetypes.spies;

import static moon.adn.code.model.character.skills.SkillEnum.BARGAIN;
import static moon.adn.code.model.character.skills.SkillEnum.CHAT;
import static moon.adn.code.model.character.skills.SkillEnum.CHEMISTRY;
import static moon.adn.code.model.character.skills.SkillEnum.CORRUPTION;
import static moon.adn.code.model.character.skills.SkillEnum.ELOQUENCE;
import static moon.adn.code.model.character.skills.SkillEnum.EVAL;
import static moon.adn.code.model.character.skills.SkillEnum.HUMAN_PERCEPTION;
import static moon.adn.code.model.character.skills.SkillEnum.LAW;
import static moon.adn.code.model.character.skills.SkillEnum.MINERALS;
import static moon.adn.code.model.character.skills.SkillEnum.POISONS;
import static moon.adn.code.model.character.skills.SkillEnum.STREET_KNOWLEDGE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.CHARM;
import static moon.adn.code.model.character.specializations.SpecializationEnum.HUCKSTER;
import static moon.adn.code.model.character.specializations.SpecializationEnum.INFLUENCE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.LOOK;
import static moon.adn.code.model.character.specializations.SpecializationEnum.NEGOTIATION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.RAT;

public class FixerArchetype extends AbstractSpiesArchetype {

	public FixerArchetype() {
		this(1);
	}

	public FixerArchetype(int carrerLevel) {
		super(carrerLevel);
	}

	public void initSkillsToLearn() {
		super.initSkillsToLearn();
		skillsToLearn.add(CHEMISTRY);
		skillsToLearn.add(LAW);
		skillsToLearn.add(EVAL);
		skillsToLearn.add(MINERALS);
		skillsToLearn.add(POISONS);
		skillsToLearn.add(CHAT);
		skillsToLearn.add(BARGAIN);
		skillsToLearn.add(HUMAN_PERCEPTION);
		skillsToLearn.add(STREET_KNOWLEDGE);
		skillsToLearn.add(CORRUPTION);
		skillsToLearn.add(ELOQUENCE);
	}

	@Override
	public void initspecializationsToLearn() {
		super.initspecializationsToLearn();
		// Carrer
		specializationsToLearn.add(RAT);
		specializationsToLearn.add(LOOK);
		specializationsToLearn.add(HUCKSTER);
		specializationsToLearn.add(CHARM);
		specializationsToLearn.add(INFLUENCE);
		specializationsToLearn.add(NEGOTIATION);
		specializationsToLearn.add(RAT);
		specializationsToLearn.add(RAT);
		specializationsToLearn.add(RAT);
		specializationsToLearn.add(RAT);
	}
}
