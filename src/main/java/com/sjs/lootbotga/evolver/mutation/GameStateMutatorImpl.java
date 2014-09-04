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

    @Override
    public void mutateGameState(GameState gameState) {
        double random = randomProvider.random();
        if (random < 1f/3f) {
            mutateHand(gameState.getHand());
        }
        else if (random < 2f/3f) {
            mutateBoard(gameState.getBoard());
        }
        else {
            mutateDeckEmpty(gameState);
        }

    }

    private void mutateDeckEmpty(GameState gameState) {
        gameState.setDeckEmpty(!gameState.isDeckEmpty());
    }

    private void mutateBoard(List<Battle> board) {
        mutateBattle(board.get(new Long(Math.round(randomProvider.random()*(board.size()-1))).intValue()));
    }

    private void mutateBattle(Battle battle) {
    }

    private void mutateHand(List<Card> hand) {
        mutateCard(hand.get(new Long(Math.round(randomProvider.random()*(hand.size()-1))).intValue()));
    }

    private void mutateCard(Card card) {

    }
}
