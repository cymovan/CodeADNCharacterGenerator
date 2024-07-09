package moon.adn.code.model.character.specializations;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Design pattern template, not used to be implemented but called by its
 * children class ({@link BooleanSpecializationValues},
 * {@link ComplexSpecializationValues}, {@link careerSpecializationValues} and
 * {@link StandardSpecializationValues}).
 * 
 * @author cdelr
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class SpecializationValuesAbstract implements SpecializationValues, Serializable {
	private static final long serialVersionUID = 7266558293532034181L;

	protected SpecializationType type;
	protected int maxContainer = 0, maxSegments = 0, maxBoxes = 0;
	protected int segmentsChecked = 0, boxesChecked = 0;

	protected SpecializationValuesAbstract(int maxBoxes, SpecializationType type) {
		this.maxBoxes = maxBoxes;
		this.type = type;
	}

	protected SpecializationValuesAbstract(int maxContainer, int maxBoxes, SpecializationType type) {
		this(maxBoxes, type);
		this.maxContainer = maxContainer;
	}

	public SpecializationValuesAbstract(int maxContainer, int maxSegments, int maxBoxes, SpecializationType type) {
		this(maxContainer, maxBoxes, type);
		this.maxSegments = maxSegments;
	}

	/**
	 * Default comportment when spending a career point.
	 */
	@Override
	public void levelUp() throws MaxBoxesReachedException {
		if (boxesChecked < maxBoxes) {
			boxesChecked++;
		} else {
			throw new MaxBoxesReachedException();
		}
	}
}
