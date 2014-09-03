package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.player.Player;

import java.util.List;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:40
 */
public interface GameEngine {
	void playGame();
	void setup(List<Player> playerList);
}
