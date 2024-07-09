package moon.adn.code.model.character.skills;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;
import moon.adn.code.model.character.builder.Modifier;

/**
 * @author Cédric DELRUE
 *
 */
@Data
public class SkillValues implements Serializable {
	private static final long serialVersionUID = -8128199424902958779L;

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
