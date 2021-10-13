package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerResult;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerSelectorImpl implements PlayerSelector {
	@Autowired
	private FitnessFunction fitnessFunction;

    @Autowired
    private RandomProvider randomProvider;

	/**
	 *  evaluates the players based on their results
	 *  calculate how many players to keep from the current generation
	 *  players are given a probability range
	 *  given a random number lies between the probability range, then a player will be chosen for the next generation
	 *  TODO: this isnt working as expected!
	 */
	public List<Player> surviveFittest(List<PlayerResult> playerResults, float percentageToKeep) {
		List<PlayerProbability> playerProbabilities = fitnessFunction.evaluatePlayersChances(playerResults);
		List<Player> survivingPlayers = new ArrayList<Player>();
		int numberOfPlayersToKeep = Math.round(playerResults.size()*(percentageToKeep));
		for (int i = 0; i < numberOfPlayersToKeep; i++){
			double value = randomProvider.random();
            survivingPlayers.addAll(playerProbabilities.stream()
                                                        .filter(playerProbability -> playerProbability.isInRange(value))
                                                        .map(PlayerProbability::getPlayer)
                                                        .collect(Collectors.toList()));
		}
		return survivingPlayers;
	}
}
