package moon.adn.code.view.model;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import moon.adn.code.model.archetypes.ArchetypeEnum;
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class CharacterFormVO {
	private SexEnum sex;
	private Set<ArchetypeEnum> archetypes;
	private Set<SpeciesEnum> species;
}
