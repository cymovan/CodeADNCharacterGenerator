package moon.adn.code.model.character.identity;

import static moon.adn.code.model.character.history.HistoryHelper.getPositionFromIntervals;
import static moon.adn.code.model.character.identity.JobCategoryEnum.CORPO;
import static moon.adn.code.model.character.identity.JobCategoryEnum.ENTERTAINMENT;
import static moon.adn.code.model.character.identity.JobCategoryEnum.GOVERNMENT;
import static moon.adn.code.model.character.identity.JobCategoryEnum.ILLEGAL;
import static moon.adn.code.model.character.identity.JobCategoryEnum.LAW;
import static moon.adn.code.model.character.identity.JobCategoryEnum.NAOHM;
import static moon.adn.code.model.character.identity.JobCategoryEnum.STANDARD;
import static moon.adn.code.model.character.identity.JobCategoryEnum.STREET;
import static moon.adn.code.model.character.specializations.CarreerEnum.FIGHTER;
import static moon.adn.code.model.character.specializations.CarreerEnum.GENERAL;
import static moon.adn.code.model.character.specializations.CarreerEnum.SPY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import lombok.Getter;
import moon.adn.code.model.character.specializations.CarreerEnum;
import moon.adn.code.system.I18N;

/**
 * @author Cédric DELRUE
 *
 */
public enum JobEnum implements I18N {
	// Standards jobs
	WORKER(STANDARD), SECRETARY(STANDARD), CLERK(STANDARD), ACCOUNTANT(STANDARD), CRAFTSMAN(STANDARD),
	ENGINEER(STANDARD, CarreerEnum.SCIENTIST), COMMERCIAL(STANDARD), MARKETING(STANDARD, SPY), SENIOR_MANAGER(STANDARD),
	FREELANCE(STANDARD), VENDOR(STANDARD), SHOPKEEPER(STANDARD), UBER(STANDARD),
	DOCTOR(STANDARD, CarreerEnum.SCIENTIST), NURSING_STAFF(STANDARD, CarreerEnum.SCIENTIST), PILOT(STANDARD),
	SOCIAL_WORKER(STANDARD), HOTEL_EMPLOYEE(STANDARD), STUDENT(STANDARD, GENERAL),
	TEACHER(STANDARD, CarreerEnum.SCIENTIST), PROFESSOR(STANDARD, CarreerEnum.SCIENTIST),
	SCIENTIST(STANDARD, CarreerEnum.SCIENTIST),

	// Street jobs
	ASSASSIN(STREET, FIGHTER), BARTENDER(STREET), STREED_GUARD(STREET, FIGHTER), BOUNCER(STREET, FIGHTER),
	TAXI_DRIVER(STREET), CROOK(STREET), INMATE(STREET), FORGER(STREET, SPY),
	DRUG_PRODUCER(STREET, CarreerEnum.SCIENTIST), DEALER(STREET, SPY), EX_PRISONER(STREET), FIXER(STREET),
	GANG_MEMBER(STREET, FIGHTER), WHORE(STREET), JUNKIE(STREET), MERCENARY(STREET, FIGHTER), HACKER(STREET, SPY),
	CALL_GIRL(STREET), WATCHMAN(STREET), STREET_DOC(STREET), RONIN(STREET), SMUGGLER(STREET), STREET_VENDOR(STREET),
	STREET_TECHIE(STREET, CarreerEnum.SCIENTIST), THIEF(STREET, SPY), WANDERER(STREET),

	// Law jobs
	BOUNTY_HUNTER(LAW, SPY), COP(LAW, FIGHTER), FIREMAN(LAW), LAWYER(LAW), PARAMEDIC(LAW, CarreerEnum.SCIENTIST),
	JAIL_GUARD(LAW), PRIVATE(LAW, SPY), VIGIL(LAW, SPY), CHIEF_COP(LAW), MILITIAMAN(LAW, FIGHTER),

	// Illegal jobs
	HITMAN(ILLEGAL, FIGHTER), GANG_BODYGUARD(ILLEGAL, FIGHTER), BOOKMAKER(ILLEGAL), COUNTERFEITER(ILLEGAL),
	SMALL_TIME_THUG(ILLEGAL), HENCHMAN(ILLEGAL, FIGHTER), GANG_NETRUNNER(ILLEGAL, SPY), PACK_LEADER(ILLEGAL, FIGHTER),
	GANG_BOSS(ILLEGAL, FIGHTER), GODFATHER(ILLEGAL, FIGHTER),

