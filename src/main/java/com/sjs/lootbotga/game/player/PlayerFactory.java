package com.sjs.lootbotga.game.player;

import java.util.List;

public interface PlayerFactory {
	List<Player> generatePlayers(int numPlayer, int generationCount);
}
