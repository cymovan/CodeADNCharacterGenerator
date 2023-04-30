package moon.adn.code.model.character.specializations;

import static moon.adn.code.model.character.specializations.SpecializationType.STANDARD;

final public class StandardSpecializationValues extends SpecializationValuesAbstract {
	private static final int MAX_BOXES = 4;

	public StandardSpecializationValues() {
		this(MAX_BOXES);
	}

	public StandardSpecializationValues(int maxBoxes) {
		super(maxBoxes, STANDARD);
	}
}
