package moon.adn.code.model.archetypes;

import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.skills.SkillEnum;
import moon.adn.code.model.character.specializations.SpecializationEnum;

/**
 * Contract for an {@link Archetype} that will be used as a template. It helps
 * to create {@link Character}.
 * 
 * @author Cédric DELRUE
 *
 */
public interface Archetype {
	/**
	 * Initialize randomly {@link CaracteristicEnum} in term of main, weak and
	 * standard {@link CaractValues}.
	 */
	void initCaracteristics();

	/**
	 * Initialize the {@link SkillEnum} that will be learned by the generated
	 * {@link Character}.
	 */
	void initSkillsToLearn();

	/**
	 * Initialize the list of {@link SpecializationEnum} that can be learned by the
	 * generated {@link Character}.
	 */
	void initspecializationsToLearn();

	/**
	 * @return the {@link AbstractArchetype} generated.
	 */
	AbstractArchetype getArchetype();
}
