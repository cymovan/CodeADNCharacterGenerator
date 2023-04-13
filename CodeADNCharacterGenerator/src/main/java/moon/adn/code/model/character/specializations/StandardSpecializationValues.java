package moon.adn.code.model.character.specializations;

public class StandardSpecializationValues extends SpecializationValuesAbstract {

	public StandardSpecializationValues() {
		this(4);
	}

	public StandardSpecializationValues(int maxBoxes) {
		super(maxBoxes, SpecializationType.STANDARD);
	}
}
