package moon.adn.code.character.generator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Template for all websites pages.
 * 
 * @author cdelr
 *
 */
@Controller
public abstract class AbstractWebSiteController {
	protected static final Logger logger = LoggerFactory.getLogger(AbstractWebSiteController.class);
	protected ModelMap templateModelMap = new ModelMap();

	protected static final String URL_HOME = "/";
	public static final String URL_CHARACTERS = "/characters";
	
	/**
	 * Default controller.
	 */
	protected AbstractWebSiteController() {

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
	public String error(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error-404";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "error-500";
			}
		}
		return "error";
	}

}
