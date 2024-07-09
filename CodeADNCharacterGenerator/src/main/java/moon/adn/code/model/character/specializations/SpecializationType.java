package moon.adn.code.model.character.specializations;

/**
 * Definition of a {@link SpecializationEnum} Type.
 * 
 * @author Cédric DELRUE
 *
 */
public enum SpecializationType {
	/**
	 * Only one box, maxBoxes = 1
	 */
	BOOLEAN,
	/**
	 * 1 Box give a bonus (maxBoxes between 4 and 8.) +1 for each box checked
	 */
	STANDARD,
	/**
	 * career specialization. Need to be taken twice for each level. maxSegments =
	 * 20. maxBoxes = 10;
	 */
	CAREER,
	/**
	 * Container made of 4 boxes maxSegments = 0, maxContainers = 1 or 2, maxBoxes =
	 * 4 or 8
	 */
	COMPLEX;
}
