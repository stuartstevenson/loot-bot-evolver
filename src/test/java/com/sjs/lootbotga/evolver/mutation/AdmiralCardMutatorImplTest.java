package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.AdmiralCardBuilder;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AdmiralCardMutatorImplTest {

    @InjectMocks
    private AdmiralCardMutatorImpl admiralCardMutator;

    @Test
    public void shouldRemoveAdmiralIfPresent() {
        Card admiral = new AdmiralCardBuilder().build();

        assertThat(admiralCardMutator.mutateAdmiral(admiral)).isNull();
    }

    @Test
    public void shouldCreateAdmiralIfNotPresent() {
        assertThat(admiralCardMutator.mutateAdmiral(null)).isNotNull();
    }

}