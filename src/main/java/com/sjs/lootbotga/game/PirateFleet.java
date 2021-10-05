package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.Player;

import java.util.List;

public class PirateFleet {
    private Player player;
    private List<Card> hand;

    public PirateFleet(Player player, List<Card> hand) {

        this.player = player;
        this.hand = hand;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
