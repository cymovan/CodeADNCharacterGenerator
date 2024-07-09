package moon.adn.code.model.character.specializations;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComplexSpecializationValuesTests {

	private static final int CONTAINER_DEFAULT = 1;
	private static final int SEGMENTS_DEFAULT = 0;
	private static final int MAX_BOXES_DEFAULT = 4;
	private static final int DEFAULT_SEGMENTS_CHECKED = 0;
	private static final int DEFAULT_BOXES_CHECKED = 0;

	private ComplexSpecializationValues complexSpecialization;

	@BeforeEach
	void init() {
		complexSpecialization = new ComplexSpecializationValues();
	}

	@Test
	void whenComplexSpecializationValuesAreCreatedValuesThenHaveOnly4BoxesAndNotChecked() {
		assertThat(complexSpecialization.getMaxContainer()).isEqualTo(CONTAINER_DEFAULT);
		assertThat(complexSpecialization.getMaxBoxes()).isEqualTo(MAX_BOXES_DEFAULT);
		assertThat(complexSpecialization.getMaxSegments()).isEqualTo(SEGMENTS_DEFAULT);
		assertThat(complexSpecialization.getBoxesChecked()).isEqualTo(DEFAULT_BOXES_CHECKED);
		assertThat(complexSpecialization.getSegmentsChecked()).isEqualTo(DEFAULT_SEGMENTS_CHECKED);
		assertThat(complexSpecialization.getType()).isEqualTo(SpecializationType.COMPLEX);
	}

	@Test
	void whenComplexSpecializationValuesOf2ContainersAreCreatedValuesThenHave8BoxesAndNotChecked() {
		complexSpecialization = new ComplexSpecializationValues(2);
		assertThat(complexSpecialization.getMaxContainer()).isEqualTo(CONTAINER_DEFAULT * 2);
		assertThat(complexSpecialization.getMaxBoxes()).isEqualTo(MAX_BOXES_DEFAULT * 2);
		assertThat(complexSpecialization.getMaxSegments()).isEqualTo(SEGMENTS_DEFAULT);
		assertThat(complexSpecialization.getBoxesChecked()).isEqualTo(DEFAULT_BOXES_CHECKED);
		assertThat(complexSpecialization.getSegmentsChecked()).isEqualTo(DEFAULT_SEGMENTS_CHECKED);
		assertThat(complexSpecialization.getType()).isEqualTo(SpecializationType.COMPLEX);
	}

	@Test
	void whenLevelUpStandardSpecializationValuesThenItWorks() throws Exception {
		for (int i = 1; i <= 4; i++) {
			complexSpecialization.levelUp();
		}
		assertSpecializationValues(1, MAX_BOXES_DEFAULT);
	}

	@Test
	void whenLevelUpComplexSpecializationValuesTooMuchValuesThenItThrowsGoodException() throws Exception {
		for (int i = 1; i <= 4; i++) {
			complexSpecialization.levelUp();
		}
		Assertions.assertThrows(MaxBoxesReachedException.class, () -> complexSpecialization.levelUp());
	}

	@Test
	void whenLevelUpMultipleComplexeSpecializationValuesThenItWorks() throws Exception {
		int multipleContainer = 4;
		complexSpecialization = new ComplexSpecializationValues(multipleContainer);
		for (int i = 1; i <= MAX_BOXES_DEFAULT; i++) {
			complexSpecialization.levelUp();
			assertSpecializationValues(multipleContainer, i);
		}
	}

	@Test
	void whenLevelUpMultipleComplexeSpecializationValuesTooMuchThenItThrowsGoodException() throws Exception {
		int multipleContainer = 3;
		complexSpecialization = new ComplexSpecializationValues(multipleContainer);
		for (int i = 1; i <= multipleContainer * MAX_BOXES_DEFAULT; i++) {
			complexSpecialization.levelUp();
			assertSpecializationValues(multipleContainer, i);
		}
		Assertions.assertThrows(MaxBoxesReachedException.class, () -> complexSpecialization.levelUp());

	}

	private void assertSpecializationValues(int maxContainers, int boxesChecked) {
		assertSpecializationValues(maxContainers, maxContainers * MAX_BOXES_DEFAULT, SEGMENTS_DEFAULT, boxesChecked,
				DEFAULT_SEGMENTS_CHECKED);
	}

	private void assertSpecializationValues(int maxContainer, int maxBoxes, int maxSegments, int boxesChecked,
			int segmentsChecked) {
		assertThat(complexSpecialization.getMaxContainer()).isEqualTo(maxContainer);
		assertThat(complexSpecialization.getMaxBoxes()).isEqualTo(maxBoxes);
		assertThat(complexSpecialization.getMaxSegments()).isEqualTo(maxSegments);
		assertThat(complexSpecialization.getBoxesChecked()).isEqualTo(boxesChecked);
		assertThat(complexSpecialization.getSegmentsChecked()).isEqualTo(segmentsChecked);
	}
}
