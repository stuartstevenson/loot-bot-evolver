package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerFactory;
import com.sjs.lootbotga.game.Game;
import com.sjs.lootbotga.utils.CollectionFilter;
import com.sjs.lootbotga.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:06
 */
@Component
public class LootBotEvolverImpl implements LootBotEvolver {
	@Autowired
	private PlayerFactory playerFactory;
	@Autowired
	private List<Player> generation;
	@Autowired
	private PlayerEvolver playerEvolver;
	private int generationCount = 1;
	private int generationSize;

	public void setGenerationSize(int generationSize) {
		this.generationSize = generationSize;
	}

	public void setGenerationCount(int generationCount) {
		this.generationCount = generationCount;
	}

	public void run() {
		generation = playerFactory.generatePlayers(4, generationCount);
		int i = 0;
		while (i < generationCount) {
			Map<Player, Integer> playerMap = playGames();
			generation = playerEvolver.nextGeneration(generation, playerMap, i++);
		}
	}

	private Map<Player, Integer> playGames() {
		List<Game> games = new ArrayList<Game>();
		for (Player player : generation) {
			games.add(playGame(player));
		}
		for (Game game : games) {
			game.run();
		}

		return extractPlayerTotals(games);
	}

	private Map<Player, Integer> extractPlayerTotals(List<Game> games) {
		Map<Player, Integer> playerWins = new HashMap<Player, Integer>();
		for (Player player : generation) {
			playerWins.put(player, 0);
		}
		for (Game game : games) {
			if (playerWins.containsKey(game.winner())){
				Integer wins = playerWins.get(game.winner());
				playerWins.put(game.winner(), wins++);
			}
		}
		return playerWins;
	}

	private Game playGame(Player player) {
		List<Player> players = new ArrayList<Player>();
		players.add(player);
		players.addAll(getOtherPlayers(player));
		return new Game(players);
	}

	private List<Player> getOtherPlayers(final Player player) {
        List<Player> otherPlayers = generation
                                        .stream()
                                        .filter(p -> !p.equals(player))
                                        .collect(Collectors.toList());
		Collections.shuffle(otherPlayers);
		return otherPlayers.subList(0,3);
	}
}
