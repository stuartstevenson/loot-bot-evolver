package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * User: StuartS
 * Date: 01/04/12
 * Time: 12:14
 */
@Component
public class PlayerSelectorImpl implements PlayerSelector {
	@Autowired
	private FitnessFunction fitnessFunction;

    @Autowired
    private RandomProvider randomProvider;

	public List<Player> surviveFittest(Map<Player, Integer> playerMap, int percentageToKeep) {
		List<PlayerProbability> playerProbabilities = fitnessFunction.evaluatePlayersChances(playerMap);
		List<Player> survivingPlayers = new ArrayList<Player>();
		for (int i = 0; i < Math.round(playerMap.size()*(1/percentageToKeep)); i++){
			double value = randomProvider.random();
            survivingPlayers.addAll(playerProbabilities.stream()
                                                        .filter(playerProbability -> playerProbability.isInRange(value))
                                                        .map(playerProbability -> playerProbability.player)
                                                        .collect(Collectors.toList()));
		}
		return survivingPlayers;
	}

	class PlayerProbability {
		Player player;
		double lowerRange;
		double upperRange;

		boolean isInRange(double randomValue) {
			if (randomValue > lowerRange && randomValue <= upperRange ) return true;
			return false;
		}
	}
}
