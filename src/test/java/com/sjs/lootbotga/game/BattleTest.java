package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.*;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;

public class BattleTest {
	private Battle battle1;
	private Battle battle2;

    @Before
	public void setUp() throws Exception {
		battle1 = new Battle();
		battle1.setAdmiral(new Card(CardType.ADMIRAL, null, null));
		battle1.setMerchant(new Card(CardType.MERCHANT, null, MerchantValue.TWO));

        PirateFleetList fleetList1 = new PirateFleetList();
        Player player1 = new PlayerImpl();
        List<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(CardType.PIRATE, FleetType.BLUE, PirateValue.ONE));
        PirateFleet pirateFleet1 = new PirateFleet(player1, hand1);
        fleetList1.add(pirateFleet1);
        battle1.setFleets(fleetList1);

		battle2 = new Battle();
		battle2.setAdmiral(new Card(CardType.ADMIRAL, null, null));
		battle2.setMerchant(new Card(CardType.MERCHANT, null, MerchantValue.TWO));
        PirateFleetList fleetList2 = new PirateFleetList();
        Player player2 = new PlayerImpl();
        List<Card> hand2 = new ArrayList<>();
        hand2.add(new Card(CardType.PIRATE, FleetType.BLUE, PirateValue.ONE));
        PirateFleet pirateFleet2 = new PirateFleet(player2, hand2);
        fleetList2.add(pirateFleet2);
        battle2.setFleets(fleetList2);

	}

    @Test
	public void testEquals() {
		assertThat(battle1).isEqualTo(battle2);
	}

    @Test
	public void testMerchantNotEquals() {
		battle2.setMerchant(new Card(CardType.MERCHANT, null, MerchantValue.EIGHT));
		assertThat(battle1).isNotEqualTo(battle2);
	}

    @Test
	public void testFleetsNotEquals() {
        PirateFleetList pirateFleetList3 = new PirateFleetList();
		Player player2 = new PlayerImpl();
		List<Card> hand2 = new ArrayList<>();
		hand2.add(new Card(CardType.PIRATE, FleetType.BLUE, PirateValue.TWO));
		pirateFleetList3.add(new PirateFleet(player2, hand2));
		battle2.setFleets(pirateFleetList3);
		assertThat(battle1).isNotEqualTo(battle2);
	}
}