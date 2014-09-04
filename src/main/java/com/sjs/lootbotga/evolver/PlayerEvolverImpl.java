package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerFactory;
import com.sjs.lootbotga.game.player.PlayerFactoryImpl;
import com.sjs.lootbotga.game.player.PlayerImpl;
import com.sjs.lootbotga.utils.CollectionFilter;
import com.sjs.lootbotga.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:31
 */
@Component
public class PlayerEvolverImpl implements PlayerEvolver {
	@Autowired
	private PlayerSelector playerSelector;
	@Autowired
	private PlayerMutator playerMutator;
	@Autowired
	private PlayerCrossover playerCrossover;

	public PlayerEvolverImpl() {
	}

	public PlayerEvolverImpl(PlayerSelector playerSelector, PlayerMutator playerMutator, PlayerCrossover playerCrossover) {
		this.playerSelector = playerSelector;
		this.playerMutator = playerMutator;
		this.playerCrossover = playerCrossover;
	}

	public List<Player> nextGeneration(List<Player> generation, Map<Player, Integer> playerMap, int generationCount) {
		List<Player> selectedPlayers = playerSelector.surviveFittest(playerMap, 20);
		return spawnNextGeneration(generation,selectedPlayers, generationCount);
	}

	private List<Player> spawnNextGeneration(List<Player> currentGeneration, List<Player> selectedPlayers, int generationCount) {
		List<Player> nextGeneration = new ArrayList<Player>();
		nextGeneration.addAll(selectedPlayers);
		for (int i = 0; i < currentGeneration.size() - selectedPlayers.size() ; i++) {
			nextGeneration.add(spawnNewPlayer(selectedPlayers, generationCount, i, currentGeneration.size() - selectedPlayers.size()));
		}
		return nextGeneration;
	}

	private Player spawnNewPlayer(List<Player> selectedPlayers, int generationCount, int playerCount, int numPlayers) {
		Player mother = getRandonMother(selectedPlayers);
		Player father = getRandomFather(selectedPlayers, mother);
		Player child = playerCrossover.breedPlayers(mother, father);
		playerMutator.mutatePlayer(child);
		PlayerFactoryImpl.generatePlayerId(generationCount,playerCount, child, numPlayers);
		return child;
	}

	private Player getRandomFather(List<Player> selectedPlayers, final Player mother) {
        List<Player> filteredPlayers = selectedPlayers
                                            .parallelStream()
                                            .filter(p -> p.equals(mother))
                                            .collect(Collectors.toList());
		Collections.shuffle(filteredPlayers);
		return filteredPlayers.stream().findFirst().get();
	}

	private Player getRandonMother(List<Player> selectedPlayers) {
		Collections.shuffle(selectedPlayers);
		return selectedPlayers.stream().findFirst().get();
	}
	
	
}
