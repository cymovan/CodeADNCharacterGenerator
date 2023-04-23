package moon.adn.code.character.generator;

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
	private int hobbiesPoints = 30;
	
	/**
	 * Build and consolidate Datas of the character.
	 */
	public Character build() {
		Character character = new Character();
		commonBuild(character);
		spendSkillsPoints(0, 9);

		// Events
		chg = new CharacterHistoryGenerator(character);
		CharacterHistory ch = chg.generate();
		character.setEventsMap(ch.getEventsMap());
		character.setRaecMap(ch.getRaecMap());

		spendHobbyPoints(character, hobbiesPoints, 5);

		CharacterFileHelper.saveCharacter(character);
		return character;
	}
	
	protected void defineCarrerAndHobbiesPoints() {
		
	}

}
