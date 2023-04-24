package moon.adn.code.model.character;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author cdelr
 *
 */
public class CharacterFileHelper {
	public static final String DEFAULT_JSON_FILE = "character.json";

	public static void saveCharacter(Character character) {
		String fileName = DEFAULT_JSON_FILE;
//		if(null != character.getIdentity().getName()) {
//			fileName = character.getIdentity().getName() + ".json";
//		}
//		System.out.println(fileName);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(fileName), character);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Character loadCharacter(String filename) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File(filename), Character.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
