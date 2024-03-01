package moon.adn.code.model.archetypes.generals;

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
import static moon.adn.code.model.character.skills.SkillEnum.BIBLIO;
import static moon.adn.code.model.character.skills.SkillEnum.CHAT;
import static moon.adn.code.model.character.skills.SkillEnum.DODGE;
import static moon.adn.code.model.character.skills.SkillEnum.DRIVE_CAR;
import static moon.adn.code.model.character.skills.SkillEnum.GUNS;
import static moon.adn.code.model.character.skills.SkillEnum.HUMAN_PERCEPTION;
import static moon.adn.code.model.character.skills.SkillEnum.LAW;
import static moon.adn.code.model.character.skills.SkillEnum.RIFFLES;
import static moon.adn.code.model.character.skills.SkillEnum.SEE;
import static moon.adn.code.model.character.specializations.SpecializationEnum.LOCAL_ECONOMY;
import static moon.adn.code.model.character.specializations.SpecializationEnum.LOOK;
import static moon.adn.code.model.character.specializations.SpecializationEnum.STYLE;

import moon.adn.code.model.archetypes.AbstractArchetype;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.specializations.CareerEnum;

abstract class AbstractGeneralArchetype extends AbstractArchetype {

	public AbstractGeneralArchetype(int carrerLevel) {
		super(CareerEnum.GENERAL, carrerLevel);
	}

	public void initCaracteristics() {
		caracteristicsMap.put(AG, new CaractValues(randomMainCaracteristics()));
		caracteristicsMap.put(BT, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(CON, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(EMP, new CaractValues(randomMainCaracteristics()));
		caracteristicsMap.put(HEIGHT, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(INT, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(LUCK, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(POW, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(REF, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(STR, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(TECH, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(WILL, new CaractValues(randomCaracteristics()));
	}

	@Override
	public void initSkillsToLearn() {
		super.initSkillsToLearn();
		skillsToLearn.add(SEE);
		skillsToLearn.add(BIBLIO);
		skillsToLearn.add(LAW);
		// Riffles and crossbows
		skillsToLearn.add(RIFFLES);
		skillsToLearn.add(GUNS);
		skillsToLearn.add(DODGE);
		skillsToLearn.add(DRIVE_CAR);
		skillsToLearn.add(CHAT);
		skillsToLearn.add(HUMAN_PERCEPTION);
		skillsToLearn.add(HUMAN_PERCEPTION);
	}

	@Override
	public void initspecializationsToLearn() {
		super.initspecializationsToLearn();
		specializationsToLearn.add(LOOK);
		specializationsToLearn.add(STYLE);
		specializationsToLearn.add(LOCAL_ECONOMY);
	}
}
