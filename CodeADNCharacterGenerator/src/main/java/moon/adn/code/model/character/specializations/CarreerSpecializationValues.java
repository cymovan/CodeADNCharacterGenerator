package moon.adn.code.model.character.specializations;

public class CarreerSpecializationValues extends SpecializationValuesAbstract {

	public CarreerSpecializationValues() {
		super(0, 20, 10, SpecializationType.CARREER);
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
