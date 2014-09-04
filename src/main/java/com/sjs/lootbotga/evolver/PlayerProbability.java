package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;

public class PlayerProbability {
    private Player player;
    private double lowerRange;
    private double upperRange;

    public PlayerProbability() {
    }

    public PlayerProbability(Player player, double lowerRange, double upperRange) {
        this.player = player;
        this.lowerRange = lowerRange;
        this.upperRange = upperRange;
    }

    boolean isInRange(double randomValue) {
        return randomValue > lowerRange && randomValue <= upperRange;
    }

    public Player getPlayer() {
        return player;
    }

    public double getLowerRange() {
        return lowerRange;
    }

    public double getUpperRange() {
        return upperRange;
    }
}
