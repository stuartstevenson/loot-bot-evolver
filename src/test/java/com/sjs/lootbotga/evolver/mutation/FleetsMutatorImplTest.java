package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Dealer;
import com.sjs.lootbotga.game.DealerImpl;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import com.sjs.lootbotga.game.cards.FleetType;
import com.sjs.lootbotga.game.cards.PirateValue;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerFactory;
import com.sjs.lootbotga.game.player.PlayerFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;
import java.util.stream.Collectors;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.util.Lists.newArrayList;

@RunWith(MockitoJUnitRunner.class)
public class FleetsMutatorImplTest {

    @InjectMocks
    private FleetsMutatorImpl fleetsMutator;

    @Spy
    private Dealer dealer = new DealerImpl();

    private PlayerFactory playerFactory = new PlayerFactoryImpl();

    @Test
    public void shouldNotMutateIfThereAreNoFleets() {
        Map<Player, List<Card>> fleets = new HashMap<>();
        fleetsMutator.mutateFleets(fleets);
        assertThat(fleets).isEmpty();
    }

    @Test
    public void shouldMutateOneCardKeepingTheSameFleetColourWithADifferentValue(){

        List<Player> players = playerFactory.generatePlayers(3, 1);

        List<Card> pirateCards = dealer.getPirateFleets();

        List<FleetType> fleetTypes = newArrayList(FleetType.values());
        Collections.shuffle(fleetTypes);

        Map<Player, List<Card>> fleets = players.stream().collect(Collectors.toMap(player -> player, player -> {
            FleetType fleetType = fleetTypes.remove(0);

            List<Card> fleetCards = pirateCards.stream().filter(pc -> pc.getFleetType().equals(fleetType)).collect(Collectors.toList());
            Collections.shuffle(fleetCards);

            return fleetCards.subList(0,1);
        }));

        fleetsMutator.mutateFleets(fleets);
    }

}