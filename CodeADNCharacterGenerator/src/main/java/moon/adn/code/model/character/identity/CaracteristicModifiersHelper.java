package moon.adn.code.model.character.identity;

import java.util.HashMap;
import java.util.Map;

import moon.adn.code.model.character.builder.CaracteristicSpeciesModifiers;
import moon.adn.code.model.character.builder.CaracteristicsModifier;
import moon.adn.code.model.character.builder.Modifier;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

class CaracteristicModifiersHelper {
	public static CaracteristicSpeciesModifiers humanModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.LUCK, new CaracteristicsModifier(2));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}

	public static CaracteristicSpeciesModifiers urbanElfModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.AG, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.BT, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.CON, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.STR, new CaracteristicsModifier(-1));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}

	public static CaracteristicSpeciesModifiers sylvanElfModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.AG, new CaracteristicsModifier(2));
		modifiersMap.put(CaracteristicEnum.BT, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.CON, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.STR, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.INT, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.REF, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.HEIGHT, new CaracteristicsModifier(1, 5));
		modifiersMap.put(CaracteristicEnum.TECH, new CaracteristicsModifier(-1));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}

	public static CaracteristicSpeciesModifiers paleElfModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.AG, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.BT, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.CON, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.EMP, new CaracteristicsModifier(2));
		modifiersMap.put(CaracteristicEnum.STR, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.POW, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.HEIGHT, new CaracteristicsModifier(1, 5));
		modifiersMap.put(CaracteristicEnum.TECH, new CaracteristicsModifier(-2));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}

	public static CaracteristicSpeciesModifiers greyElfModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.AG, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.BT, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.LUCK, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.CON, new CaracteristicsModifier(-2));
		modifiersMap.put(CaracteristicEnum.STR, new CaracteristicsModifier(-2));
		modifiersMap.put(CaracteristicEnum.POW, new CaracteristicsModifier(2));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}

	public static CaracteristicSpeciesModifiers goldElfModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.AG, new CaracteristicsModifier(2));
		modifiersMap.put(CaracteristicEnum.BT, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.CON, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.STR, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.POW, new CaracteristicsModifier(2));
		modifiersMap.put(CaracteristicEnum.HEIGHT, new CaracteristicsModifier(2, 6));
		modifiersMap.put(CaracteristicEnum.TECH, new CaracteristicsModifier(-2));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}

	public static CaracteristicSpeciesModifiers nightElfModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.AG, new CaracteristicsModifier(2));
		modifiersMap.put(CaracteristicEnum.BT, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.CON, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.STR, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.HEIGHT, new CaracteristicsModifier(1, 5));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}

	public static CaracteristicSpeciesModifiers aquaticElfModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.AG, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.CON, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.STR, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.REF, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.HEIGHT, new CaracteristicsModifier(1, 6));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}

	public static CaracteristicSpeciesModifiers darkElfModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.AG, new CaracteristicsModifier(1));
		modifiersMap.put(CaracteristicEnum.CON, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.EMP, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.STR, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.REF, new CaracteristicsModifier(2));
		modifiersMap.put(CaracteristicEnum.HEIGHT, new CaracteristicsModifier(-2, 1, 7));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}
	
	public static CaracteristicSpeciesModifiers ironBararModifiers() {
		Map<CaracteristicEnum, Modifier> modifiersMap = new HashMap<>();
		modifiersMap.put(CaracteristicEnum.AG, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.BT, new CaracteristicsModifier(-2));
		modifiersMap.put(CaracteristicEnum.CON, new CaracteristicsModifier(2));
		modifiersMap.put(CaracteristicEnum.EMP, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.STR, new CaracteristicsModifier(2));
		modifiersMap.put(CaracteristicEnum.POW, new CaracteristicsModifier(-2));
		modifiersMap.put(CaracteristicEnum.REF, new CaracteristicsModifier(-1));
		modifiersMap.put(CaracteristicEnum.HEIGHT, new CaracteristicsModifier(-3, 1, 5));
		modifiersMap.put(CaracteristicEnum.TECH, new CaracteristicsModifier(2));
		modifiersMap.put(CaracteristicEnum.WILL, new CaracteristicsModifier(2));
		CaracteristicSpeciesModifiers csm = new CaracteristicSpeciesModifiers();
		csm.setModifiersMap(modifiersMap);
		return csm;
	}
}
