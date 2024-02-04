package moon.adn.code.character.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import moon.adn.code.character.generator.CharacterParameters;
import moon.adn.code.character.generator.restcontroller.CharacterRestController;
import moon.adn.code.model.character.AbstractCharacter;
import moon.adn.code.model.character.identity.SpeciesEnum;
import moon.adn.code.view.model.CharacterFormVO;

@Controller
public class WebSiteCharacterController extends AbstractWebSiteController {
	public static final String MODEL_HOME = "home";

	@GetMapping(URL_HOME)
	public ModelAndView index(ModelMap model) {
		mergeWithTemplateModelMap(super.templateModelMap);
		ModelAndView target = new ModelAndView(MODEL_HOME);
		target.addObject("species", SpeciesEnum.values());
		return target;
	}

	@GetMapping("/characterForm")
	public void character() {

	}

	@PostMapping("/generate")
	public String createCharacter(@ModelAttribute CharacterFormVO characterFormVo) {
		logger.debug(characterFormVo.toString());

		CharacterRestController characterRestController = new CharacterRestController();
		
		CharacterParameters cp = new CharacterParameters();
		cp.setSpeciesSet(characterFormVo.getSpecies());
		
		AbstractCharacter character = characterRestController.createParametrizedCharacter(cp);
		//AbstractCharacter character = characterRestController.createCharacter();
		logger.debug(character.toString());
		
		// Code pour créer le personnage
		return "redirect:/characters/new";
	}

}
