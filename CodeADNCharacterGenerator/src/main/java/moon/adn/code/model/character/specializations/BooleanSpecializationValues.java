package moon.adn.code.model.character.specializations;

import static moon.adn.code.model.character.specializations.SpecializationType.BOOLEAN;

/**
 * Boolean version of {@link SpecializationValues}.
 * 
 * @author Cédric DELRUE
 *
 */
public final class BooleanSpecializationValues extends SpecializationValuesAbstract {
	private static final long serialVersionUID = 2812758764677714887L;

	private static final int MAX_BOXES = 1;

	public BooleanSpecializationValues() {
		super(MAX_BOXES, BOOLEAN);
	}
}
