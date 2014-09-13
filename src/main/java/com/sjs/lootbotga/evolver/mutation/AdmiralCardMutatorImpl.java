package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.AdmiralCardBuilder;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import org.springframework.stereotype.Component;

@Component
public class AdmiralCardMutatorImpl implements AdmiralCardMutator {
    @Override
    public Card mutateAdmiral(Card admiral) {

        Card returnCard = null;

        if (admiral == null) {
            returnCard = new AdmiralCardBuilder().build();
        }
        return returnCard;
    }
}
