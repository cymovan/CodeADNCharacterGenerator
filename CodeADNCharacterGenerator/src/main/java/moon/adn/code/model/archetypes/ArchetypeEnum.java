package moon.adn.code.model.archetypes;

import static moon.adn.code.model.character.specializations.CareerEnum.FIGHTER;
import static moon.adn.code.model.character.specializations.CareerEnum.SCIENTIST;
import static moon.adn.code.model.character.specializations.CareerEnum.SPY;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import moon.adn.code.model.archetypes.fighters.RoninArchetype;
import moon.adn.code.model.archetypes.fighters.SoloArchetype;
import moon.adn.code.model.archetypes.scientists.MedTechieArchetype;
import moon.adn.code.model.archetypes.scientists.TechieArchetype;
import moon.adn.code.model.archetypes.spies.FixerArchetype;
import moon.adn.code.model.archetypes.spies.NetRunnerArchetype;
import moon.adn.code.model.character.specializations.CareerEnum;

/**
 * Contain the list of all archetypes.
 * 
 * @author Cédric DELRUE
 *
 */
public enum ArchetypeEnum {
	SOLO(FIGHTER, new SoloArchetype()), RONIN(FIGHTER, new RoninArchetype()),
	MEDTECHIE(SCIENTIST, new MedTechieArchetype()), TECHIE(SCIENTIST, new TechieArchetype()),
	NETRUNNER(SPY, new NetRunnerArchetype()), FIXER(SPY, new FixerArchetype());

	private static SecureRandom random = new SecureRandom();

	private @Getter CareerEnum career;
	private @Getter AbstractArchetype archetype;

	ArchetypeEnum(CareerEnum career) {
		this.career = career;
	}

	ArchetypeEnum(CareerEnum career, AbstractArchetype archetype) {
		this(career);
		this.archetype = archetype;
	}

	public static ArchetypeEnum random() {
		return values()[random.nextInt(values().length)];
	}

	public static ArchetypeEnum randomFromcareer(CareerEnum career) {
		List<ArchetypeEnum> list = new ArrayList<>();
		for (ArchetypeEnum archetype : ArchetypeEnum.values()) {
			if (career == archetype.career) {
				list.add(archetype);
			}
		}
		Collections.shuffle(list);
		return list.get(0);
	}
}