package moon.adn.code.character.generator.restcontroller;

import static moon.adn.code.system.RandomDiceUtil.d10;
import static moon.adn.code.system.RandomDiceUtil.d10Heroic;
import static moon.adn.code.system.RandomDiceUtil.d10Weak;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moon.adn.code.character.generator.AbstractCharacterGenerator;
import moon.adn.code.character.generator.CharacterGeneratorImpl;
import moon.adn.code.character.generator.MedTechNPCGeneratorImpl;
import moon.adn.code.character.generator.NPCGeneratorImpl;
import moon.adn.code.character.generator.PunchingBallGeneratorImpl;
import moon.adn.code.model.character.Character;
import moon.adn.code.model.character.NPC;
import moon.adn.code.model.character.PunchingBall;
import moon.adn.code.model.character.caracteristics.CaractValues;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;

/**
 * Controler for Character API.
 * 
 * @author Cédric DELRUE
 *
 */
@RestController
@RequestMapping(NPCRestController.PATH_REST_NPC)
public class NPCRestController implements NPCGeneratorController<NPC> {

	static final String PATH_REST_NPC = "/restNPC";
	private static final String NPC_PATH = "/NPC";
	private static final String MEDTECH_PATH = "/medTech";
	private static final String PUNCHINGBALL_PATH = "/punchingBall";

	MessageSource messageSource;

	public NPCRestController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@Override
	@GetMapping(NPC_PATH)
	public NPC createCaracter() {
		return generate(new NPCGeneratorImpl());
	}

	@Override
	@GetMapping(MEDTECH_PATH)
	public NPC createMedTech() {
		return generate(new MedTechNPCGeneratorImpl());
	}

	@Override
	@GetMapping(PUNCHINGBALL_PATH)
	public PunchingBall createPunchingBall() {
		return generatePunchingBall(new PunchingBallGeneratorImpl());
	}

	private NPC generate(AbstractCharacterGenerator<NPC> generator) {
		generator.setCaracteristicsMap(randomCaracteristics());
		NPC character = generator.build();
		return character;
	}

	private PunchingBall generatePunchingBall(PunchingBallGeneratorImpl generator) {
		generator.setCaracteristicsMap(randomWeakCaracteristics());
		PunchingBall character = generator.build();
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
		characterBuilder.setSelectedSpeciesforRandom(speciesSet);
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

}
