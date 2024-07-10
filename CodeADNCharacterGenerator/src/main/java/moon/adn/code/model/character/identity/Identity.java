package moon.adn.code.model.character.identity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import moon.adn.code.model.character.identity.apparence.EyesColorEnum;
import moon.adn.code.model.character.identity.apparence.HairColourEnum;

/**
 * Identity of a character
 * 
 * @author Cédric DELRUE
 *
 */
@Data
@NoArgsConstructor
public class Identity implements Serializable {
	private static final long serialVersionUID = 3909194497406094012L;

	private String name;
	private int age;
	private HairColourEnum hairColor;
	private EyesColorEnum eyeColor;
	private SpeciesEnum species;
	private SexEnum sex;
	private int socialLevel;
	private int socialOrigin;
	private JobEnum job;
}
