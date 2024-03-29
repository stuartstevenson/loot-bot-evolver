package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.Game;
import com.sjs.lootbotga.game.GameEngineImpl;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerFactory;
import com.sjs.lootbotga.game.player.PlayerResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LootBotEvolverImpl implements LootBotEvolver {

	private final Logger logger = LoggerFactory.getLogger(LootBotEvolverImpl.class);

    public static final int NUM_PLAYER = 4;
    public static final int START_WINS_VALUE = 0;
    @Autowired
	private PlayerFactory playerFactory;
	@Autowired
	private List<Player> generation;
	@Autowired
	private PlayerEvolver playerEvolver;
	@Value("${loot.generation.count}")
	public int generationCount;
	@Value("${loot.generation.size}")
	public int generationSize;

	public void run() {
		generation = playerFactory.generatePlayers(NUM_PLAYER, generationCount);
		int i = 0;
		while (i < generationCount) {
			logger.info(String.format("Starting generation %s", i));
			logger.info(String.format("Current generation size: %s", generation.size()));
            List<PlayerResult> playerResults = playGames();
			generation = playerEvolver.nextGeneration(generation, playerResults, i++);
		}
	}

	private List<PlayerResult> playGames() {
		List<Game> games = generation
                                .stream()
                                .map(this::playGame)
                                .collect(Collectors.toList());

        for (Game game : games) {
			game.run();
		}

		return extractPlayerResults(games);
	}

	private List<PlayerResult> extractPlayerResults(List<Game> games) {
        List<PlayerResult> playerResults = generation
                                                    .stream()
                                                    .map(player -> new PlayerResult(player, START_WINS_VALUE))
                                                    .collect(Collectors.toList());

        for (Game game : games) {
            findPlayerIn(playerResults, game.winner()).incrementWin();
		}

		return playerResults;
	}

    private PlayerResult findPlayerIn(List<PlayerResult> playerResults, Player winner) {
        return playerResults
                .stream()
                .filter(p -> p.getPlayer().equals(winner))
                .findFirst()
                .get();
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
