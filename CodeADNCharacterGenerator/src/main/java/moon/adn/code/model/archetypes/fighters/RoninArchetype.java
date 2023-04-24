package moon.adn.code.model.archetypes.fighters;

import static moon.adn.code.model.character.skills.SkillEnum.ARMOURER;
import static moon.adn.code.model.character.skills.SkillEnum.BOWS;
import static moon.adn.code.model.character.skills.SkillEnum.FENCING;
import static moon.adn.code.model.character.skills.SkillEnum.KNIFE;
import static moon.adn.code.model.character.skills.SkillEnum.STUNT;
import static moon.adn.code.model.character.skills.SkillEnum.WEAPON;
import static moon.adn.code.model.character.specializations.SpecializationEnum.ARMORY_BLADES;
import static moon.adn.code.model.character.specializations.SpecializationEnum.BALANCE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.BLIND_FIGHT;
import static moon.adn.code.model.character.specializations.SpecializationEnum.MARTIAL_ART_HANSHI;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PRECISE_HIT;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PRECISION;

public class RoninArchetype extends AbstractFighterArchetype {

	public RoninArchetype() {
		this(1);
	}

	public RoninArchetype(int carrerLevel) {
		super(carrerLevel);
	}

	public void initSkillsToLearn() {
		skillsToLearn.add(ARMOURER);
		skillsToLearn.add(BOWS);
		skillsToLearn.add(STUNT);
		skillsToLearn.add(KNIFE);
		skillsToLearn.add(FENCING);
		skillsToLearn.add(WEAPON);

	}

	@Override
	public void initspecializationsToLearn() {
		specializationsToLearn.add(BALANCE);
		specializationsToLearn.add(BLIND_FIGHT);
		specializationsToLearn.add(PRECISE_HIT);
		specializationsToLearn.add(PRECISION);
		specializationsToLearn.add(MARTIAL_ART_HANSHI);
		specializationsToLearn.add(ARMORY_BLADES);
	}
}
