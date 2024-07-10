package moon.adn.code.model.character.specializations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StandardSpecializationValuesTests {

	private static final int CONTAINER_DEFAULT = 0;
	private static final int SEGMENTS_DEFAULT = 0;
	private static final int MAX_BOXES_DEFAULT = 4;
	private static final int DEFAULT_SEGMENTS_CHECKED = 0;
	private static final int DEFAULT_BOXES_CHECKED = 0;

	private StandardSpecializationValues standardSpecialization;

	@BeforeEach
	void init() {
		standardSpecialization = new StandardSpecializationValues();
	}

	@Test
	void whenStandardSpecializationValuesAreCreatedValuesThenHAveOnly4BocesAndNotChecked() {
		assertThat(standardSpecialization.getMaxContainer()).isEqualTo(CONTAINER_DEFAULT);
		assertThat(standardSpecialization.getMaxBoxes()).isEqualTo(MAX_BOXES_DEFAULT);
		assertThat(standardSpecialization.getMaxSegments()).isEqualTo(SEGMENTS_DEFAULT);
		assertThat(standardSpecialization.getBoxesChecked()).isEqualTo(DEFAULT_BOXES_CHECKED);
		assertThat(standardSpecialization.getSegmentsChecked()).isEqualTo(DEFAULT_SEGMENTS_CHECKED);
		assertThat(standardSpecialization.getType()).isEqualTo(SpecializationType.STANDARD);
	}

	@Test
	void whenLevelUpStandardSpecializationValuesThenItWorks() throws Exception {
		for (int i = 1; i <= 4; i++) {
			standardSpecialization.levelUp();
		}
		assertSpecializationValues(MAX_BOXES_DEFAULT);
	}

	@Test
	void whenLevelStandardUpSpecializationValuesAreCreatedValuesThenItThrowsGoodException() throws Exception {
		for (int i = 1; i <= 4; i++) {
			standardSpecialization.levelUp();
		}
		Assertions.assertThrows(MaxBoxesReachedException.class, () -> standardSpecialization.levelUp());
	}

	private void assertSpecializationValues(int boxesChecked) {
		assertThat(standardSpecialization.getMaxContainer()).isEqualTo(CONTAINER_DEFAULT);
		assertThat(standardSpecialization.getMaxBoxes()).isEqualTo(MAX_BOXES_DEFAULT);
		assertThat(standardSpecialization.getMaxSegments()).isEqualTo(SEGMENTS_DEFAULT);
		assertThat(standardSpecialization.getBoxesChecked()).isEqualTo(boxesChecked);
		assertThat(standardSpecialization.getSegmentsChecked()).isEqualTo(DEFAULT_SEGMENTS_CHECKED);
	}
}
