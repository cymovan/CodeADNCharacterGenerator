package moon.adn.code.model.character.specializations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CareerSpecializationValuesTests {

	private static final int CONTAINER_DEFAULT = 0;
	private static final int MAX_SEGMENTS_DEFAULT = 20;
	private static final int MAX_BOXES_DEFAULT = 10;
	private static final int DEFAULT_SEGMENTS_CHECKED = 0;
	private static final int DEFAULT_BOXES_CHECKED = 0;

	private CareerSpecializationValues careerSpecializationValues;

	@BeforeEach
	public void init() {
		careerSpecializationValues = new CareerSpecializationValues();
	}

	@Test
	public void whencareerSpecializationValuesAreCreatedValuesThenHAveOnly1BoxAndNotChecked() {
		assertThat(careerSpecializationValues.getMaxContainer()).isEqualTo(CONTAINER_DEFAULT);
		assertThat(careerSpecializationValues.getMaxBoxes()).isEqualTo(MAX_BOXES_DEFAULT);
		assertThat(careerSpecializationValues.getMaxSegments()).isEqualTo(MAX_SEGMENTS_DEFAULT);
		assertThat(careerSpecializationValues.getBoxesChecked()).isEqualTo(DEFAULT_BOXES_CHECKED);
		assertThat(careerSpecializationValues.getSegmentsChecked()).isEqualTo(DEFAULT_SEGMENTS_CHECKED);
		assertThat(careerSpecializationValues.getType()).isEqualTo(SpecializationType.CAREER);
	}

	@Test
	public void whenLevelUpcareerSpecializationValuesThenItWorks() throws Exception {
		for (int i = 1; i <= MAX_SEGMENTS_DEFAULT; i++) {
			careerSpecializationValues.levelUp();
			assertSpecializationValues(i, (int) Math.ceil(i / 2));
		}
	}

	@Test
	public void whenLevelUpcareerSpecializationValuesThenItThrowsGoodException() throws Exception {
		for (int i = 1; i <= MAX_SEGMENTS_DEFAULT; i++) {
			careerSpecializationValues.levelUp();
		}
		Assertions.assertThrows(MaxBoxesReachedException.class, () -> careerSpecializationValues.levelUp());
	}

	private void assertSpecializationValues(int segmentsChecked, int boxesChecked) {
		assertSpecializationValues(CONTAINER_DEFAULT, MAX_BOXES_DEFAULT, MAX_SEGMENTS_DEFAULT, boxesChecked,
				segmentsChecked);
	}

	protected void assertSpecializationValues(int maxContainer, int maxBoxes, int maxSegments, int boxesChecked,
			int segmentsChecked) {
		assertThat(careerSpecializationValues.getMaxContainer()).isEqualTo(maxContainer);
		assertThat(careerSpecializationValues.getMaxBoxes()).isEqualTo(maxBoxes);
		assertThat(careerSpecializationValues.getMaxSegments()).isEqualTo(maxSegments);
		assertThat(careerSpecializationValues.getBoxesChecked()).isEqualTo(boxesChecked);
		assertThat(careerSpecializationValues.getSegmentsChecked()).isEqualTo(segmentsChecked);
	}
}
