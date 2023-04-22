package moon.adn.code.character.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import moon.adn.code.model.character.NPC;
import moon.adn.code.model.character.PunchingBall;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.skills.SkillEnum;

public class PunchingBallGeneratorImpl extends AbstractCharacterGenerator<PunchingBall> {
	List<CaracteristicEnum> caractToRemove = new ArrayList<>();

	public PunchingBallGeneratorImpl() {
		super();
		initCaractsToRemove();
		initSkillToLearn();
	}

	/**
	 * Build and consolidate Datas of the {@link NPC}.
	 */
	public PunchingBall build() {
		PunchingBall character = new PunchingBall();
		commonBuild(character);
		spendSkillsPoints(40, 6);
		removeUselessCaracteristics(character);
		return character;
	}

	private void removeUselessCaracteristics(PunchingBall punchingBall) {
		Map<CaracteristicEnum, CaractValues> caractsMap = punchingBall.getCaracteristicsMap();
		for (CaracteristicEnum caract : caractToRemove) {
			caractsMap.remove(caract);
		}
	}

	private void initCaractsToRemove() {
		caractToRemove.add(CaracteristicEnum.HEIGHT);
		caractToRemove.add(CaracteristicEnum.TECH);
		caractToRemove.add(CaracteristicEnum.BT);
		caractToRemove.add(CaracteristicEnum.POW);
		caractToRemove.add(CaracteristicEnum.INT);
		caractToRemove.add(CaracteristicEnum.EMP);
		caractToRemove.add(CaracteristicEnum.LUCK);
	}
	
	private void initSkillToLearn() {
		skillsToLearn.add(SkillEnum.GUNS);
		skillsToLearn.add(SkillEnum.RIFFLES);
		skillsToLearn.add(SkillEnum.DODGE);
	}
}
