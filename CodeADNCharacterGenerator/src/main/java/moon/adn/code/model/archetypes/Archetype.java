package moon.adn.code.model.archetypes;

public interface Archetype {
	void initCaracteristics();

	void initSkillsToLearn();

	void initspecializationsToLearn();

	AbstractArchetype getArchetype();

}
