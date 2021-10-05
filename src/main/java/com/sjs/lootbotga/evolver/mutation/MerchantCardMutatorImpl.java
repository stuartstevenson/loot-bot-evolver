package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Dealer;
import com.sjs.lootbotga.game.cards.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class MerchantCardMutatorImpl implements MerchantCardMutator {

    @Autowired
    private Dealer dealer;

    @Override
    public Card mutateMerchant(Card merchant) {
        List<Card> merchants = dealer.getMerchants();

        merchants.remove(merchant);

        Collections.shuffle(merchants);

        return merchants.stream().findAny().get();
    }
}
