package moon.adn.code.model.archetypes.fighters;

import static moon.adn.code.model.character.skills.SkillEnum.EXPLOSIVES;
import static moon.adn.code.model.character.skills.SkillEnum.KNIFE;
import static moon.adn.code.model.character.skills.SkillEnum.STUNT;
import static moon.adn.code.model.character.specializations.SpecializationEnum.BLIND_FIGHT;
import static moon.adn.code.model.character.specializations.SpecializationEnum.BODYBUILDING;
import static moon.adn.code.model.character.specializations.SpecializationEnum.BODY_DEV;
import static moon.adn.code.model.character.specializations.SpecializationEnum.DEMOLITION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.GRENADES;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PRECISION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.SNIPER;

public class SoloArchetype extends AbstractFighterArchetype {

	public SoloArchetype() {
		this(1);
	}

	public SoloArchetype(int carrerLevel) {
		super(carrerLevel);
	}

	@Override
	public void initSkillsToLearn() {
		super.initSkillsToLearn();
		skillsToLearn.add(EXPLOSIVES);
		skillsToLearn.add(STUNT);
		skillsToLearn.add(KNIFE);
	}

	@Override
	public void initspecializationsToLearn() {
		super.initspecializationsToLearn();
		specializationsToLearn.add(BODYBUILDING);
		specializationsToLearn.add(BLIND_FIGHT);
		specializationsToLearn.add(BODY_DEV);
		specializationsToLearn.add(DEMOLITION);
		specializationsToLearn.add(GRENADES);
		specializationsToLearn.add(PRECISION);
		specializationsToLearn.add(SNIPER);
	}
}
