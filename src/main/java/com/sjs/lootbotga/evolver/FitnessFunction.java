package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.PlayerResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FitnessFunction {
	List<PlayerProbability> evaluatePlayersChances(List<PlayerResult> playerResults);
}
