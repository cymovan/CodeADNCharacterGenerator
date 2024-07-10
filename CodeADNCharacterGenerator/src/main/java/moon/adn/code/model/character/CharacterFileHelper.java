package moon.adn.code.model.character;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Cédric DELRUE
 *
 */
public class CharacterFileHelper {
	public static final String DEFAULT_JSON_FILE = "character.json";

	private static final Logger logger = LoggerFactory.getLogger(CharacterFileHelper.class);

	private CharacterFileHelper() {
		throw new IllegalStateException("Utility class");
	}

	public static void saveCharacter(Character character) {
		String fileName = DEFAULT_JSON_FILE;
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(fileName), character);
		} catch (IOException e) {
			logger.error("Error while saving file {} on disk. Unable to write maybe.", fileName);
		}
	}

	public static Character loadCharacter(String fileName) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File(fileName), Character.class);
		} catch (IOException e) {
			logger.error("Error while loading file {} on disk.", fileName);
		}
		return null;
	}

	public static Character loadCharacterFromMultipartFile(MultipartFile file) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(file.getBytes(), Character.class);
	}
}
