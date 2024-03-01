package moon.adn.code.model.character.specializations;

/**
 * Contract that defines possible actions on {@link SpecializationValues}.
 * 
 * @author Cédric DELRUE
 *
 */
public interface SpecializationValues {

	/**
	 * Method used to level up a {@link SpecializationValues}
	 * 
	 * @throws MaxBoxesReachedException if it's not possible return that exception
	 *                                  usefull to know if a career point can be
	 *                                  used or not.
	 */
	public void levelUp() throws MaxBoxesReachedException;

}
