package moon.adn.code.model.archetypes.spies;

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
import static moon.adn.code.model.character.skills.SkillEnum.DIAG;
import static moon.adn.code.model.character.skills.SkillEnum.DRIVE_CAR;
import static moon.adn.code.model.character.skills.SkillEnum.LISTEN;
import static moon.adn.code.model.character.skills.SkillEnum.SEE;
import static moon.adn.code.model.character.skills.SkillEnum.SMELLING;
import static moon.adn.code.model.character.specializations.CareerEnum.SPY;
import static moon.adn.code.model.character.specializations.SpecializationEnum.KNOCK_OUT;

import moon.adn.code.model.archetypes.AbstractArchetype;
import moon.adn.code.model.character.caracteristics.CaractValues;

abstract class AbstractSpiesArchetype extends AbstractArchetype {

	public AbstractSpiesArchetype() {
		this(1);
	}

	public AbstractSpiesArchetype(int carrerLevel) {
		super(SPY, carrerLevel);
	}

	public void initCaracteristics() {
		caracteristicsMap.put(AG, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(BT, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(CON, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(EMP, new CaractValues(randomMediumCaracteristics()));
		caracteristicsMap.put(HEIGHT, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(INT, new CaractValues(randomMainCaracteristics()));
		caracteristicsMap.put(LUCK, new CaractValues(randomCaracteristics()));
		caracteristicsMap.put(POW, new CaractValues(randomMediumCaracteristics()));
		caracteristicsMap.put(REF, new CaractValues(randomLowCaracteristics()));
		caracteristicsMap.put(STR, new CaractValues(randomLowCaracteristics()));
		caracteristicsMap.put(TECH, new CaractValues(randomMainCaracteristics()));
		caracteristicsMap.put(WILL, new CaractValues(randomCaracteristics()));
	}

	public void initSkillsToLearn() {
		super.initSkillsToLearn();
		skillsToLearn.add(BIBLIO);
		skillsToLearn.add(DIAG);
		skillsToLearn.add(LISTEN);
		skillsToLearn.add(SEE);
		skillsToLearn.add(SMELLING);
		skillsToLearn.add(DRIVE_CAR);
	}

	@Override
	public void initspecializationsToLearn() {
		specializationsToLearn.add(KNOCK_OUT);
	}
}
