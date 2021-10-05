package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HandMutatorImpl implements HandMutator {

    @Autowired
    private CardMutator cardMutator;

    @Autowired
    private RandomProvider randomProvider;

    @Override
    public void mutateHand(List<Card> hand) {
        cardMutator.mutateCard(hand.get(new Long(Math.round(randomProvider.random()*(hand.size()-1))).intValue()));
    }
}
