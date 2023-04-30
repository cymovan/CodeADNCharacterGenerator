package moon.adn.code;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import jakarta.annotation.PostConstruct;
import moon.adn.code.model.character.identity.DarkElvesNamesGeneratorSingleton;
import moon.adn.code.model.character.identity.HumanNamesGeneratorSingleton;
import moon.adn.code.model.character.identity.SephonileandisNamesGeneratorSingleton;

@Configuration
public class CodeAdnConfiguration {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.FRENCH);
		return resolver;
	}

	@PostConstruct
	public void initApplicationSingletons() {
		HumanNamesGeneratorSingleton.getInstance();
		DarkElvesNamesGeneratorSingleton.getInstance();
		SephonileandisNamesGeneratorSingleton.getInstance();
	}
}
