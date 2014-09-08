package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Dealer;
import com.sjs.lootbotga.game.DealerImpl;
import com.sjs.lootbotga.game.cards.Card;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMutatorImpl implements CardMutator {

    @Override
    public Card mutateCard(Card card) {

        Dealer dealer = new DealerImpl();

        List<Card> filteredDeck = dealer.getNewDeck().stream().filter(c -> !c.equals(card)).collect(Collectors.toList());

        Collections.shuffle(filteredDeck);

        return filteredDeck.stream().findAny().get();
    }
}
