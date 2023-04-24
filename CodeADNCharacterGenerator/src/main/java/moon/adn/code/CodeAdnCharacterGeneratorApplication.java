package moon.adn.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CodeAdnCharacterGeneratorApplication implements WebMvcConfigurer {

	private static final Logger LOG = LoggerFactory.getLogger(CodeAdnCharacterGeneratorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CodeAdnCharacterGeneratorApplication.class, args);
		LOG.trace("This is a TRACE log");
		LOG.debug("This is a DEBUG log");
		LOG.info("This is an INFO log");
		LOG.error("This is an ERROR log");
	}
}