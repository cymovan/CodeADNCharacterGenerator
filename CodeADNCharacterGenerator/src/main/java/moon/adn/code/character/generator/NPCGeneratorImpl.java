package moon.adn.code.character.generator;

import moon.adn.code.model.character.NPC;

public class NPCGeneratorImpl extends AbstractCharacterGenerator<NPC> {
	/**
	 * Build and consolidate Datas of the {@link NPC}.
	 */
	public NPC build() {
		NPC character = new NPC();
		commonBuild(character);
		populateFromSkillToLearn(character);
		spendSkillsPoints(0, 8);
		return character;
	}
}
