package moon.adn.code.character.generator;

import moon.adn.code.model.archetypes.AbstractArchetype;
import moon.adn.code.model.archetypes.Archetype;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.CharacterFileHelper;
import moon.adn.code.model.character.history.CharacterHistory;
import moon.adn.code.model.character.history.CharacterHistoryGenerator;

/**
 * Builder of {@link Character}.
 * 
 * @author cdelr
 *
 */
public class CharacterGeneratorImpl extends AbstractCharacterGenerator<Character> {
	private static final int MAX_HOBBY_SCORE = 5;

	/**
	 * Build and consolidate Datas of the character.
	 */
	public Character build() {
		Character character = new Character();
		defineCarrerAndHobbiesPointsWithoutMystic(character);
		commonBuild(character);
		endProcedure(character);
		return character;
	}

	public Character buildFromArchetype(Archetype archetype) {
		Character character = new Character();
		AbstractArchetype template = archetype.getArchetype();
		defineCarrerAndHobbiesPointsWithoutMystic(character, archetype);
		commonBuildWithTemplate(character, template);
		endProcedure(character);
		return character;
	}
	
	private void endProcedure(Character character) {
		spendSkillsPoints(0, 9);
		lifeEventsGenerator(character);
		spendHobbyPoints(character, hobbiesPoints, MAX_HOBBY_SCORE);
		CharacterFileHelper.saveCharacter(character);
	}

	private void lifeEventsGenerator(Character character) {
		chg = new CharacterHistoryGenerator(character);
		CharacterHistory ch = chg.generate();
		character.setEventsMap(ch.getEventsMap());
		character.setRaecMap(ch.getRaecMap());
	}
}
