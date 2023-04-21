package moon.adn.code.model.character.identity.apparence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import moon.adn.code.model.character.identity.SpeciesEnum;

public enum HairColourEnum {
	// Classic
	BLACK, BROWN, AUBURN, REDHEAD, DARK_BLOND, BLOND, SILVER, WHITE,

	// Pale Elf
	LIGHT_GOLD, LIGHT_SILVER, LIGHT_BLUE,

	// Grey Elf
	TITANIUM,

	// Gold Elf
	DARK_RED,

	// Colors or elfic
	GREEN, BLUE, DEEP_BLUE, PURPLE, RED, GOLDEN, COPPER, PINK, LIGHT_PINK,

	// Bronze Barars
	BLACK_COPPER_HIGHLIGHTS, BLACK_SILVER_HIGHLIGHTS, BLACK_GOLDEN_HIGHLIGHTS,

	// Silver Bârars
	REDHEAD_SILVER_HIGHLIGHTS,

	// Gold Bârars
	REDHEAD_GOLDEN_HIGHLIGHTS,

	// Bald or Dhâraks
	NONE;

	public static final String MESSAGE_PREFIX = "hair.";

	public static Set<HairColourEnum> humanHairColors() {
		Set<HairColourEnum> hairColors = new HashSet<>();
		hairColors.add(BLACK);
		hairColors.add(BROWN);
		hairColors.add(AUBURN);
		hairColors.add(REDHEAD);
		hairColors.add(BROWN);
		hairColors.add(DARK_BLOND);
		hairColors.add(BLOND);
		hairColors.add(SILVER);
		hairColors.add(WHITE);
		return hairColors;
	}

	public static Set<HairColourEnum> sylvanElfHairColors() {
		Set<HairColourEnum> hairColors = new HashSet<>();
		hairColors.add(DARK_BLOND);
		hairColors.add(BLOND);
		hairColors.add(GREEN);
		hairColors.add(RED);
		hairColors.add(REDHEAD);
		return hairColors;
	}

	public static Set<HairColourEnum> urbanElfHairColors() {
		Set<HairColourEnum> hairColors = new HashSet<>();
		hairColors.add(BROWN);
		hairColors.add(BLUE);
		hairColors.add(LIGHT_BLUE);
		hairColors.add(BLOND);
		hairColors.add(PURPLE);
		return hairColors;
	}

	public static Set<HairColourEnum> paleElfHairColors() {
		Set<HairColourEnum> hairColors = new HashSet<>();
		hairColors.add(WHITE);
		hairColors.add(LIGHT_GOLD);
		hairColors.add(LIGHT_SILVER);
		hairColors.add(LIGHT_BLUE);
		return hairColors;
	}

	public static Set<HairColourEnum> greyElfHairColors() {
		Set<HairColourEnum> hairColors = new HashSet<>();
		hairColors.add(SILVER);
		hairColors.add(COPPER);
		hairColors.add(TITANIUM);
		hairColors.add(GOLDEN);
		return hairColors;
	}

	public static Set<HairColourEnum> goldElfHairColors() {
		Set<HairColourEnum> hairColors = new HashSet<>();
		hairColors.add(BLACK);
		hairColors.add(BROWN);
		hairColors.add(DARK_RED);
		hairColors.add(WHITE);
		return hairColors;
	}

	public static Set<HairColourEnum> nightElfHairColors() {
		Set<HairColourEnum> hairColors = new HashSet<>();
		hairColors.add(GREEN);
		hairColors.add(BLUE);
		hairColors.add(WHITE);
		hairColors.add(PURPLE);
		return hairColors;
	}

	public static Set<HairColourEnum> aquaticElfHairColors() {
		Set<HairColourEnum> hairColors = nightElfHairColors();
		hairColors.add(SILVER);
		hairColors.add(GOLDEN);
		return hairColors;
	}

	public static Set<HairColourEnum> darkElfHairColors() {
		Set<HairColourEnum> hairColors = new HashSet<>();
		hairColors.add(WHITE);
		hairColors.add(SILVER);
		hairColors.add(COPPER);
		return hairColors;
	}

	public static List<HairColourEnum> getSpeciesHairColorsList(SpeciesEnum species) {
		Set<HairColourEnum> hairColors;
		switch (species) {
		case HUMAN: {
			hairColors = humanHairColors();
			break;
		}
		case S_AQUA: {
			hairColors = aquaticElfHairColors();
			break;
		}
		case S_DARK: {
			hairColors = darkElfHairColors();
			break;
		}
		case S_GOLD: {
			hairColors = goldElfHairColors();
			break;
		}
		case S_GREY: {
			hairColors = greyElfHairColors();
			break;
		}
		case S_NIGHT: {
			hairColors = nightElfHairColors();
			break;
		}
		case S_PALE: {
			hairColors = paleElfHairColors();
			break;
		}
		case S_SYLV: {
			hairColors = sylvanElfHairColors();
			break;
		}
		case S_URB: {
			hairColors = urbanElfHairColors();
			break;
		}
		default:
			hairColors = humanHairColors();
			break;
		}
		List<HairColourEnum> list = new ArrayList<>();
		list.addAll(hairColors);
		return list;
	}
}
