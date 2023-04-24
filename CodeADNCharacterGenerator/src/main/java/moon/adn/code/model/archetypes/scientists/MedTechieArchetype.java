package moon.adn.code.model.archetypes.scientists;

import static moon.adn.code.model.character.skills.SkillEnum.BIO;
import static moon.adn.code.model.character.skills.SkillEnum.BOTA;
import static moon.adn.code.model.character.skills.SkillEnum.CHAT;
import static moon.adn.code.model.character.skills.SkillEnum.CYBER_TECH;
import static moon.adn.code.model.character.skills.SkillEnum.FIRST_AIDS;
import static moon.adn.code.model.character.skills.SkillEnum.HIST;
import static moon.adn.code.model.character.skills.SkillEnum.HUMAN_PERCEPTION;
import static moon.adn.code.model.character.skills.SkillEnum.PHARMA;
import static moon.adn.code.model.character.skills.SkillEnum.TECH_GEN;
import static moon.adn.code.model.character.specializations.SpecializationEnum.ANTHROPOLOGY;
import static moon.adn.code.model.character.specializations.SpecializationEnum.EMOTIONS_CONCEALMENT;
import static moon.adn.code.model.character.specializations.SpecializationEnum.INVENTION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.MEDECINE_SPECIALIZATION;
import static moon.adn.code.model.character.specializations.SpecializationEnum.MEDICAL_TECHNICS;
import static moon.adn.code.model.character.specializations.SpecializationEnum.MEDICINAL_PLANTS;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PHYSIOLOGY_HUMAN;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PHYSIOLOGY_SEPHONILEANDIS;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PSYCHIATRY;
import static moon.adn.code.model.character.specializations.SpecializationEnum.PSYCHOLOGY;

public class MedTechieArchetype extends AbstractScientistsArchetype {

	public MedTechieArchetype() {
		this(1);
	}

	public MedTechieArchetype(int carrerLevel) {
		super(carrerLevel);
	}

	public void initSkillsToLearn() {
		super.initSkillsToLearn();
		skillsToLearn.add(BIO);
		skillsToLearn.add(BOTA);
		skillsToLearn.add(HIST);
		skillsToLearn.add(CYBER_TECH);
		skillsToLearn.add(PHARMA);
		skillsToLearn.add(FIRST_AIDS);
		skillsToLearn.add(TECH_GEN);
		skillsToLearn.add(HUMAN_PERCEPTION);
		skillsToLearn.add(CHAT);

	}

	@Override
	public void initspecializationsToLearn() {
		super.initspecializationsToLearn();
		// Carrer
		specializationsToLearn.add(MEDICAL_TECHNICS);
		specializationsToLearn.add(MEDECINE_SPECIALIZATION);
		specializationsToLearn.add(MEDICINAL_PLANTS);
		specializationsToLearn.add(ANTHROPOLOGY);
//		specializationsToLearn.add(PHYSIOLOGY_BARARS);
//		specializationsToLearn.add(PHYSIOLOGY_DHARAKS);
		specializationsToLearn.add(PHYSIOLOGY_HUMAN);
//		specializationsToLearn.add(PHYSIOLOGY_SELOPHRETALS);
//		specializationsToLearn.add(PHYSIOLOGY_SELOPHYLERS);
		specializationsToLearn.add(PHYSIOLOGY_SEPHONILEANDIS);
//		specializationsToLearn.add(PHYSIOLOGY_SEPHONILESILA);
		specializationsToLearn.add(PSYCHIATRY);
		specializationsToLearn.add(PSYCHOLOGY);
		specializationsToLearn.add(EMOTIONS_CONCEALMENT);
		specializationsToLearn.add(INVENTION);

	}
}
