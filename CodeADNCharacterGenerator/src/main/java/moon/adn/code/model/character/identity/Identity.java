package moon.adn.code.model.character.identity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import moon.adn.code.model.character.identity.apparence.EyesColorEnum;
import moon.adn.code.model.character.identity.apparence.HairColourEnum;

/**
 * Identity of a character
 * 
 * @author cdelr
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Identity {
	private String name;
	private int yearOfBirth;
	private HairColourEnum hairColor;
	private EyesColorEnum eyeColor;
	private SpeciesEnum species;
	private sexEnum sex;
	private int socialLevel, socialOrigin;
}
