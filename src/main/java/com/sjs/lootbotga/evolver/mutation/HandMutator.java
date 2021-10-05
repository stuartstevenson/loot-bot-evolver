package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.Card;

import java.util.List;

public interface HandMutator {
    void mutateHand(List<Card> hand);
}
