package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Dealer;
import com.sjs.lootbotga.game.DealerImpl;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import com.sjs.lootbotga.game.cards.MerchantCardBuilder;
import com.sjs.lootbotga.game.cards.MerchantValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MerchantCardMutatorImplTest {

    @InjectMocks
    private MerchantCardMutatorImpl merchantCardMutator;

    @Spy
    private Dealer dealer = new DealerImpl();

    @Test
    public void an8CoinShipCannotMutateIntoAn8CoinShip() {
        Card eightCoinMerchant = new MerchantCardBuilder().value(MerchantValue.EIGHT).build();

        Card mutatedCard = merchantCardMutator.mutateMerchant(eightCoinMerchant);

        assertThat(mutatedCard.getCardType()).isEqualTo(CardType.MERCHANT);
        assertThat(mutatedCard.getValue()).isNotEqualTo(MerchantValue.EIGHT);
    }
}