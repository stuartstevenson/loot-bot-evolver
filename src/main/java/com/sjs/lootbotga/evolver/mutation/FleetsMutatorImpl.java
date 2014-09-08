package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FleetsMutatorImpl implements FleetsMutator {
    @Override
    public Map<Player, List<Card>> mutateFleets(Map<Player, List<Card>> fleets) {
        //todo mutate fleets
        return null;
    }
}
