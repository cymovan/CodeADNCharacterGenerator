package moon.adn.code.model.character.specializations;

/**
 * Implementation of {@link SpecializationValues} of {@link SpecializationEnum}
 * Complex.
 * 
 * @author Cédric DELRUE
 *
 */
public class ComplexSpecializationValues extends SpecializationValuesAbstract {

	private static final int DEFAULT_MIN_CONTAINER = 1;
	private static final int BOXES_COUNT_IN_CONTAINER = 4;

	public ComplexSpecializationValues() {
		this(DEFAULT_MIN_CONTAINER);
	}

	public ComplexSpecializationValues(int maxContainers) {
		this(maxContainers, maxContainers * BOXES_COUNT_IN_CONTAINER);
	}

	private ComplexSpecializationValues(int maxContainers, int maxBoxes) {
		super(maxContainers, maxBoxes, SpecializationType.COMPLEX);
	}
}
