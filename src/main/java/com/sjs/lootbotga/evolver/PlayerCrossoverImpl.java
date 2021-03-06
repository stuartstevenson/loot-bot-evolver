package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.GameState;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:37
 */
@Component
public class PlayerCrossoverImpl implements PlayerCrossover {

	public Player breedPlayers(Player mother, Player father) {
		Player child = new PlayerImpl();
		child.setStrategy(generateNewStrategy(mother.getStrategy(), father.getStrategy()));
		return child;
	}

	private Map<GameState, Move> generateNewStrategy(Map<GameState, Move> motherStrategy, Map<GameState, Move> fatherStrategy) {
		int shortestListSize = motherStrategy.size() <= fatherStrategy.size() ? motherStrategy.size() : fatherStrategy.size();
		long crossoverPoint = Math.round(Math.random()*(shortestListSize-1));
		Map<GameState, Move> newStrategy = new HashMap<GameState, Move>();
		int i = 0;
		for (Map.Entry<GameState, Move> gameStateMoveEntry : motherStrategy.entrySet()) {
			if (i == crossoverPoint) {
				break;
			}
			else {
				newStrategy.put(gameStateMoveEntry.getKey(), gameStateMoveEntry.getValue());
				i++;
			}
		}
		for (Map.Entry<GameState, Move> gameStateMoveEntry : fatherStrategy.entrySet()) {
			if (i == fatherStrategy.size()) {
				break;
			}
			else {
				newStrategy.put(gameStateMoveEntry.getKey(), gameStateMoveEntry.getValue());
				i++;
			}
		}
		return newStrategy;
	}
}
