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

	/**
	 * Build and consolidate Datas of the character.
	 */
	public Character build() {
		Character character = new Character();
		commonBuild(character);
		
		// Events
		chg = new CharacterHistoryGenerator(character);
		CharacterHistory ch = chg.generate();
		character.setEventsMap(ch.getEventsMap());
		character.setRaecMap(ch.getRaecMap());

		CharacterFileHelper.saveCharacter(character);
		return character;
	}
}
