package moon.adn.code.model.archetypes.scientists;

import static moon.adn.code.model.character.skills.SkillEnum.ARMOURER;
import static moon.adn.code.model.character.skills.SkillEnum.CYBER_TECH;
import static moon.adn.code.model.character.skills.SkillEnum.DIY;
import static moon.adn.code.model.character.skills.SkillEnum.ELECTRONIC;
import static moon.adn.code.model.character.skills.SkillEnum.EXPLOSIVES;
import static moon.adn.code.model.character.skills.SkillEnum.FORGERY;
import static moon.adn.code.model.character.skills.SkillEnum.SECURITY;
import static moon.adn.code.model.character.skills.SkillEnum.TECH_GEN;
import static moon.adn.code.model.character.skills.SkillEnum.TRAPS;
import static moon.adn.code.model.character.specializations.SpecializationEnum.ARMORY_ARMOR;
import static moon.adn.code.model.character.specializations.SpecializationEnum.ARMORY_BLADES;
import static moon.adn.code.model.character.specializations.SpecializationEnum.ARMORY_FIRE_ARMS;
import static moon.adn.code.model.character.specializations.SpecializationEnum.INGENIOUS_TINKERING;
import static moon.adn.code.model.character.specializations.SpecializationEnum.INVENTION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.TIE_KNOTS;

public class TechieArchetype extends AbstractScientistsArchetype {

	public TechieArchetype() {
		this(1);
	}

	public TechieArchetype(int carrerLevel) {
		super(carrerLevel);
	}

	public void initSkillsToLearn() {
		super.initSkillsToLearn();
		skillsToLearn.add(TRAPS);
		skillsToLearn.add(ARMOURER);
		skillsToLearn.add(CYBER_TECH);
		skillsToLearn.add(DIY);
		skillsToLearn.add(ELECTRONIC);
		skillsToLearn.add(FORGERY);
		skillsToLearn.add(EXPLOSIVES);
		skillsToLearn.add(SECURITY);
		skillsToLearn.add(TECH_GEN);
	}

	@Override
	public void initspecializationsToLearn() {
		super.initspecializationsToLearn();
		// Carrer
		specializationsToLearn.add(INGENIOUS_TINKERING);
		specializationsToLearn.add(ARMORY_ARMOR);
		specializationsToLearn.add(ARMORY_ARMOR);
		specializationsToLearn.add(ARMORY_BLADES);
		specializationsToLearn.add(ARMORY_FIRE_ARMS);
		specializationsToLearn.add(TIE_KNOTS);
		specializationsToLearn.add(INVENTION);
	}
}
