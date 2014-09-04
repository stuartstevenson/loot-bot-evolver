package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.GameState;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.MoveType;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PlayerMutatorImpl implements PlayerMutator {

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
            if (randomProvider.random() > 0.5) {
                gameStateMutator.mutateGameState(strategy.getKey());
            } else {
                moveMutator.mutateMove(strategy.getValue());
            }
        }
	}

}
