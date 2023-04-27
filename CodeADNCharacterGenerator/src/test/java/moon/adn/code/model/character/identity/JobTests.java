package moon.adn.code.model.character.identity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.specializations.CarreerEnum;

@SpringBootTest
public class JobTests {

	private static final int JOB_CATEGORIES_COUNT = 8;

	private static final String I18N_ROOT_JOBS = "jobs.";
	private static final String I18N_ROOT_JOBS_CATEGORY = "jobs.category.";

	private JobEnum job;
	private JobCategoryEnum jobCategory;

	@Test
	public void checkJobI18NRootKeyIsCorrect() {
		job = JobEnum.ACCOUNTANT;
		String[] split = job.i18nKey().split(job.toString());
		assertThat(split[0]).isEqualTo(I18N_ROOT_JOBS);
	}

	@Test
	public void obtainingARandomWorks() {
		for (int i = 0; i < 50; i++) {
			job = JobEnum.randomJob();
			assertThat(job).isNotNull();
		}
	}

	@Test
	public void obtainingARandomJobFromJobCategoryWorks() {
		for (int i = 0; i < 50; i++) {
			jobCategory = JobCategoryEnum.random();
			job = JobEnum.randomJobUsingRules(jobCategory);
			assertThat(job.getJobCategory()).isEqualTo(jobCategory);
		}
	}

	@Test
	public void obtainingARandomJobFromFighterCarreerEnumWorks() {
		CarreerEnum carreer = CarreerEnum.FIGHTER;
		job = JobEnum.randomJobUsingRules(carreer);
		assertThat(job.getCarreerEnum()).isEqualTo(carreer);
	}

	@Test
	public void obtainingARandomJobFromGeneralCarreerEnumWorks() {
		CarreerEnum carreer = CarreerEnum.GENERAL;
		job = JobEnum.randomJobUsingRules(carreer);
		assertThat(job.getCarreerEnum()).isEqualTo(carreer);
	}

	@Test
	public void obtainingARandomJobFromScientistCarreerEnumWorks() {
		CarreerEnum carreer = CarreerEnum.SCIENTIST;
		job = JobEnum.randomJobUsingRules(carreer);
		assertThat(job.getCarreerEnum()).isEqualTo(carreer);
	}

	@Test
	public void obtainingARandomJobFromSpyCarreerEnumWorks() {
		CarreerEnum carreer = CarreerEnum.SPY;
		job = JobEnum.randomJobUsingRules(carreer);
		assertThat(job.getCarreerEnum()).isEqualTo(carreer);
	}

	@Test
	public void jobCategoriesAreCorrects() {
		assertThat(JobCategoryEnum.values()).hasSize(JOB_CATEGORIES_COUNT);
	}

	@Test
	public void checkJobCategoryI18NRootKeyIsCorrect() {
		jobCategory = JobCategoryEnum.LAW;
		String[] split = jobCategory.i18nKey().split(jobCategory.toString());
		assertThat(split[0]).isEqualTo(I18N_ROOT_JOBS_CATEGORY);
	}
}
