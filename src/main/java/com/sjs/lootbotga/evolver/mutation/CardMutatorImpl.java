package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardMutatorImpl implements CardMutator {

    @Autowired
    private RandomProvider randomProvider;

    @Autowired
    private CardTypeMutator cardTypeMutator;

    @Override
    public void mutateCard(Card card) {

        double random = randomProvider.random();

        if (random < 1.0/3.0) {
            card.setCardType(cardTypeMutator.mutateCardType(card.getCardType()));
        } else if (random < 2.0/3.0) {

        } else {

        }

    }
}
