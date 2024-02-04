package moon.adn.code.view.model;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import moon.adn.code.model.character.identity.SpeciesEnum;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class CharacterFormVO {
	private Set<SpeciesEnum> species;

}
