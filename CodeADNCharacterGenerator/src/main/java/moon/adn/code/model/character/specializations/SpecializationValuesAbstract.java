package moon.adn.code.model.character.specializations;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpecializationValuesAbstract implements SpecializationValues {
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
	 * Default comportment when spending a carreer point.
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
