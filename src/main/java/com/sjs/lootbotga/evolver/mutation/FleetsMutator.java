package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.PirateFleetList;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.Player;

import java.util.List;
import java.util.Map;

public interface FleetsMutator {
    PirateFleetList mutateFleets(PirateFleetList fleets);
}
