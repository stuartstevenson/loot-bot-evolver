package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:32
 */
public interface PlayerCrossover {
	Player breedPlayers(Player mother, Player father);
}
