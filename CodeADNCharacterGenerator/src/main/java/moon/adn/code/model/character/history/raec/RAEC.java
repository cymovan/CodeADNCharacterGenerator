package moon.adn.code.model.character.history.raec;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.history.details.enemy.EnemyDetails;
import moon.adn.code.model.character.history.details.romance.Romance;
import moon.adn.code.model.character.identity.SexEnum;
import moon.adn.code.model.character.identity.SpeciesEnum;

public class RAEC {
	private @Getter @Setter SexEnum sex;
	private @Getter @Setter String name;
	private @Getter @Setter int ageGap = 0;
	private @Getter @Setter SpeciesEnum species;
	private @Setter JobCategoryEnum jobCategory;
	private @Getter @Setter JobEnum job;
	private @Getter @Setter RAECEnum RAECType;
	private @Getter @Setter Boolean alive = true;
	private @Getter @Setter Romance romance;
	private @Getter @Setter EnemyDetails enemy;
}
