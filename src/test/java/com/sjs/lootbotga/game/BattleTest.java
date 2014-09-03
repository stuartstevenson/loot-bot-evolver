package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.*;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerImpl;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: StuartS
 * Date: 01/04/12
 * Time: 10:32
 */
public class BattleTest extends TestCase{
	private Battle battle1;
	private Battle battle2;

	public void setUp() throws Exception {
		battle1 = new Battle();
		battle1.setAdmiral(new Card(CardType.ADMIRAL, null, null));
		battle1.setMerchant(new Card(CardType.MERCHANT, null, MerchantValue.TWO));
		Map<Player, List<Card>> fleets1 = new HashMap<Player, List<Card>>();
		Player player1 = new PlayerImpl();
		List<Card> hand1 = new ArrayList<Card>();
		hand1.add(new Card(CardType.PIRATE, FleetType.BLUE, PirateValue.ONE));
		fleets1.put(player1, hand1);
		battle1.setFleets(fleets1);

		battle2 = new Battle();
		battle2.setAdmiral(new Card(CardType.ADMIRAL, null, null));
		battle2.setMerchant(new Card(CardType.MERCHANT, null, MerchantValue.TWO));
		Map<Player, List<Card>> fleets2 = new HashMap<Player, List<Card>>();
		Player player2 = new PlayerImpl();
		List<Card> hand2 = new ArrayList<Card>();
		hand2.add(new Card(CardType.PIRATE, FleetType.BLUE, PirateValue.ONE));
		fleets2.put(player2, hand2);
		battle2.setFleets(fleets2);

	}

	public void testEquals() {
		assertTrue(battle1.equals(battle2));
	}

	public void testMerchantNotEquals() {
		battle2.setMerchant(new Card(CardType.MERCHANT, null, MerchantValue.EIGHT));
		assertFalse(battle1.equals(battle2));
	}

	public void testFleetsNotEquals() {
		Map<Player, List<Card>> fleets3 = new HashMap<Player, List<Card>>();
		Player player2 = new PlayerImpl();
		List<Card> hand2 = new ArrayList<Card>();
		hand2.add(new Card(CardType.PIRATE, FleetType.BLUE, PirateValue.TWO));
		fleets3.put(player2, hand2);
		battle2.setFleets(fleets3);
		assertFalse(battle1.equals(battle2));
	}
}
