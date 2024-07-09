package moon.adn.code.character.generator.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import moon.adn.code.character.generator.CharacterParameters;
import moon.adn.code.character.generator.restcontroller.CharacterRestController;
import moon.adn.code.model.archetypes.ArchetypeEnum;
import moon.adn.code.model.character.AbstractCharacter;
import moon.adn.code.model.character.CharacterFileHelper;
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;
import moon.adn.code.view.model.CharacterFormVO;

@Controller
@SessionAttributes(WebSiteCharacterController.SESSION_CHARACTER_ATTRIBUTE)
public class WebSiteCharacterController extends AbstractWebSiteController {
	public static final String URL_CHARACTER_NEW = "/character/new";
	public static final String URL_CHARACTER_LOAD = "/character/load";
	public static final String URL_CHARACTER_SAVE = "/character/save";
	public static final String URL_GENERATE = "/character/generate";
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
		CharacterRestController characterRestController = new CharacterRestController();

		CharacterParameters cp = new CharacterParameters();
		cp.setSpeciesSet(characterFormVo.getSpecies());
		cp.setArchetypesSet(characterFormVo.getArchetypes());

		cp.setSex(characterFormVo.getSex());
		AbstractCharacter character = characterRestController.createParametrizedCharacter(cp);
		logger.debug(character.toString());

		// Redirection
		model.addAttribute(SESSION_CHARACTER_ATTRIBUTE, character);
		ModelAndView modelView = new ModelAndView("redirect:" + URL_CHARACTER_NEW, model);
		return modelView;
	}

	@GetMapping(URL_CHARACTER_SAVE)
	public void saveCharacter(@SessionAttribute(SESSION_CHARACTER_ATTRIBUTE) AbstractCharacter character,
			HttpServletResponse response) throws IOException {
		// Check if character exists in session
		if (character == null) {
			return;
		}

		// Convert character to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String characterJson = objectMapper.writeValueAsString(character);

		// Set the content type and headers for the response
		String filename = character.getIdentity().getSpecies() + "_" + character.getIdentity().getName();
		response.setContentType("application/json");
		response.setHeader("Content-Disposition", "attachment; filename=CodeADN_Character_" + filename + ".json");

		// Write JSON data to response
		response.getWriter().write(characterJson);
	}

	@PostMapping(URL_CHARACTER_LOAD)
	public String loadCharacter(HttpSession httpSession, @RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		String target = URL_HOME;
		// Check if the file is empty
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a JSON file to upload.");
			return "redirect:" + target;
		}

		try {
			// Convert the JSON file to an AbstractCharacter
			AbstractCharacter character = CharacterFileHelper.loadCharacterFromMultipartFile(file);

			// Store character in session
			httpSession.setAttribute(SESSION_CHARACTER_ATTRIBUTE, character);

			// Add success message
			redirectAttributes.addFlashAttribute("message",
					"JSON file uploaded successfully and character saved in session.");
		} catch (IOException e) {
			// Add error message for invalid JSON format
			redirectAttributes.addFlashAttribute("message", "Error: Invalid JSON format or unable to parse the file.");
		}
		return "redirect:" + URL_CHARACTER_NEW;
	}
}