	// Corpo jobs
	CORPO_MILITIA(CORPO, FIGHTER), CORPO_SECURITY(CORPO, FIGHTER), CORPO_HEALER(CORPO, CarreerEnum.SCIENTIST),
	CORPO_OFFICE_WORKER(CORPO), CORPO_TECHNICIAN(CORPO), CORPO_MANAGER(CORPO), CORPO_MID_MANAGER(CORPO),
	CORPO_SENIOR_MANAGER(CORPO), CORPO_EXECUTIVE_COMITEE(CORPO), CORPO_R_AND_D(CORPO, CarreerEnum.SCIENTIST),
	CORPO_AUDITOR(CORPO), CORPO_NETRUNNER(CORPO, SPY),

	// Entertainment jobs
	ACTOR(ENTERTAINMENT), ARTIST(ENTERTAINMENT), DIGITAL_ARTIST(ENTERTAINMENT), VIDEO_GAME_DEV(ENTERTAINMENT),
	ENTERTAINMENT_TECH(ENTERTAINMENT), ENTERTAINMENT_EMPLOYEE(ENTERTAINMENT), SOUND_ENGINEER(ENTERTAINMENT),
	SINGER(ENTERTAINMENT), DANCER(ENTERTAINMENT), MUSICIAN(ENTERTAINMENT), WRITER(ENTERTAINMENT),
	REALITY_TV_CELEBRITY(ENTERTAINMENT), INFLUENCER(ENTERTAINMENT), e(ENTERTAINMENT), JOURNALIST(ENTERTAINMENT),
	TV_REPORTER(ENTERTAINMENT), TV_PRESENTER(ENTERTAINMENT), TV_SPORTS_REPORTER(ENTERTAINMENT),
	ON_SITE_CORRESPONDANT(ENTERTAINMENT), MODEL(ENTERTAINMENT), STAR(ENTERTAINMENT),

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
	private @Getter CarreerEnum carreerEnum = CarreerEnum.GENERAL;
	private static Map<CarreerEnum, List<JobEnum>> mapOfJobFromCarrer = new HashMap<>();
	private static Map<JobCategoryEnum, List<JobEnum>> mapOfJobFromJobCategory = new HashMap<>();

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

	JobEnum(JobCategoryEnum jobCategory, CarreerEnum carreer) {
		this(jobCategory);
		this.carreerEnum = carreer;
	}

	// Optimization : Initialize the map of CarreerEnum / List<JobEnum>
	static {
		for (JobEnum job : JobEnum.values()) {
			CarreerEnum carrerEnum = job.getCarreerEnum();
			List<JobEnum> jobList = mapOfJobFromCarrer.get(carrerEnum);
			if (null == jobList) {
				jobList = new ArrayList<>();
			}
			jobList.add(job);
			mapOfJobFromCarrer.put(carrerEnum, jobList);
		}
	}

	// Optimization : Initialize the map of JobCategory / List<JobEnum>
	static {
		for (JobEnum job : JobEnum.values()) {
			JobCategoryEnum jobCategoryEnum = job.getJobCategory();
			List<JobEnum> jobList = mapOfJobFromJobCategory.get(jobCategoryEnum);
			if (null == jobList) {
				jobList = new ArrayList<>();
			}
			jobList.add(job);
			mapOfJobFromJobCategory.put(jobCategoryEnum, jobList);
		}
	}

	public static JobEnum randomJob() {
		return values()[random.nextInt(values().length)];
	}

	public static JobEnum randomJobUsingRules(CarreerEnum carreer) {
		List<JobEnum> jobsListFromCarrer = mapOfJobFromCarrer.get(carreer);
		// No Job for MYSTIC
		// TODO : Evolution when MYSTIC jobs defined.
		if (null == jobsListFromCarrer || jobsListFromCarrer.size() == 0) {
			return null;
		}
		Collections.shuffle(jobsListFromCarrer);
		return jobsListFromCarrer.get(random.nextInt(jobsListFromCarrer.size() - 1));
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
		return mapOfJobFromJobCategory.get(jobCategory);
	}

	@Override
	public String i18nKey() {
		return I18N_ROOT + name();
	}
}
