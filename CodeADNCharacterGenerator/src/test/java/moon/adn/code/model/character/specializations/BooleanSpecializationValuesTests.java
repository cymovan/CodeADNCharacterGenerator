package moon.adn.code.model.character.specializations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BooleanSpecializationValuesTests {

	private static final int CONTAINER_DEFAULT = 0;
	private static final int SEGMENTS_DEFAULT = 0;
	private static final int MAX_BOXES_DEFAULT = 1;
	private static final int DEFAULT_SEGMENTS_CHECKED = 0;
	private static final int DEFAULT_BOXES_CHECKED = 0;

	private BooleanSpecializationValues booleanSpecialization;

	@BeforeEach
	public void init() {
		booleanSpecialization = new BooleanSpecializationValues();
	}

	@Test
	public void whenBooleanSpecializationValuesAreCreatedValuesThenHAveOnly1BoxAndNotChecked() {
		assertThat(booleanSpecialization.getMaxBoxes()).isEqualTo(MAX_BOXES_DEFAULT);
		assertThat(booleanSpecialization.getMaxContainer()).isEqualTo(CONTAINER_DEFAULT);
		assertThat(booleanSpecialization.getMaxSegments()).isEqualTo(SEGMENTS_DEFAULT);
		assertThat(booleanSpecialization.getBoxesChecked()).isEqualTo(DEFAULT_BOXES_CHECKED);
		assertThat(booleanSpecialization.getSegmentsChecked()).isEqualTo(DEFAULT_SEGMENTS_CHECKED);
		assertThat(booleanSpecialization.getType()).isEqualTo(SpecializationType.BOOLEAN);
	}

	@Test
	public void whenLevelUpBooleanSpecializationValuesThenItWorks() throws Exception {
		booleanSpecialization.levelUp();
		assertSpecializationValues(MAX_BOXES_DEFAULT);
	}

	@Test
	public void whenLevelUpBooleanSpecializationValuesAreCreatedValuesThenItThrowsGoodException() throws Exception {
		booleanSpecialization.levelUp();
		Assertions.assertThrows(MaxBoxesReachedException.class, () -> booleanSpecialization.levelUp());
	}

	private void assertSpecializationValues(int boxesChecked) {
		assertSpecializationValues(CONTAINER_DEFAULT, MAX_BOXES_DEFAULT, SEGMENTS_DEFAULT, boxesChecked,
				DEFAULT_SEGMENTS_CHECKED);
	}

	private void assertSpecializationValues(int maxContainer, int maxBoxes, int maxSegments, int boxesChecked,
			int segmentsChecked) {
		assertThat(booleanSpecialization.getMaxContainer()).isEqualTo(CONTAINER_DEFAULT);
		assertThat(booleanSpecialization.getMaxBoxes()).isEqualTo(MAX_BOXES_DEFAULT);
		assertThat(booleanSpecialization.getMaxSegments()).isEqualTo(SEGMENTS_DEFAULT);
		assertThat(booleanSpecialization.getBoxesChecked()).isEqualTo(boxesChecked);
		assertThat(booleanSpecialization.getSegmentsChecked()).isEqualTo(DEFAULT_SEGMENTS_CHECKED);
	}
}
