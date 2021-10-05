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
		battle1.setAdmiral(new AdmiralCardBuilder().build());
		battle1.setMerchant(new MerchantCardBuilder().value(MerchantValue.TWO).build());

        PirateFleetList fleetList1 = new PirateFleetList();
        Player player1 = new PlayerImpl();
        List<Card> hand1 = new ArrayList<>();
        hand1.add(new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.ONE).build());
        PirateFleet pirateFleet1 = new PirateFleet(player1, hand1);
        fleetList1.add(pirateFleet1);
        battle1.setFleets(fleetList1);

		battle2 = new Battle();
		battle2.setAdmiral(new AdmiralCardBuilder().build());
		battle2.setMerchant(new MerchantCardBuilder().value(MerchantValue.TWO).build());
        PirateFleetList fleetList2 = new PirateFleetList();
        Player player2 = new PlayerImpl();
        List<Card> hand2 = new ArrayList<>();
        hand2.add(new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.ONE).build());
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
		battle2.setMerchant(new MerchantCardBuilder().value(MerchantValue.EIGHT).build());
		assertThat(battle1).isNotEqualTo(battle2);
	}

    @Test
	public void testFleetsNotEquals() {
        PirateFleetList pirateFleetList3 = new PirateFleetList();
		Player player2 = new PlayerImpl();
		List<Card> hand2 = new ArrayList<>();
		hand2.add(new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.TWO).build());
		pirateFleetList3.add(new PirateFleet(player2, hand2));
		battle2.setFleets(pirateFleetList3);
		assertThat(battle1).isNotEqualTo(battle2);
	}
}