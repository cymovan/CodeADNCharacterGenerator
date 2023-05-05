package moon.adn.code.model.archetypes;

import static moon.adn.code.model.character.skills.SkillEnum.SEE;
import static moon.adn.code.system.RandomDiceUtil.d10;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import lombok.Data;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.identity.JobEnum;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.specializations.CarreerEnum;
import moon.adn.code.model.character.specializations.SpecializationEnum;

/**
 * Design Pattern Template for all {@link Archetype}.
 * 
 * @author Cédric DELRUE
 *
 */
@Data
public abstract class AbstractArchetype implements Archetype {
	protected Random random = new Random();
	protected int carrerLevel = 1;
	protected CarreerEnum mainCarreer;
	protected JobEnum job;

	protected Map<CarreerEnum, Integer> carreersMap = new TreeMap<>();
	protected Map<CaracteristicEnum, CaractValues> caracteristicsMap = new TreeMap<>();
	protected Set<SkillEnum> skillsToLearn = new HashSet<>();
	protected Set<SpecializationEnum> specializationsToLearn = new HashSet<>();

	private AbstractArchetype(CarreerEnum mainCarreer) {
		this.mainCarreer = mainCarreer;
	}

	protected AbstractArchetype(CarreerEnum mainCarreer, int carrerLevel) {
		this(mainCarreer);
		this.carrerLevel = carrerLevel;
	}

	protected int randomMainCaracteristics() {
		return random.nextInt(5, 10);
	}

	protected int randomMediumCaracteristics() {
		return random.nextInt(4, 7);
	}

	protected int randomLowCaracteristics() {
		return random.nextInt(2, 4);
	}

	protected int randomCaracteristics() {
		return d10();
	}

	public abstract void initCaracteristics();

	@Override
	public void initSkillsToLearn() {
		// Usefull for all archetypes
		skillsToLearn.add(SEE);
	}

	@Override
	public void initspecializationsToLearn() {

	}

	public AbstractArchetype getArchetype() {
		initRandomValues();
		return this;
	}

	protected void initRandomValues() {
		job = JobEnum.randomJobUsingRules(mainCarreer);
		initCaracteristics();
	}
}
