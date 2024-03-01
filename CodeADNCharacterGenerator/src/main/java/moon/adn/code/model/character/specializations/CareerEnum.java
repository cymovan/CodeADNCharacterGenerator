package moon.adn.code.model.character.specializations;

import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.AG;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.CON;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.EMP;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.INT;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.LUCK;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.POW;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.REF;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.STR;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.TECH;
import static moon.adn.code.model.character.caracteristics.CaracteristicEnum.WILL;

import java.util.Map;
import java.util.Random;

import moon.adn.code.model.character.AbstractCharacter;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

public enum CareerEnum {
	GENERAL, FIGHTER, SPY, SCIENTIST, MYSTIC;

	private static Random random = new Random();

	public static int getHobbiesPoints(CareerEnum career, AbstractCharacter character) {
		int result = 30;
		switch (career) {
		case GENERAL: {
			result = calculateHobbiesPoints(character, CON, WILL);
			break;
		}
		case FIGHTER: {
			result = calculateHobbiesPoints(character, STR, REF);
			break;
		}
		case SCIENTIST: {
			result = calculateHobbiesPoints(character, INT, EMP);
			break;
		}
		case SPY: {
			result = calculateHobbiesPoints(character, TECH, AG);
			break;
		}
		case MYSTIC: {
			result = calculateHobbiesPoints(character, POW, LUCK);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + career);
		}
		return result;
	}

	private static final int calculateHobbiesPoints(AbstractCharacter character, CaracteristicEnum first,
			CaracteristicEnum second) {
		int result = 0;
		Map<CaracteristicEnum, CaractValues> caracts = character.getCaracteristicsMap();
		result = caracts.get(first).getCurrentValue() + caracts.get(second).getCurrentValue();
		return result * 2;
	}

	public static CareerEnum random() {
		return values()[random.nextInt(values().length)];
	}
}
