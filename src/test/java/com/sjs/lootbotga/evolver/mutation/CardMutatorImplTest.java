package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.*;
import com.sjs.lootbotga.provider.RandomProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CardMutatorImplTest {

    @InjectMocks
    private CardMutatorImpl cardMutator;

    @Mock
    private RandomProvider randomProvider;

    @Mock
    private CardTypeMutator cardTypeMutator;

    @Test
    public void shouldChangeCardTypeThirdOfTheTime() {
        Card card = new Card(CardType.PIRATE, FleetType.BLUE, PirateValue.ONE);

        when(randomProvider.random()).thenReturn(0.3);

        cardMutator.mutateCard(card);

        verify(cardTypeMutator, atLeastOnce()).mutateCardType(any(CardType.class));
    }
}