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

import moon.adn.code.character.generator.CharacterBuilder;
import moon.adn.code.character.generator.CharacterGenerator;
import moon.adn.code.character.generator.HistoryGenerator;
import moon.adn.code.character.generator.RAECGenerator;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.CharacterFileHelper;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.history.CharacterHistory;
import moon.adn.code.model.character.history.CharacterHistoryGenerator;
import moon.adn.code.model.character.history.raec.RAEC;
import moon.adn.code.model.character.history.raec.RAECProcedure;
import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * Controler for Charater API.
 * 
 * @author cdelr
 *
 */
@RestController
@RequestMapping(CharacterRestController.PATH_REST_CHARACTERS)
public class CharacterRestController implements CharacterGenerator, RAECGenerator, HistoryGenerator {

	static final String PATH_REST_CHARACTERS = "/restCharacters";
	private static final String CHARACTER_PATH = "/character";
	private static final String HEROIC_CHARACTER_PATH = "/heroicCharacter";
	private static final String ELF_CHARACTER_PATH = "/elfCharacter";
	private static final String WEAK_CHARACTER_PATH = "/weakCharacter";
	private static final String RESTORE_CHARACTER_PATH = "/restoreCharacter";

	@Autowired
	MessageSource messageSource;

	@Override
	@GetMapping(CHARACTER_PATH)
	public Character createCaracter() {
		return generate();
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

	@GetMapping("RAEC/species/{species}/age/{age}")
	public RAEC generateRAEC(@PathVariable SpeciesEnum species, @PathVariable(required = false) int age) {
		return new RAECProcedure(species, age).generate();
	}

	@GetMapping("RAEC")
	public RAEC generateRAEC() {
		return new RAECProcedure().generate();
	}

	@GetMapping("RAEC/sibling/species/{species}/age/{age}")
	public Map<Integer, RAEC> generateSibling(@PathVariable(required = true) SpeciesEnum species,
			@PathVariable(required = true) int age) {
		CharacterHistoryGenerator chg = new CharacterHistoryGenerator(species, age);
		chg.generateSiblings();
		return chg.getSiblingsMap();
	}

	private Character generate() {
		CharacterBuilder characterBuilder = new CharacterBuilder();
		characterBuilder.setCaracteristicsMap(randomCaracteristics());
		Character character = characterBuilder.build();
		return character;
	}

	private Character generateElfic() {
		CharacterBuilder characterBuilder = new CharacterBuilder();
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
		CharacterBuilder characterBuilder = new CharacterBuilder();
		characterBuilder.setCaracteristicsMap(randomHeroicCaracteristics());
		Character character = characterBuilder.build();
		return character;
	}

	private Character generateWeakCharacter() {
		CharacterBuilder characterBuilder = new CharacterBuilder();
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
