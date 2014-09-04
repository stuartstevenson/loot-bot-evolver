package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.player.GameState;
import org.springframework.stereotype.Component;

@Component
public class EmptyDeckMutatorImpl implements EmptyDeckMutator {
    @Override
    public void mutateDeckEmpty(GameState gameState) {
        gameState.setDeckEmpty(!gameState.isDeckEmpty());
    }
}
