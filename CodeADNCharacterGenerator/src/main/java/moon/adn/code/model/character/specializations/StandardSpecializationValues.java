package moon.adn.code.model.character.specializations;

import static moon.adn.code.model.character.specializations.SpecializationType.STANDARD;

public final class StandardSpecializationValues extends SpecializationValuesAbstract {
	private static final long serialVersionUID = 6780031799167753999L;

	private static final int MAX_BOXES = 4;

	public StandardSpecializationValues() {
		this(MAX_BOXES);
	}

	public StandardSpecializationValues(int maxBoxes) {
		super(maxBoxes, STANDARD);
	}
}
