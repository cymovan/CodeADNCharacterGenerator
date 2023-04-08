package moon.adn.code.character.generator.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import moon.adn.code.model.character.history.CharacterHistoryGenerator;
import moon.adn.code.model.character.skills.SkillEnum;

@RestController
public class SkillsRestControler {

	@GetMapping("/skills")
	public String listSkills() {
		StringBuilder sb = new StringBuilder();
		for (SkillEnum skillEnum : SkillEnum.values()) {
			sb.append(skillEnum.name() + "\n");
		}
		return sb.toString();
	}
	
	@GetMapping("/tests")
	public String tests() {
		CharacterHistoryGenerator chg = new CharacterHistoryGenerator();
		return chg.generate();
	}
}
