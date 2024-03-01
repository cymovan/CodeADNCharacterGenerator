package moon.adn.code.model.archetypes.fighters;

import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.AG;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.BT;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.CON;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.EMP;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.HEIGHT;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.INT;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.LUCK;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.POW;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.REF;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.STR;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.TECH;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.WILL;
import static moon.adn.code.model.character.skills.SkillEnum.ARMOURER;
import static moon.adn.code.model.character.skills.SkillEnum.ATHLETISM;
import static moon.adn.code.model.character.skills.SkillEnum.COMMANDMENT;
import static moon.adn.code.model.character.skills.SkillEnum.DODGE;
import static moon.adn.code.model.character.skills.SkillEnum.DRIVE_CAR;
import static moon.adn.code.model.character.skills.SkillEnum.GUNS;
import static moon.adn.code.model.character.skills.SkillEnum.INTERROGATOIRE;
import static moon.adn.code.model.character.skills.SkillEnum.RIFFLES;
import static moon.adn.code.model.character.skills.SkillEnum.SEE;
import static moon.adn.code.model.character.skills.SkillEnum.STUNT;
import static moon.adn.code.model.character.skills.SkillEnum.TORTURE_RESISTANCE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.AMBUSH;
import static moon.adn.code.model.character.specializations.SpecializationEnum.BODYBUILDING;
import static moon.adn.code.model.character.specializations.SpecializationEnum.BODY_DEV;
import static moon.adn.code.model.character.specializations.SpecializationEnum.DEMOLITION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.DRUGS_RESIST;
import static moon.adn.code.model.character.specializations.SpecializationEnum.GRENADES;
import static moon.adn.code.model.character.specializations.SpecializationEnum.KNOCK_OUT;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PAIN_RESIST;
import static moon.adn.code.model.character.specializations.SpecializationEnum.RIFLEMAN;
import static moon.adn.code.system.RandomDiceUtil.d10Heroic;

import moon.adn.code.model.archetypes.AbstractArchetype;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.specializations.CareerEnum;

abstract class AbstractFighterArchetype extends AbstractArchetype {

	public AbstractFighterArchetype(int carrerLevel) {
		super(CareerEnum.FIGHTER, carrerLevel);
	}

	public void initCaracteristics() {
		caracteristicsMap.put(AG, new CaractValues(randomMainCaracteristics()));
		caracteristicsMap.put(BT, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(CON, new CaractValues(randomMainCaracteristics()));
		caracteristicsMap.put(EMP, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(HEIGHT, new CaractValues(d10Heroic()));
		caracteristicsMap.put(INT, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(LUCK, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(POW, new CaractValues(randomLowCaracteristics()));
		caracteristicsMap.put(REF, new CaractValues(randomMainCaracteristics()));
		caracteristicsMap.put(STR, new CaractValues(randomMainCaracteristics()));
		caracteristicsMap.put(TECH, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(WILL, new CaractValues(randomMainCaracteristics()));
	}

	@Override
	public void initSkillsToLearn() {
		super.initSkillsToLearn();
		skillsToLearn.add(SEE);
		// Riffles and crossbows
		skillsToLearn.add(RIFFLES);
		skillsToLearn.add(GUNS);
		skillsToLearn.add(DODGE);
		skillsToLearn.add(COMMANDMENT);
		skillsToLearn.add(ARMOURER);
		skillsToLearn.add(ATHLETISM);
		skillsToLearn.add(DRIVE_CAR);
		skillsToLearn.add(STUNT);
		skillsToLearn.add(INTERROGATOIRE);
		skillsToLearn.add(TORTURE_RESISTANCE);
	}

	@Override
	public void initspecializationsToLearn() {
		super.initspecializationsToLearn();
		specializationsToLearn.add(AMBUSH);
		specializationsToLearn.add(BODYBUILDING);
		specializationsToLearn.add(BODY_DEV);
		specializationsToLearn.add(DRUGS_RESIST);
		specializationsToLearn.add(KNOCK_OUT);
		specializationsToLearn.add(PAIN_RESIST);
		specializationsToLearn.add(DEMOLITION);
		specializationsToLearn.add(GRENADES);
		specializationsToLearn.add(RIFLEMAN);
	}
}
