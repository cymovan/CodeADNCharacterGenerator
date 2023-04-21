package moon.adn.code.model.character.history.raec;

import static moon.adn.code.model.character.history.HistoryHelper.getPositionFromIntervals;
import static moon.adn.code.model.character.history.raec.JobCategoryEnum.CORPO;
import static moon.adn.code.model.character.history.raec.JobCategoryEnum.ENTERTAINMENT;
import static moon.adn.code.model.character.history.raec.JobCategoryEnum.GOVERNMENT;
import static moon.adn.code.model.character.history.raec.JobCategoryEnum.ILLEGAL;
import static moon.adn.code.model.character.history.raec.JobCategoryEnum.LAW;
import static moon.adn.code.model.character.history.raec.JobCategoryEnum.NAOHM;
import static moon.adn.code.model.character.history.raec.JobCategoryEnum.STANDARD;
import static moon.adn.code.model.character.history.raec.JobCategoryEnum.STREET;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import moon.adn.code.system.I18N;

/**
 * @author cdelr
 *
 */
public enum JobEnum implements I18N {
	// Standards jobs
	WORKER(STANDARD), SECRETARY(STANDARD), CLERK(STANDARD), ACCOUNTANT(STANDARD), CRAFTSMAN(STANDARD),
	ENGINEER(STANDARD), COMMERCIAL(STANDARD), MARKETING(STANDARD), SENIOR_MANAGER(STANDARD), FREELANCE(STANDARD),
	VENDOR(STANDARD), SHOPKEEPER(STANDARD), UBER(STANDARD), DOCTOR(STANDARD), NURSING_STAFF(STANDARD), PILOT(STANDARD),
	SOCIAL_WORKER(STANDARD), HOTEL_EMPLOYEE(STANDARD), STUDENT(STANDARD), TEACHER(STANDARD), PROFESSOR(STANDARD),
	SCIENTIST(STANDARD),

	// Street jobs
	ASSASSIN(STREET), BARTENDER(STREET), STREED_GUARD(STREET), BOUNCER(STREET), TAXI_DRIVER(STREET), CROOK(STREET),
	INMATE(STREET), FORGER(STREET), DRUG_PRODUCER(STREET), DEALER(STREET), EX_PRISONER(STREET), FIXER(STREET),
	GANG_MEMBER(STREET), WHORE(STREET), JUNKIE(STREET), MERCENARY(STREET), HACKER(STREET), CALL_GIRL(STREET),
	WATCHMAN(STREET), STREET_DOC(STREET), RONIN(STREET), SMUGGLER(STREET), STREET_VENDOR(STREET), STREET_TECHIE(STREET),
	THIEF(STREET), WANDERER(STREET),

	// Law jobs
	BOUNTY_HUNTER(LAW), COP(LAW), FIREMAN(LAW), LAWYER(LAW), PARAMEDIC(LAW), JAIL_GUARD(LAW), PRIVATE(LAW), VIGIL(LAW),
	CHIEF_COP(LAW), MILITIAMAN(LAW),

	// Illegal jobs
	HITMAN(ILLEGAL), GANG_BODYGUARD(ILLEGAL), BOOKMAKER(ILLEGAL), COUNTERFEITER(ILLEGAL), SMALL_TIME_THUG(ILLEGAL),
	HENCHMAN(ILLEGAL), GANG_NETRUNNER(ILLEGAL), PACK_LEADER(ILLEGAL), GANG_BOSS(ILLEGAL), GODFATHER(ILLEGAL),

	// Corpo jobs
	CORPO_MILITIA(CORPO), CORPO_SECURITY(CORPO), CORPO_HEALER(CORPO), CORPO_OFFICE_WORKER(CORPO),
	CORPO_TECHNICIAN(CORPO), CORPO_MANAGER(CORPO), CORPO_MID_MANAGER(CORPO), CORPO_SENIOR_MANAGER(CORPO),
	CORPO_EXECUTIVE_COMITEE(CORPO), CORPO_R_AND_D(CORPO), CORPO_AUDITOR(CORPO), CORPO_NETRUNNER(CORPO),

	// Entertainment jobs
	ACTOR(ENTERTAINMENT), ARTIST(ENTERTAINMENT), DIGITAL_ARTIST(ENTERTAINMENT), VIDEO_GAME_DEV(ENTERTAINMENT),
	ENTERTAINMENT_TECH(ENTERTAINMENT), ENTERTAINMENT_EMPLOYEE(ENTERTAINMENT), SOUND_ENGINEER(ENTERTAINMENT),
	SINGER(ENTERTAINMENT), DANCER(ENTERTAINMENT), MUSICIAN(ENTERTAINMENT), WRITER(ENTERTAINMENT),
	REALITY_TV_CELEBRITY(ENTERTAINMENT), INFLUENCER(ENTERTAINMENT), MEADIA_STREAMER(ENTERTAINMENT),
	JOURNALIST(ENTERTAINMENT), TV_REPORTER(ENTERTAINMENT), TV_PRESENTER(ENTERTAINMENT),
	TV_SPORTS_REPORTER(ENTERTAINMENT), ON_SITE_CORRESPONDANT(ENTERTAINMENT), MODEL(ENTERTAINMENT), STAR(ENTERTAINMENT),

