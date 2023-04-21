package moon.adn.code.model.character.history.raec;

import moon.adn.code.model.character.history.details.Romance;
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * @author cdelr
 *
 */
public class RAECProcedure {
	private RAEC people = new RAEC();
	private SpeciesEnum species;
	private int age;

	private static final int NO_AGE = 0;
	private static final int DEFAULT_AGE = 20;

	private AgeCategoriesEnum ageCategory;

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
		generateCommon();
		people.setSpecies(SpeciesEnum.random());
		generateAgeDiff();
		generateJob();
		people.setRAECType(raecEnum);
		if (RAECEnum.ROMANCE == raecEnum) {
			people.setRomance(Romance.randomRomance());
		}
		return this.people;
	}

	public RAEC generateSibling() {
		generateCommon();
		people.setSpecies(species);
		generateAgeDiff();
		generateJob();
		generateSiblingType();
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

	private void generateCommon() {
		people.setSex(SexEnum.random());
		ageCategory = AgeCategoriesEnum.random();
	}

	private void generateJob() {
		JobCategoryEnum jobCategory = JobCategoryEnum.random();
		people.setJobCategory(jobCategory);
		people.setJob(JobEnum.randomJobUsingRules(jobCategory));
	}
}
