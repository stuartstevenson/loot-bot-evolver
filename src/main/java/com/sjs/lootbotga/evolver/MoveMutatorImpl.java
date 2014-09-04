package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.MoveType;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveMutatorImpl implements MoveMutator {

    @Autowired
    private RandomProvider randomProvider;

    @Override
    public void mutateMove(Move move) {
        double random = randomProvider.random();
        if (random < 1f/3f) {
            mutateCard(move.getCard());
        }
        else if (random < 2f/3f) {
            mutateMoveType(move.getMoveType());
        }
        else {
            mutateBattle(move.getBattle());
        }
    }

    private void mutateBattle(Battle battle) {
    }

    private void mutateMoveType(MoveType moveType) {

    }

    private void mutateCard(Card card) {

    }
}
