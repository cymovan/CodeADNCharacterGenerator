package moon.adn.code.model.character.identity.apparence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import moon.adn.code.model.character.identity.SpeciesEnum;

public enum EyesColorEnum {
	// Standard colors
	LIGHT_BLUE, BLUE, GREEN, GRAY, BROWN, HAZELNUT,

	// Elfic
	LIGHT_BLUE_SILVER_HIGHLIGHTS, BLUE_SILVER_HIGHLIGHTS, GREEN_SILVER_HIGHLIGHTS, GRAY_SILVER_HIGHLIGHTS,
	BROWN_SILVER_HIGHLIGHTS, HAZELNUT_SILVER_HIGHLIGHTS,

	LIGHT_BLUE_GOLDEN_HIGHLIGHTS, BLUE_GOLDEN_HIGHLIGHTS, GREEN_GOLDEN_HIGHLIGHTS, GRAY_GOLDEN_HIGHLIGHTS,
	BROWN_GOLDEN_HIGHLIGHTS, HAZELNUT_GOLDEN_HIGHLIGHTS,

	// Grey Elf
	METALIC,

	// Golden Elf or Bârars
	GOLD, SILVER, PLATINUM, RUBY, EMERALD, OPAL, SAPPHIRE,

	// Pale Elf and Night Elf
	PALE_BLUE, PALE_GREEN, PALE_GRAY, PALE_BROWN, PALE_HAZELNUT, WHITE, PALE_PINK, PALE_PURPLE, PALE_GOLDEN,

	// Aquatic Elf
	BLACK,

	// Dark Elf
	RED, AMBER, PINK, LAVENDER,

	// Bârar
	GINGER, COPPER, MERCURY, BRONZE,

	// Dhâraks
	YELLOW;

	public static final String MESSAGE_PREFIX = "hair.";

	@Setter
	@Getter
	private boolean sparkled;

	public static Set<EyesColorEnum> humanEyesColors() {
		Set<EyesColorEnum> eyesColors = new HashSet<>();
		eyesColors.add(LIGHT_BLUE);
		eyesColors.add(BLUE);
		eyesColors.add(GREEN);
		eyesColors.add(GRAY);
		eyesColors.add(BROWN);
		eyesColors.add(HAZELNUT);
		return eyesColors;
	}

	public static Set<EyesColorEnum> elvesEyesColors() {
		Set<EyesColorEnum> eyesColors = new HashSet<>();
		eyesColors.add(LIGHT_BLUE_SILVER_HIGHLIGHTS);
		eyesColors.add(BLUE_SILVER_HIGHLIGHTS);
		eyesColors.add(GREEN_SILVER_HIGHLIGHTS);
		eyesColors.add(GRAY_SILVER_HIGHLIGHTS);
		eyesColors.add(BROWN_SILVER_HIGHLIGHTS);
		eyesColors.add(HAZELNUT_SILVER_HIGHLIGHTS);
		eyesColors.add(LIGHT_BLUE_GOLDEN_HIGHLIGHTS);
		eyesColors.add(BLUE_GOLDEN_HIGHLIGHTS);
		eyesColors.add(GREEN_GOLDEN_HIGHLIGHTS);
		eyesColors.add(GRAY_GOLDEN_HIGHLIGHTS);
		eyesColors.add(BROWN_GOLDEN_HIGHLIGHTS);
		eyesColors.add(HAZELNUT_GOLDEN_HIGHLIGHTS);
		return eyesColors;
	}

	public static Set<EyesColorEnum> grayElfEyesColors() {
		Set<EyesColorEnum> eyesColors = new HashSet<>();
		eyesColors.add(METALIC);
		return eyesColors;
	}

	public static Set<EyesColorEnum> paleElfEyesColors() {
		Set<EyesColorEnum> eyesColors = new HashSet<>();
		eyesColors.add(PALE_BLUE);
		eyesColors.add(PALE_GREEN);
		eyesColors.add(PALE_GRAY);
		eyesColors.add(PALE_BROWN);
		eyesColors.add(PALE_HAZELNUT);
		eyesColors.add(WHITE);
		eyesColors.add(PALE_PINK);
		eyesColors.add(PALE_PURPLE);
		eyesColors.add(PALE_GOLDEN);
		return eyesColors;
	}

	public static Set<EyesColorEnum> goldenElfEyesColors() {
		Set<EyesColorEnum> eyesColors = new HashSet<>();
		eyesColors.add(GOLD);
		eyesColors.add(SILVER);
		eyesColors.add(PLATINUM);
		eyesColors.add(RUBY);
		eyesColors.add(EMERALD);
		eyesColors.add(OPAL);
		eyesColors.add(SAPPHIRE);
		return eyesColors;
	}

	public static Set<EyesColorEnum> nightElfEyesColors() {
		Set<EyesColorEnum> eyesColors = paleElfEyesColors();
		eyesColors.add(SILVER);
		return eyesColors;
	}

	public static Set<EyesColorEnum> aquaticElfEyesColors() {
		Set<EyesColorEnum> eyesColors = new HashSet<>();
		eyesColors.add(BLACK);
		return eyesColors;
	}

	public static Set<EyesColorEnum> darkElfEyesColors() {
		Set<EyesColorEnum> eyesColors = new HashSet<>();
		eyesColors.add(RED);
		eyesColors.add(GREEN);
		eyesColors.add(BLACK);
		eyesColors.add(BROWN);
		eyesColors.add(AMBER);
		eyesColors.add(PINK);
		eyesColors.add(LAVENDER);
		eyesColors.add(GRAY);
		eyesColors.add(SILVER);
		return eyesColors;
	}
	
	public static Set<EyesColorEnum> ironBararEyesColors() {
		Set<EyesColorEnum> eyesColors = new HashSet<>();
		eyesColors.add(BLACK);
		eyesColors.add(BROWN);
		eyesColors.add(HAZELNUT);
		eyesColors.add(GRAY);
		eyesColors.add(GREEN);
		return eyesColors;
	}

	public static List<EyesColorEnum> getSpeciesEyeColorsList(SpeciesEnum species) {
		Set<EyesColorEnum> eyesColors;
		switch (species) {
		case HUMAN:
			eyesColors = humanEyesColors();
			break;
		case S_AQUA:
			eyesColors = aquaticElfEyesColors();
			break;
		case S_DARK:
			eyesColors = darkElfEyesColors();
			break;
		case S_GOLD:
			eyesColors = goldenElfEyesColors();
			break;
		case S_GREY:
			eyesColors = grayElfEyesColors();
			break;
		case S_NIGHT:
			eyesColors = nightElfEyesColors();
			break;
		case S_PALE:
			eyesColors = paleElfEyesColors();
			break;
		case S_SYLV,S_URB:
			eyesColors = elvesEyesColors();
			break;
		case B_IRON:
			eyesColors = ironBararEyesColors();
			break;
		default:
			eyesColors = humanEyesColors();
			break;
		}
		List<EyesColorEnum> list = new ArrayList<>();
		list.addAll(eyesColors);
		return list;
	}
}
