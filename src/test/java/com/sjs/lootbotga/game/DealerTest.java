package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DealerTest {

    public static final int TOTAL_DECK_SIZE = 78;
    @InjectMocks
    private DealerImpl dealer;

    @Test
	public void deckConstructedProperly() {
        List<Card> deck = dealer.getNewDeck();

        assertThat(deck).hasSize(TOTAL_DECK_SIZE);
	}

    @Test
	public void dealShouldGiveEachPlayer6Cards() {
        Table table = new Table();
        table.setDeck(dealer.getNewDeck());

        PlayerImpl player = new PlayerImpl();
        player.setHand(new ArrayList<>());

        List<Player> players = Arrays.asList(player);

        dealer.deal(table, players);

        assertThat(table.getDeck()).hasSize(TOTAL_DECK_SIZE - 6);
        assertThat(players.get(0).getHand()).hasSize(6);
	}
}
