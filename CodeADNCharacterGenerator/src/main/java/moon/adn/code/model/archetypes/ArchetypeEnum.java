package moon.adn.code.model.archetypes;

import static moon.adn.code.model.character.specializations.CarreerEnum.FIGHTER;
import static moon.adn.code.model.character.specializations.CarreerEnum.SCIENTIST;
import static moon.adn.code.model.character.specializations.CarreerEnum.SPY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import moon.adn.code.model.archetypes.fighters.RoninArchetype;
import moon.adn.code.model.archetypes.fighters.SoloArchetype;
import moon.adn.code.model.archetypes.scientists.MedTechieArchetype;
import moon.adn.code.model.archetypes.scientists.TechieArchetype;
import moon.adn.code.model.archetypes.spies.FixerArchetype;
import moon.adn.code.model.archetypes.spies.NetRunnerArchetype;
import moon.adn.code.model.character.specializations.CarreerEnum;

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

	private static Random random = new Random();

	private @Getter CarreerEnum carreer;
	private @Getter AbstractArchetype archetype;

	ArchetypeEnum(CarreerEnum carreer) {
		this.carreer = carreer;
	}

	ArchetypeEnum(CarreerEnum carreer, AbstractArchetype archetype) {
		this(carreer);
		this.archetype = archetype;
	}

	public static ArchetypeEnum random() {
		return values()[random.nextInt(values().length)];
	}

	public static ArchetypeEnum randomFromCarreer(CarreerEnum carreer) {
		List<ArchetypeEnum> list = new ArrayList<>();
		for (ArchetypeEnum archetype : ArchetypeEnum.values()) {
			if (carreer == archetype.carreer) {
				list.add(archetype);
			}
		}
		Collections.shuffle(list);
		return list.get(0);
	}
}