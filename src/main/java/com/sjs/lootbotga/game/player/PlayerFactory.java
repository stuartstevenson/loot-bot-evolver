package com.sjs.lootbotga.game.player;

import java.util.List;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:08
 */
public interface PlayerFactory {
	List<Player> generatePlayers(int numPlayer, int generationCount);
}
