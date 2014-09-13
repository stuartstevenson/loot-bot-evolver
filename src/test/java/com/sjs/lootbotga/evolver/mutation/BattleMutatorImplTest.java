package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.PirateFleet;
import com.sjs.lootbotga.game.PirateFleetList;
import com.sjs.lootbotga.game.cards.*;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerImpl;
import com.sjs.lootbotga.provider.RandomProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BattleMutatorImplTest {

    @Mock
    private RandomProvider randomProvider;

    @InjectMocks
    private BattleMutatorImpl battleMutator;

    @Mock
    private MerchantCardMutator merchantCardMutator;

    @Mock
    private AdmiralCardMutator admiralCardMutator;

    @Mock
    private FleetsMutator fleetsMutator;

    @Test
    public void shouldMutateMerchantThirdOfTheTime() {
        Battle battle = new Battle();

        Card merchant = new MerchantCardBuilder().value(MerchantValue.TWO).build();
        battle.setMerchant(merchant);

        when(randomProvider.random()).thenReturn(0.3);

        battleMutator.mutateBattle(battle);

        verify(merchantCardMutator).mutateMerchant(merchant);
    }

    @Test
    public void shouldMutateAdmiralThirdOfTheTime() {
        Battle battle = new Battle();

        Card admiral = new AdmiralCardBuilder().build();
        battle.setAdmiral(admiral);

        when(randomProvider.random()).thenReturn(0.6);

        battleMutator.mutateBattle(battle);

        verify(admiralCardMutator).mutateAdmiral(admiral);
    }

    @Test
    public void shouldMutateAFleetThirdOfTheTime() {
        Battle battle = new Battle();

        Card pirate = new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.ONE).build();
        List<Card> fleet = new ArrayList<>();
        fleet.add(pirate);

        PirateFleetList fleets = new PirateFleetList();
        fleets.add(new PirateFleet(new PlayerImpl(), fleet));

        battle.setFleets(fleets);

        when(randomProvider.random()).thenReturn(0.9);

        battleMutator.mutateBattle(battle);

        verify(fleetsMutator).mutateFleets(fleets);
    }

}