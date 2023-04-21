package moon.adn.code.model.character.history.details.enemy;

import static moon.adn.code.model.character.history.details.enemy.CulpritEnum.TIERS_FOOLS_ENNEMY;
import static moon.adn.code.model.character.history.details.enemy.CulpritEnum.TIERS_FOOLS_YOU;

import lombok.Data;

@Data
public class EnemyDetails {
	private CulpritEnum whoIsTheCulprit;
	private DoYouKnowHimEnum doYouknowHim;
	private String thirdPartyInvolved;
	private WhoIsOffensedEnum whoIsOffensed;
	private String whatHappened;
	private WhatWillYouDoEnum whatWillYouDo;

	public static EnemyDetails random() {
		EnemyDetails enemyDetails = new EnemyDetails();
		CulpritEnum culprit = CulpritEnum.random();
		enemyDetails.whoIsTheCulprit = culprit;
		enemyDetails.doYouknowHim = DoYouKnowHimEnum.random();
		enemyDetails.whatWillYouDo = WhatWillYouDoEnum.random();
		enemyDetails.whoIsOffensed = WhoIsOffensedEnum.random();
		enemyDetails.whatHappened = new WhatHappened().randomEvent();

		// ThirdPartyInvolved ?
		if (TIERS_FOOLS_ENNEMY == culprit || TIERS_FOOLS_YOU == culprit) {
			enemyDetails.thirdPartyInvolved = new ThirdParty().randomEvent();
		}

		return enemyDetails;
	}

}
