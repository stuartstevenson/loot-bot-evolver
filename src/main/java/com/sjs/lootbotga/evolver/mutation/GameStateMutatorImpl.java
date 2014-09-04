package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.GameState;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameStateMutatorImpl implements GameStateMutator {

    @Autowired
    private RandomProvider randomProvider;

    @Autowired
    private BoardMutator boardMutator;

    @Autowired
    private EmptyDeckMutator emptyDeckMutator;

    @Autowired
    private HandMutator handMutator;

    @Override
    public void mutateGameState(GameState gameState) {
        double random = randomProvider.random();
        if (random < 1f/3f) {
            handMutator.mutateHand(gameState.getHand());
        }
        else if (random < 2f/3f) {
            boardMutator.mutateBoard(gameState.getBoard());
        }
        else {
            emptyDeckMutator.mutateDeckEmpty(gameState);
        }

    }

    private void mutateHand(List<Card> hand) {
        mutateCard(hand.get(new Long(Math.round(randomProvider.random()*(hand.size()-1))).intValue()));
    }

    private void mutateCard(Card card) {

    }
}
