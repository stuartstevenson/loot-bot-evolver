package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlayerSelector {
	List<Player> surviveFittest(List<PlayerResult> playerResults, float percentageToKeep);
}
