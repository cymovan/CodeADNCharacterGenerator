package moon.adn.code.character.generator.restcontroller;

import moon.adn.code.model.character.NPC;
import moon.adn.code.model.character.PunchingBall;

/**
 * Interface for a CharacterGenerator
 * 
 * @author Cédric DELRUE
 *
 */
public interface NPCGeneratorController<T extends NPC> {

	/**
	 * @return Standard {@link NPC}
	 */
	T createCaracter();

	/**
	 * @return Standard {@link NPC}
	 */
	T createMedTech();

	/**
	 * @return Standard {@link PunchingBall}
	 */
	PunchingBall createPunchingBall();
}
