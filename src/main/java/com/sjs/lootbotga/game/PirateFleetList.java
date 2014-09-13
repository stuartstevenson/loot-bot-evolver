package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.player.Player;

import java.util.ArrayList;
import java.util.Optional;

public class PirateFleetList extends ArrayList<PirateFleet>{
    public Optional<PirateFleet> getBy(Player player) {
        return this.stream().filter(pirateFleet -> pirateFleet.getPlayer().equals(player)).findFirst();
    }
}
