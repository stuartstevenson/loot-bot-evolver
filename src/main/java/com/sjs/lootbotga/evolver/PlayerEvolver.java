package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:09
 */
@Component
public interface PlayerEvolver {
	List<Player> nextGeneration(List<Player> generation,  List<PlayerResult> playerResults, int generationCount);
}
