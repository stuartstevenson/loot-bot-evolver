package com.sjs.lootbotga.game.player;

public class PlayerResult {
    private final Player player;
    private int numberOfWins;

    public PlayerResult(Player player, int numberOfWins) {

        this.player = player;
        this.numberOfWins = numberOfWins;
    }

    public void incrementWin() {
        numberOfWins++;
    }

    public Player getPlayer() {
        return player;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }
}
