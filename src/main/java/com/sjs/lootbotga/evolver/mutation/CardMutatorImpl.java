package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Dealer;
import com.sjs.lootbotga.game.DealerImpl;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardMutatorImpl implements CardMutator {

    @Override
    public Card mutateCard(Card card) {

        Dealer dealer = new DealerImpl();

        return dealer.getNewDeck().stream().filter(c -> !c.equals(card)).findAny().get();
    }
}
