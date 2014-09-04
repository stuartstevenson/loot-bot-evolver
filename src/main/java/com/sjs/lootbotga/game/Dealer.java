package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.Player;

import java.util.List;

public interface Dealer {
    List<Card> getNewDeck();
    void deal(Table table, List<Player> players);
}
