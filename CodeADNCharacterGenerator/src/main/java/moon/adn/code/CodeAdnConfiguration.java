package moon.adn.code;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import jakarta.annotation.PostConstruct;
import moon.adn.code.model.character.identity.names.DarkElvesNamesGeneratorSingleton;
import moon.adn.code.model.character.identity.names.HumanNamesGeneratorSingleton;
import moon.adn.code.model.character.identity.names.SephonileandisNamesGeneratorSingleton;

@Configuration
public class CodeAdnConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(CodeAdnConfiguration.class);

	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	@Bean
	LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.FRENCH);
		return resolver;
	}

	@PostConstruct
	public void initApplicationSingletons() {
		LOG.info("Start loading nameGeneratorsSingleton.");
		HumanNamesGeneratorSingleton.getInstance();
		DarkElvesNamesGeneratorSingleton.getInstance();
		SephonileandisNamesGeneratorSingleton.getInstance();
		LOG.info("End loading nameGeneratorsSingleton.");
	}
}
