package moon.adn.code.model.character.identity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import moon.adn.code.model.character.specializations.CarreerEnum;

@SpringBootTest
public class JobTests {

	private static final int JOB_CATEGORIES_COUNT = 8;

	private static final String I18N_ROOT_JOBS = "jobs.";
	private static final String I18N_ROOT_JOBS_CATEGORY = "jobs.category.";

	private static final String I18N_ROOT_JOBS_ERROR = "i18n root jobs error";
	private static final String I18N_ROOT_JOBS_CATEGORY_ERROR = "i18n root jobs category error";
	private static final String JOB_ERROR = "Job error";
	private static final String JOB_CATEGORY_ERROR = "Job category error";
	private static final String JOB_CARREER_ERROR = "Job carreer error";

	private JobEnum job;
	private JobCategoryEnum jobCategory;

	@Test
	public void checkJobI18NRootKeyIsCorrect() {
		job = JobEnum.ACCOUNTANT;
		String[] split = job.i18nKey().split(job.toString());
		assertEquals(I18N_ROOT_JOBS, split[0], I18N_ROOT_JOBS_ERROR);
	}

	@Test
	public void obtainingARandomWorks() {
		for (int i = 0; i < 50; i++) {
			job = JobEnum.randomJob();
			assertNotNull(job, JOB_ERROR);
		}
	}

	@Test
	public void obtainingARandomJobFromJobCategoryWorks() {
		for (int i = 0; i < 50; i++) {
			jobCategory = JobCategoryEnum.random();
			job = JobEnum.randomJobUsingRules(jobCategory);
			assertEquals(jobCategory, job.getJobCategory(), JOB_CATEGORY_ERROR);
		}
	}

	@Test
	public void obtainingARandomJobFromFighterCarreerEnumWorks() {
		CarreerEnum carreer = CarreerEnum.FIGHTER;
		job = JobEnum.randomJobUsingRules(carreer);
		assertEquals(carreer, job.getCarreerEnum(), JOB_CARREER_ERROR);
	}

	@Test
	public void obtainingARandomJobFromGeneralCarreerEnumWorks() {
		CarreerEnum carreer = CarreerEnum.GENERAL;
		job = JobEnum.randomJobUsingRules(carreer);
		assertEquals(carreer, job.getCarreerEnum(), JOB_CARREER_ERROR);
	}

	@Test
	public void obtainingARandomJobFromScientistCarreerEnumWorks() {
		CarreerEnum carreer = CarreerEnum.SCIENTIST;
		job = JobEnum.randomJobUsingRules(carreer);
		assertEquals(carreer, job.getCarreerEnum(), JOB_CARREER_ERROR);
	}

	@Test
	public void obtainingARandomJobFromSpyCarreerEnumWorks() {
		CarreerEnum carreer = CarreerEnum.SPY;
		job = JobEnum.randomJobUsingRules(carreer);
		assertEquals(carreer, job.getCarreerEnum(), JOB_CARREER_ERROR);
	}

	@Test
	public void jobCategoriesAreCorrects() {
		assertEquals(JOB_CATEGORIES_COUNT, JobCategoryEnum.values().length);
	}

	@Test
	public void checkJobCategoryI18NRootKeyIsCorrect() {
		jobCategory = JobCategoryEnum.LAW;
		String[] split = jobCategory.i18nKey().split(jobCategory.toString());
		assertEquals(I18N_ROOT_JOBS_CATEGORY, split[0], I18N_ROOT_JOBS_CATEGORY_ERROR);
	}
}
