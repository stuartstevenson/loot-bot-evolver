package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;

public interface PlayerCrossover {
	Player breedPlayers(Player mother, Player father);
}
