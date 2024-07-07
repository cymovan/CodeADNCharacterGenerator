package moon.adn.code.character.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import moon.adn.code.model.archetypes.AbstractArchetype;
import moon.adn.code.model.archetypes.Archetype;
import moon.adn.code.model.archetypes.ArchetypeEnum;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.CharacterFileHelper;
import moon.adn.code.model.character.history.CharacterHistory;
import moon.adn.code.model.character.history.CharacterHistoryGenerator;
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * Builder of {@link Character}.
 * 
 * @author Cédric DELRUE
 *
 */
public class CharacterGeneratorImpl extends AbstractCharacterGenerator<Character> {
	private static final int MAX_HOBBY_SCORE = 5;

	/**
	 * Build and consolidate Datas of the character.
	 */
	public Character build() {
		Character character = new Character();
		defineCareerAndHobbiesPointsWithoutMystic(character);
		commonBuild(character);
		endProcedure(character);
		return character;
	}

	public Character buildFromArchetype(Archetype archetype) {
		Character character = new Character();
		AbstractArchetype template = archetype.getArchetype();
		defineCareerAndHobbiesPointsWithoutMystic(character, archetype);
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

	@Override
	public Character buildFromParameters(CharacterParameters params) {
		Set<SpeciesEnum> speciesSet = params.getSpeciesSet();
		if (speciesSet != null) {
			setSelectedSpeciesforRandom(speciesSet);
		}
		
		SexEnum sex = params.getSex();
		if (sex != null) {
			setSelectedSex(Optional.of(params.getSex()));
		}

		Set<ArchetypeEnum> archetypeSet = params.getArchetypesSet();
		ArchetypeEnum archetype = chooseArchetype(archetypeSet);

		if (archetype == null) {
			return build();
		}
		return buildFromArchetype(archetype.getArchetype());
	}

	private ArchetypeEnum chooseArchetype(Set<ArchetypeEnum> archetypeSet) {
		if (archetypeSet == null) {
			return null;
		}
		List<ArchetypeEnum> archetypeEnumList = new ArrayList<ArchetypeEnum>(archetypeSet);
		Collections.shuffle(archetypeEnumList);
		return archetypeEnumList.get(0);
	}
}
