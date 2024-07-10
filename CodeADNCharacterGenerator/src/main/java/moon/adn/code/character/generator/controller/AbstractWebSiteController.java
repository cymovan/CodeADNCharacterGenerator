package moon.adn.code.character.generator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import moon.adn.code.model.character.caracteristics.CaracteristicEnum;

/**
 * Template for all websites pages.
 * 
 * @author Cédric DELRUE
 *
 */
@Controller
public abstract class AbstractWebSiteController {
	private static final String ERROR_CODE_VAR = "errorParam";
	private static final String ERROR_VIEW = "error";
	private static final String I18N_ERROR_ROOT = "error.";
	private static final String I18N_ERROR_OTHER = "other";

	protected final Logger logger = LoggerFactory.getLogger(AbstractWebSiteController.class);
	protected ModelMap templateModelMap = new ModelMap();

	protected static final String URL_HOME = "/";
	public static final String URL_CHARACTERS = "/characters";

	public static final String APPLICATION_CARACTERISTICS_ENUMS = "caracteristicsEnum";
	protected static final String REDIRECT = "redirect:";
	protected static final String MESSAGE = "message";

	@Getter
	private List<CaracteristicEnum> characteristicsEnums;

	/**
	 * Default controller.
	 */
	protected AbstractWebSiteController() {

	}

	@Autowired
	protected AbstractWebSiteController(List<CaracteristicEnum> characteristicsEnums) {
		this();
		this.characteristicsEnums = characteristicsEnums;
	}

	/**
	 * Add defaults parameters to the Model
	 * 
	 * @param modelMap
	 */
	protected void mergeWithTemplateModelMap(ModelMap modelMap) {
		modelMap.addAllAttributes(templateModelMap);
	}

	/**
	 * Error Page
	 */
	@GetMapping("/error")
	public ModelAndView error(HttpServletRequest request) {
		String errorI18n = "";
		ModelMap modelMap = new ModelMap();
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value() || statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				errorI18n = I18N_ERROR_ROOT + statusCode;
			} else {
				errorI18n = I18N_ERROR_ROOT + I18N_ERROR_OTHER;
			}
			logger.error(errorI18n);
		}
		modelMap.addAttribute(ERROR_CODE_VAR, errorI18n);
		return new ModelAndView(ERROR_VIEW, modelMap);
	}

}
