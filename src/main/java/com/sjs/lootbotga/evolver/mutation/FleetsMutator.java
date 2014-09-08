package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.Player;

import java.util.List;
import java.util.Map;

public interface FleetsMutator {
    Map<Player, List<Card>> mutateFleets(Map<Player, List<Card>> fleets);
}