	// Government jobs
	PUCHASING(GOVERNMENT), LEGAL_AFFAIRS(GOVERNMENT), URBAN_PLANNING(GOVERNMENT), REAL_ESTATES(GOVERNMENT),
	COMMUNICATION(GOVERNMENT), CULTURE(GOVERNMENT), TRAINING(GOVERNMENT), ENVIRONMENT(GOVERNMENT), SOCIAL(GOVERNMENT),
	FINANCE(GOVERNMENT), YOUTH_AND_SPORTS(GOVERNMENT), JUSTICE(GOVERNMENT), LOGISTIC(GOVERNMENT),
	ADMINISTRATIVE_SUPPORT(GOVERNMENT), HUMAN_RESSOURCES(GOVERNMENT), SECURITY(GOVERNMENT), TECHNOLOGIES(GOVERNMENT),
	TRANSPORTS(GOVERNMENT), NEIGHBORHOOD_REPRESENTATIVE(GOVERNMENT), BUSINESS_DISTRICT_REPRESENTATIVE(GOVERNMENT),
	GOVERNOR_CABINET_MEMBRE(GOVERNMENT),

	// Naohm Jobs
	NAOHM_STANDARDS(NAOHM), NAOHM_STREET(NAOHM), NAOHM_LAW(NAOHM), NAOHM_CORPO(NAOHM), NAOHM_ENTERTAINMENT(NAOHM),
	NAOHM_GOV(NAOHM), MYSTICAL(NAOHM), FOUNDER_EMPLOYEE(NAOHM);

	private @Getter JobCategoryEnum jobCategory;
	private static Random random = new Random();

	private static final String I18N_ROOT = "jobs.";

	private static final int[] standardJobsIntervals = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 74, 81,
			83, 89, 93, 95, 98, 100 };
	private static final int[] streetJobsIntervals = { 2, 7, 11, 15, 20, 23, 26, 28, 30, 36, 40, 44, 49, 53, 58, 62, 65,
			69, 72, 74, 78, 82, 88, 90, 94, 100 };
	private static final int[] lawJobsIntervals = { 5, 20, 36, 40, 55, 61, 75, 90, 95, 100 };
	private static final int[] illegalJobsIntervals = { 5, 20, 36, 40, 55, 61, 75, 90, 95, 100 };
	private static final int[] corpoJobsIntervals = { 10, 20, 30, 40, 50, 60, 70, 90, 100 };
	private static final int[] entertainmentJobsIntervals = { 4, 9, 14, 19, 24, 29, 34, 39, 44, 49, 54, 59, 64, 69, 74,
			79, 84, 89, 94, 99, 100 };
	private static final int[] govJobsIntervals = { 4, 9, 14, 19, 24, 29, 34, 39, 44, 49, 54, 59, 64, 69, 74, 79, 84,
			89, 94, 99, 100 };
	private static final int[] naohmJobsIntervals = { 10, 20, 30, 40, 50, 60, 70, 80 };

	private JobEnum(JobCategoryEnum jobCategory) {
		this.jobCategory = jobCategory;
	}

	public static JobEnum randomJob() {
		return values()[random.nextInt(values().length)];
	}

	public static JobEnum randomJob(JobCategoryEnum jobCategory) {
		List<JobEnum> list = listFromCategory(jobCategory);
		return list.get(random.nextInt(list.size() - 1));
	}

	public static JobEnum randomJobUsingRules() {
		JobCategoryEnum jobCategory = JobCategoryEnum.random();
		return randomJobUsingRules(jobCategory);
	}

	public static JobEnum randomJobUsingRules(JobCategoryEnum jobCategory) {
		List<JobEnum> list = listFromCategory(jobCategory);
		int position = positionFromJobCategory(jobCategory);
		return list.get(position);
	}

	private static int positionFromJobCategory(JobCategoryEnum jobCategory) {
		int position = 0;
		switch (jobCategory) {
		case STANDARD: {
			position = getPositionFromIntervals(standardJobsIntervals);
			break;
		}
		case STREET: {
			position = getPositionFromIntervals(streetJobsIntervals);
			break;
		}
		case LAW: {
			position = getPositionFromIntervals(lawJobsIntervals);
			break;
		}
		case ILLEGAL: {
			position = getPositionFromIntervals(illegalJobsIntervals);
			break;
		}
		case ENTERTAINMENT: {
			position = getPositionFromIntervals(entertainmentJobsIntervals);
			break;
		}
		case CORPO: {
			position = getPositionFromIntervals(corpoJobsIntervals);
			break;
		}
		case GOVERNMENT: {
			position = getPositionFromIntervals(govJobsIntervals);
			break;
		}
		case NAOHM: {
			position = getPositionFromIntervals(naohmJobsIntervals);
			break;
		}
		default:

		}
		return position;
	}

	private static List<JobEnum> listFromCategory(JobCategoryEnum jobCategory) {
		List<JobEnum> list = new ArrayList<>();
		for (JobEnum job : values()) {
			if (job.jobCategory == jobCategory) {
				list.add(job);
			}
		}
		return list;
	}

	@Override
	public String i18nKey() {
		return I18N_ROOT + name();
	}
}
