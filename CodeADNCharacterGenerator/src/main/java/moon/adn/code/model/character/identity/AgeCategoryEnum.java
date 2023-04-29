package moon.adn.code.model.character.identity;

import lombok.Getter;

public enum AgeCategoryEnum {
	CHILD(13), TEENAGER(19), YOUNG_ADULT(29), ADULT(49), EXPERIMENTED_ADULT(74), OLD(99), OLDSTER(124), HUMAN_MAX(149),
	BEYOND_HUMAN_MAX(10000);

	private @Getter int maxAge;

	AgeCategoryEnum(int maxAge) {
		this.maxAge = maxAge;
	}
	
	public static AgeCategoryEnum getAgeCategory(int age) {
		AgeCategoryEnum result = BEYOND_HUMAN_MAX;
		for(AgeCategoryEnum ageCategoryEnum : AgeCategoryEnum.values()) {
			if(ageCategoryEnum.getMaxAge() >= age) {
				return ageCategoryEnum;
			}
		}
		return result;
	}
}
