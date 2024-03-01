package moon.adn.code.model.character.specializations;

import static moon.adn.code.model.character.specializations.SpecializationType.career;

/**
 * {@link SpecializationValues} used for work career specializations.
 * 
 * @author Cédric DELRUE
 *
 */
final public class CareerSpecializationValues extends SpecializationValuesAbstract {
	private static final int MAX_CONTAINER = 0;
	private static final int MAX_SEGMENTS = 20;
	private static final int MAX_BOXES = 10;

	public CareerSpecializationValues() {
		super(MAX_CONTAINER, MAX_SEGMENTS, MAX_BOXES, career);
	}

	@Override
	public void levelUp() throws MaxBoxesReachedException {
		if (segmentsChecked < maxSegments) {
			segmentsChecked++;
		} else {
			throw new MaxBoxesReachedException();
		}
		if (segmentsChecked % 2 == 0 && boxesChecked < maxBoxes) {
			boxesChecked++;
		}
	}
}
