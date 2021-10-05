package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.player.GameState;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class PlayerMutatorImpl implements PlayerMutator {

    public static final double MUTATION_STRATEGY = 0.5;

    @Autowired
    private RandomProvider randomProvider;

    @Autowired
    private MoveMutator moveMutator;

    @Autowired
    private GameStateMutator gameStateMutator;

	public void mutatePlayer(Player player) {
		int numStrategies = player.getStrategy().size();
        if (numStrategies > 0) {
            int strategyToMutate = new Long(Math.round(randomProvider.random() * numStrategies)).intValue();
            Map.Entry<GameState, Move> strategy = new ArrayList<>(player.getStrategy().entrySet()).get((strategyToMutate > 0 ? strategyToMutate - 1 : 0));
            if (randomProvider.random() > MUTATION_STRATEGY) {
                gameStateMutator.mutateGameState(strategy.getKey());
            } else {
                moveMutator.mutateMove(strategy.getValue());
            }
        }
	}

}
