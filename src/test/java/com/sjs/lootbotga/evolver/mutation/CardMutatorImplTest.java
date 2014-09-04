package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import com.sjs.lootbotga.game.cards.FleetType;
import com.sjs.lootbotga.game.cards.PirateValue;
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
        Card card = new Card(CardType.PIRATE, FleetType.BLUE, PirateValue.ONE);

        Card newCard = cardMutator.mutateCard(card);

        assertThat(card).isNotEqualTo(newCard);
    }
}