package moon.adn.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CodeAdnCharacterGeneratorApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CodeAdnCharacterGeneratorApplication.class, args);
	}
}