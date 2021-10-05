package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.player.Player;

import java.util.List;

public interface GameEngine {
	void playGame();
	void setup(List<Player> playerList);
}
