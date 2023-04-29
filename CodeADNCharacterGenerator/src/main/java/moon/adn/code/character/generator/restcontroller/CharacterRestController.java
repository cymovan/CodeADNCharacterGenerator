package moon.adn.code.character.generator.restcontroller;

import static moon.adn.code.system.RandomDiceUtil.d10;
import static moon.adn.code.system.RandomDiceUtil.d10Heroic;
import static moon.adn.code.system.RandomDiceUtil.d10Weak;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moon.adn.code.character.generator.AbstractCharacterGenerator;
import moon.adn.code.character.generator.CharacterGeneratorImpl;
import moon.adn.code.character.generator.HistoryGenerator;
import moon.adn.code.character.generator.RAECGenerator;
import moon.adn.code.model.archetypes.ArchetypeEnum;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.CharacterFileHelper;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.history.CharacterHistory;
import moon.adn.code.model.character.history.CharacterHistoryGenerator;
import moon.adn.code.model.character.history.raec.RAEC;
import moon.adn.code.model.character.history.raec.RAECProcedure;
import moon.adn.code.model.character.identity.SpeciesEnum;
import moon.adn.code.model.character.specializations.CarreerEnum;

/**
 * Controler for Character API.
 * 
 * @author Cédric DELRUE
 *
 */
@RestController
@RequestMapping(CharacterRestController.PATH_REST_CHARACTERS)
public class CharacterRestController
		implements CharacterGeneratorController<Character>, RAECGenerator, HistoryGenerator {

	static final String PATH_REST_CHARACTERS = "/restCharacters";
	private static final String RAEC_CHARACTER_PATH = "/RAEC";
	private static final String HEROIC_CHARACTER_PATH = "/heroicCharacter";
	private static final String ELF_CHARACTER_PATH = "/elfCharacter";
	private static final String WEAK_CHARACTER_PATH = "/weakCharacter";
	private static final String RESTORE_CHARACTER_PATH = "/restoreCharacter";

	private static final String ARCHETYPE_CHARACTER_PATH = "/archetype";

	private static final String CARREER_PARAMETERS_PATH = "/carreer/{carreer}";
	private static final String SPECIES_PARAMETERS_PATH = "/species/{species}";

	@Autowired
	MessageSource messageSource;

	@Override
	public Character createCaracter() {
		return generate();
	}

	@Override
	@GetMapping(ARCHETYPE_CHARACTER_PATH + CARREER_PARAMETERS_PATH)
	public Character createFromArchetype(@PathVariable(name="carreer", required = false) CarreerEnum carreer) {
		return generateFromArchetype(carreer);
	}

	@Override
	@GetMapping(RESTORE_CHARACTER_PATH)
	public Character restoreCaracter() {
		Character character = CharacterFileHelper.loadCharacter(CharacterFileHelper.DEFAULT_JSON_FILE);
		return character;
	}

	@Override
	@GetMapping(ELF_CHARACTER_PATH)
	public Character createElfCaracter() {
		return generateElfic();
	}

	@Override
	@GetMapping(HEROIC_CHARACTER_PATH)
	public Character createHeroicCaracter() {
		return generateHeroic();
	}

	@Override
	@GetMapping(WEAK_CHARACTER_PATH)
	public Character createWeakCaracter() {
		return generateWeakCharacter();
	}

	@GetMapping(RAEC_CHARACTER_PATH)
	public RAEC generateRAEC() {
		return new RAECProcedure().generate();
	}

	@GetMapping(RAEC_CHARACTER_PATH + SPECIES_PARAMETERS_PATH + "/age/{age}")
	public RAEC generateRAEC(@PathVariable SpeciesEnum species, @PathVariable(required = false) int age) {
		return new RAECProcedure(species, age).generate();
	}

	@GetMapping(RAEC_CHARACTER_PATH + "/sibling" + SPECIES_PARAMETERS_PATH + "/age/{age}")
	public Map<Integer, RAEC> generateSibling(@PathVariable(required = true) SpeciesEnum species,
			@PathVariable(required = true) int age) {
		CharacterHistoryGenerator chg = new CharacterHistoryGenerator(species, age);
		chg.generateSiblings();
		return chg.getRaecMap();
	}

	private Character generate() {
		AbstractCharacterGenerator<Character> characterBuilder = new CharacterGeneratorImpl();
		characterBuilder.setCaracteristicsMap(randomCaracteristics());
		Character character = characterBuilder.build();
		return character;
	}

	private Character generateElfic() {
		AbstractCharacterGenerator<Character> characterBuilder = new CharacterGeneratorImpl();
		Set<SpeciesEnum> speciesSet = new HashSet<>();
		speciesSet.add(SpeciesEnum.S_AQUA);
		speciesSet.add(SpeciesEnum.S_DARK);
		speciesSet.add(SpeciesEnum.S_SYLV);
		speciesSet.add(SpeciesEnum.S_GREY);
		speciesSet.add(SpeciesEnum.S_NIGHT);
		speciesSet.add(SpeciesEnum.S_PALE);
		speciesSet.add(SpeciesEnum.S_URB);
		characterBuilder.setSelectedSpeciesforRandom(Optional.of(speciesSet));
		characterBuilder.setCaracteristicsMap(randomHeroicCaracteristics());
		Character character = characterBuilder.build();
		return character;
	}

	private Character generateHeroic() {
		AbstractCharacterGenerator<Character> characterBuilder = new CharacterGeneratorImpl();
		characterBuilder.setCaracteristicsMap(randomHeroicCaracteristics());
		Character character = characterBuilder.build();
		return character;
	}

	private Character generateFromArchetype(CarreerEnum carreer) {
		AbstractCharacterGenerator<Character> characterBuilder = new CharacterGeneratorImpl();
		if (null == carreer) {
			carreer = CarreerEnum.random();
		}
		Character character = characterBuilder
				.buildFromArchetype(ArchetypeEnum.randomFromCarreer(carreer).getArchetype());
		return character;
	}

	private Character generateWeakCharacter() {
		AbstractCharacterGenerator<Character> characterBuilder = new CharacterGeneratorImpl();
		characterBuilder.setCaracteristicsMap(randomWeakCaracteristics());
		Character character = characterBuilder.build();
		return character;
	}

	private Map<CaracteristicEnum, CaractValues> randomCaracteristics() {
		Map<CaracteristicEnum, CaractValues> mapCaracteristics = new TreeMap<>();
		for (CaracteristicEnum caract : CaracteristicEnum.values()) {
			mapCaracteristics.put(caract, new CaractValues(d10()));
		}
		return mapCaracteristics;
	}

	private Map<CaracteristicEnum, CaractValues> randomHeroicCaracteristics() {
		Map<CaracteristicEnum, CaractValues> mapCaracteristics = new TreeMap<>();
		for (CaracteristicEnum caract : CaracteristicEnum.values()) {
			mapCaracteristics.put(caract, new CaractValues(d10Heroic()));
		}
		return mapCaracteristics;
	}

	private Map<CaracteristicEnum, CaractValues> randomWeakCaracteristics() {
		Map<CaracteristicEnum, CaractValues> mapCaracteristics = new TreeMap<>();
		for (CaracteristicEnum caract : CaracteristicEnum.values()) {
			mapCaracteristics.put(caract, new CaractValues(d10Weak()));
		}
		return mapCaracteristics;
	}

	@Override
	@GetMapping("characterHistory/{species}")
	public CharacterHistory generate(@PathVariable SpeciesEnum species, @PathVariable(required = true) int age) {
		CharacterHistoryGenerator chg = new CharacterHistoryGenerator(species, age);
		return chg.generate();
	}
}
