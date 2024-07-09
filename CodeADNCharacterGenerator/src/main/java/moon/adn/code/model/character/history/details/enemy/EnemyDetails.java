package moon.adn.code.model.character.history.details.enemy;

import static moon.adn.code.model.character.history.details.enemy.CulpritEnum.TIERS_FOOLS_ENNEMY;
import static moon.adn.code.model.character.history.details.enemy.CulpritEnum.TIERS_FOOLS_YOU;

import lombok.Getter;
import moon.adn.code.model.character.history.event.HistoryEnemyEvent;

/**
 * {@link HistoryEnemyEvent} details class contains contextual informations on
 * how, why and more the generated Character obtained this enemy.
 * 
 * @author Cédric DELRUE
 *
 */
@Getter
public class EnemyDetails {
	private CulpritEnum whoIsTheCulprit;
	private DoYouKnowHimEnum doYouknowHim;
	private String thirdPartyInvolved;
	private WhoIsOffensedEnum whoIsOffensed;
	private String whatHappened;
	private WhatWillYouDoEnum whatWillYouDo;

	public static EnemyDetails random() {
		EnemyDetails enemyDetails = new EnemyDetails();
		CulpritEnum culprit = CulpritEnum.SecureRandom();
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
