package moon.adn.code.model.character.skills;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;
import moon.adn.code.model.character.builder.Modifier;

/**
 * @author cdelr
 *
 */
@Data
public class SkillValues {
	private int initScore, currentScore, speciesModifier;
	public static final int MAX_SCORE = 10;

	@JsonCreator
	public SkillValues() {

	}

	public SkillValues(int initScore) {
		this.initScore = initScore;
		this.currentScore = initScore;
	}

	public SkillValues(int initScore, Modifier modifier) {
		this(initScore);
		this.speciesModifier = modifier.getValue();
	}

	public SkillValues(int initScore, int currentScore, Modifier modifier) {
		this(initScore, modifier);
		this.currentScore = currentScore;
	}

	public void applySkillModifiers(Modifier modifier) {

	}
}
