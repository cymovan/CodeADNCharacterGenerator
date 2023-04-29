package moon.adn.code.model.character.history.raec;

import moon.adn.code.model.character.history.details.enemy.EnemyDetails;
import moon.adn.code.model.character.history.details.romance.Romance;
import moon.adn.code.model.character.identity.JobCategoryEnum;
import moon.adn.code.model.character.identity.JobEnum;
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * @author Cédric DELRUE
 *
 */
public class RAECProcedure {
	private RAEC people = new RAEC();
	private SpeciesEnum species;
	private int age;

	private static final int NO_AGE = 0;
	private static final int DEFAULT_AGE = 20;

	private RAECAgeCategoriesEnum ageCategory;

	public RAECProcedure() {
		this(null, NO_AGE);
	}

	/**
	 * Constructor
	 * 
	 * @param species
	 * @param age
	 */
	public RAECProcedure(SpeciesEnum species, int age) {
		if (null == species) {
			this.species = SpeciesEnum.HUMAN;
		} else {
			this.species = species;
		}
		if (NO_AGE == age) {
			this.age = DEFAULT_AGE;
		} else {
			this.age = age;
		}
	}

	public RAEC generate() {
		return generate(RAECEnum.random());
	}

	public RAEC generate(RAECEnum raecEnum) {
		generateCommon(SpeciesEnum.random());
		generateAgeDiff();
		generateJob();
		people.setRAECType(raecEnum);
		if (RAECEnum.ROMANCE == raecEnum) {
			people.setRomance(Romance.randomRomance());
		} else if (RAECEnum.ENEMY == raecEnum) {
			people.setEnemy(EnemyDetails.random());
		}
		people.setName(people.getSpecies().getNamesGenerator().generateCompleteName(people.getSex()));
		return this.people;
	}

	public RAEC generateSibling() {
		generateCommon(species);
		generateAgeDiff();
		generateJob();
		generateSiblingType();
		people.setName(species.getNamesGenerator().generateFirstName(people.getSex()));
		return this.people;
	}

	private void generateSiblingType() {
		if (people.getSex() == SexEnum.M) {
			people.setRAECType(RAECEnum.BROTHER);
		} else {
			people.setRAECType(RAECEnum.SISTER);
		}

	}

	private void generateAgeDiff() {
		people.setAgeGap(ageCategory.ageDiffSibling(species, age));
	}

	private void generateCommon(SpeciesEnum species) {
		people.setSex(SexEnum.random());
		ageCategory = RAECAgeCategoriesEnum.random();
		people.setSpecies(species);
	}

	private void generateJob() {
		JobCategoryEnum jobCategory = JobCategoryEnum.random();
		people.setJobCategory(jobCategory);
		people.setJob(JobEnum.randomJobUsingRules(jobCategory));
	}
}
