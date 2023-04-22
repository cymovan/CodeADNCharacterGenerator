package moon.adn.code.character.generator.restcontroller;

import moon.adn.code.model.character.NPC;
import moon.adn.code.model.character.PunchingBall;

/**
 * Interface for a CharacterGenerator
 * 
 * @author cdelr
 *
 */
public interface NPCGeneratorController<Clazz extends NPC> {

	/**
	 * @return Standard {@link NPC}
	 */
	Clazz createCaracter();

	/**
	 * @return Standard {@link NPC}
	 */
	Clazz createMedTech();

	/**
	 * @return Standard {@link PunchingBall}
	 */
	PunchingBall createPunchingBall();

}
