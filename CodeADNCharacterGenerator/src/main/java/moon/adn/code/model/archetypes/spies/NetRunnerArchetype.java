package moon.adn.code.model.archetypes.spies;

import static moon.adn.code.model.character.skills.SkillEnum.CODING;
import static moon.adn.code.model.character.skills.SkillEnum.DECODE;
import static moon.adn.code.model.character.skills.SkillEnum.EDUCATION;
import static moon.adn.code.model.character.skills.SkillEnum.ELECTRONIC;
import static moon.adn.code.model.character.skills.SkillEnum.LAW;
import static moon.adn.code.model.character.skills.SkillEnum.MATH;
import static moon.adn.code.model.character.skills.SkillEnum.NET;
import static moon.adn.code.model.character.skills.SkillEnum.PICS;
import static moon.adn.code.model.character.skills.SkillEnum.SECURITY;
import static moon.adn.code.model.character.specializations.SpecializationEnum.CONNECTED_OBJECTS;
import static moon.adn.code.model.character.specializations.SpecializationEnum.CRYPTOGRAPHY;
import static moon.adn.code.model.character.specializations.SpecializationEnum.HACKING;
import static moon.adn.code.model.character.specializations.SpecializationEnum.HARDWARE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.IMAGE_EDITING;
import static moon.adn.code.model.character.specializations.SpecializationEnum.INTERFACE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.SYS_ADMIN;

public class NetRunnerArchetype extends AbstractSpiesArchetype {

	public NetRunnerArchetype() {
		this(1);
	}

	public NetRunnerArchetype(int carrerLevel) {
		super(carrerLevel);
	}

	@Override
	public void initSkillsToLearn() {
		super.initSkillsToLearn();
		skillsToLearn.add(DECODE);
		skillsToLearn.add(EDUCATION);
		skillsToLearn.add(LAW);
		skillsToLearn.add(MATH);
		skillsToLearn.add(CODING);
		skillsToLearn.add(NET);
		skillsToLearn.add(ELECTRONIC);
		skillsToLearn.add(PICS);
		skillsToLearn.add(SECURITY);
	}

	@Override
	public void initspecializationsToLearn() {
		super.initspecializationsToLearn();
		// Carrer
		specializationsToLearn.add(INTERFACE);
		specializationsToLearn.add(CRYPTOGRAPHY);
		specializationsToLearn.add(CONNECTED_OBJECTS);
		specializationsToLearn.add(HACKING);
		specializationsToLearn.add(HARDWARE);
		specializationsToLearn.add(SYS_ADMIN);
		specializationsToLearn.add(IMAGE_EDITING);
	}
}
