package moon.adn.code.model.character.identity;

import lombok.Getter;
import moon.adn.code.system.RandomDiceUtil;

public enum SocialOriginEnum {
	STREET(2, 1), LOW_CLASS(5, 3), MIDDLE_CLASS(7, 6), UPPER_CLASS(8, 10), RICH(9, 13), NAOHM(10, 16);

	private @Getter int maxD10Value;
	private @Getter int socialOriginValue;

	SocialOriginEnum(int maxD10Value, int socialOriginValue) {
		this.maxD10Value = maxD10Value;
		this.socialOriginValue = socialOriginValue;
	}

	public static SocialOriginEnum randomSocialOrigin() {
		SocialOriginEnum result = STREET;
		int d10 = RandomDiceUtil.d10();
		for (SocialOriginEnum it : values()) {
			if (it.maxD10Value - d10 >= 0) {
				return it;
			}
		}
		return result;
	}
}
