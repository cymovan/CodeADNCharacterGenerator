package moon.adn.code.model.character.specializations;

/**
 * Implementation of {@link SpecializationValues} of {@link SpecializationEnum}
 * Complex.
 * 
 * @author cdelr
 *
 */
public class ComplexSpecializationValues extends SpecializationValuesAbstract {

	public ComplexSpecializationValues(int maxContainers) {
		this(maxContainers, 4);
	}

	public ComplexSpecializationValues(int maxContainers, int maxBoxes) {
		super(maxContainers, maxBoxes, SpecializationType.COMPLEX);
	}
}
