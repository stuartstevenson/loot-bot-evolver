package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.Game;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:06
 */
@Component
public class LootBotEvolverImpl implements LootBotEvolver {
    public static final int NUM_PLAYER = 4;
    public static final int START_WINS_VALUE = 0;
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
		generation = playerFactory.generatePlayers(NUM_PLAYER, generationCount);
		int i = 0;
		while (i < generationCount) {
			Map<Player, Integer> playerMap = playGames();
			generation = playerEvolver.nextGeneration(generation, playerMap, i++);
		}
	}

	private Map<Player, Integer> playGames() {
		List<Game> games = generation
                                .stream()
                                .map(this::playGame)
                                .collect(Collectors.toList());

        for (Game game : games) {
			game.run();
		}

		return extractPlayerTotals(games);
	}

	private Map<Player, Integer> extractPlayerTotals(List<Game> games) {
		Map<Player, Integer> playerWins = new HashMap<Player, Integer>();
		for (Player player : generation) {
			playerWins.put(player, START_WINS_VALUE);
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
