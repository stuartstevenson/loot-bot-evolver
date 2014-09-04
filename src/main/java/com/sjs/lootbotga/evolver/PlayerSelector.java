package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * User: StuartS
 * Date: 01/04/12
 * Time: 11:38
 */
@Component
public interface PlayerSelector {
	List<Player> surviveFittest(List<PlayerResult> playerResults, int percentageToKeep);
}
