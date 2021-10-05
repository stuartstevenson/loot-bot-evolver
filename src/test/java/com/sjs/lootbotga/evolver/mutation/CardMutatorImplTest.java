package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CardMutatorImplTest {

    @InjectMocks
    private CardMutatorImpl cardMutator;

    @Test
    public void shouldNotBeTheSameCard() {
        Card card = new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.ONE).build();

        Card newCard = cardMutator.mutateCard(card);

        assertThat(card).isNotEqualTo(newCard);
    }
}