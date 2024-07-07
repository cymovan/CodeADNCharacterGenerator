package moon.adn.code.character.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import moon.adn.code.character.generator.CharacterParameters;
import moon.adn.code.character.generator.restcontroller.CharacterRestController;
import moon.adn.code.model.archetypes.ArchetypeEnum;
import moon.adn.code.model.character.AbstractCharacter;
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;
import moon.adn.code.view.model.CharacterFormVO;

@Controller
@SessionAttributes(WebSiteCharacterController.SESSION_CHARACTER_ATTRIBUTE)
public class WebSiteCharacterController extends AbstractWebSiteController {
	public static final String URL_CHARACTER_NEW = "/character/new";
	public static final String URL_GENERATE = "/generate";
	public static final String URL_CHARACTER_FORM = "/characterForm";
	public static final String MODEL_HOME = "home";
	public static final String MODEL_ATTRIBUTE_CHARACTER = "character";

	public static final String VIEW_OBJECT_ARCHETYPES_LIST = "archetypesList";
	public static final String VIEW_OBJECT_GENDERS_LIST = "gendersList";
	public static final String VIEW_OBJECT_SPECIES_LIST = "speciesList";

	public static final String SESSION_CHARACTER_ATTRIBUTE = "session_character";

	@GetMapping(URL_HOME)
	public ModelAndView index(ModelMap model) {
		mergeWithTemplateModelMap(super.templateModelMap);
		return commonModelAndViewForCharacter(model);
	}

	private ModelAndView commonModelAndViewForCharacter(ModelMap model) {
		ModelAndView target = new ModelAndView(MODEL_HOME, model);
		target.addObject(VIEW_OBJECT_SPECIES_LIST, SpeciesEnum.values());
		target.addObject(VIEW_OBJECT_GENDERS_LIST, SexEnum.values());
		target.addObject(VIEW_OBJECT_ARCHETYPES_LIST, ArchetypeEnum.values());
		target.addObject(APPLICATION_CARACTERISTICS_ENUMS, getCharacteristicsEnums());
		return target;
	}

	@GetMapping(URL_CHARACTER_FORM)
	public void character() {

	}

	@GetMapping(URL_CHARACTER_NEW)
	public ModelAndView newCharacter(@SessionAttribute(SESSION_CHARACTER_ATTRIBUTE) AbstractCharacter character,
			ModelMap model) {
		mergeWithTemplateModelMap(super.templateModelMap);
		ModelAndView target = commonModelAndViewForCharacter(model);
		target.addObject(SESSION_CHARACTER_ATTRIBUTE, character);
		return target;
	}

	@PostMapping(URL_GENERATE)
	public ModelAndView createCharacter(@ModelAttribute CharacterFormVO characterFormVo, ModelMap model) {
		logger.debug(characterFormVo.toString());

		CharacterRestController characterRestController = new CharacterRestController();

		CharacterParameters cp = new CharacterParameters();
		cp.setSpeciesSet(characterFormVo.getSpecies());
		cp.setArchetypesSet(characterFormVo.getArchetypes());

		cp.setSex(characterFormVo.getSex());
		AbstractCharacter character;
		character = characterRestController.createParametrizedCharacter(cp);
		logger.debug(character.toString());

		// Redirection
		model.addAttribute(SESSION_CHARACTER_ATTRIBUTE, character);
		ModelAndView modelView = new ModelAndView("redirect:" + URL_CHARACTER_NEW, model);
		return modelView;
	}
}
