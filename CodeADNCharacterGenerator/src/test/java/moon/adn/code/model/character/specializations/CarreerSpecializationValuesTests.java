package moon.adn.code.model.character.specializations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarreerSpecializationValuesTests {

	private static final int CONTAINER_DEFAULT = 0;
	private static final int MAX_SEGMENTS_DEFAULT = 20;
	private static final int MAX_BOXES_DEFAULT = 10;
	private static final int DEFAULT_SEGMENTS_CHECKED = 0;
	private static final int DEFAULT_BOXES_CHECKED = 0;

	private CarreerSpecializationValues carreerSpecializationValues;

	@BeforeEach
	public void init() {
		carreerSpecializationValues = new CarreerSpecializationValues();
	}

	@Test
	public void whenCarreerSpecializationValuesAreCreatedValuesThenHAveOnly1BoxAndNotChecked() {
		assertThat(carreerSpecializationValues.getMaxContainer()).isEqualTo(CONTAINER_DEFAULT);
		assertThat(carreerSpecializationValues.getMaxBoxes()).isEqualTo(MAX_BOXES_DEFAULT);
		assertThat(carreerSpecializationValues.getMaxSegments()).isEqualTo(MAX_SEGMENTS_DEFAULT);
		assertThat(carreerSpecializationValues.getBoxesChecked()).isEqualTo(DEFAULT_BOXES_CHECKED);
		assertThat(carreerSpecializationValues.getSegmentsChecked()).isEqualTo(DEFAULT_SEGMENTS_CHECKED);
		assertThat(carreerSpecializationValues.getType()).isEqualTo(SpecializationType.CARREER);
	}

	@Test
	public void whenLevelUpCarreerSpecializationValuesThenItWorks() throws Exception {
		for (int i = 1; i <= MAX_SEGMENTS_DEFAULT; i++) {
			carreerSpecializationValues.levelUp();
			assertSpecializationValues(i, (int) Math.ceil(i / 2));
		}
	}

	@Test
	public void whenLevelUpCarreerSpecializationValuesThenItThrowsGoodException() throws Exception {
		for (int i = 1; i <= MAX_SEGMENTS_DEFAULT; i++) {
			carreerSpecializationValues.levelUp();
		}
		Assertions.assertThrows(MaxBoxesReachedException.class, () -> carreerSpecializationValues.levelUp());
	}

	private void assertSpecializationValues(int segmentsChecked, int boxesChecked) {
		assertSpecializationValues(CONTAINER_DEFAULT, MAX_BOXES_DEFAULT, MAX_SEGMENTS_DEFAULT, boxesChecked,
				segmentsChecked);
	}

	protected void assertSpecializationValues(int maxContainer, int maxBoxes, int maxSegments, int boxesChecked,
			int segmentsChecked) {
		assertThat(carreerSpecializationValues.getMaxContainer()).isEqualTo(maxContainer);
		assertThat(carreerSpecializationValues.getMaxBoxes()).isEqualTo(maxBoxes);
		assertThat(carreerSpecializationValues.getMaxSegments()).isEqualTo(maxSegments);
		assertThat(carreerSpecializationValues.getBoxesChecked()).isEqualTo(boxesChecked);
		assertThat(carreerSpecializationValues.getSegmentsChecked()).isEqualTo(segmentsChecked);
	}
}
