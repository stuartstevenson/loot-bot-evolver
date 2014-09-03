package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: StuartS
 * Date: 01/04/12
 * Time: 10:33
 */
public class GameStateTest extends TestCase{
	private GameState gameState1;
	private GameState gameState2;

	public void setUp() throws Exception {
		List<Card> hand1 = new ArrayList<Card>();
		Card card1 = new Card();
		card1.setCardType(CardType.PIRATE);
		card1.setFleetType(FleetType.BLUE);
		card1.setValue(PirateValue.ONE);
		hand1.add(card1);
		List<Battle> battleList1 = new ArrayList<Battle>();
		Battle battle1 = new Battle();
		battle1.setMerchant(new Card(CardType.MERCHANT, null, MerchantValue.TWO));
		Map<Player, List<Card>> fleets1 = new HashMap<Player, List<Card>>();
		Player player1 = new PlayerImpl();
		List<Card> fleet1 = new ArrayList<Card>();
		fleet1.add(new Card(CardType.PIRATE, FleetType.GREEN, PirateValue.TWO));
		fleets1.put(player1, fleet1);
		battle1.setFleets(fleets1);
		battleList1.add(battle1);
		gameState1 = new GameState(hand1, battleList1, false);

		List<Card> hand2 = new ArrayList<Card>();
		Card card2 = new Card();
		card2.setCardType(CardType.PIRATE);
		card2.setFleetType(FleetType.BLUE);
		card2.setValue(PirateValue.ONE);
		hand2.add(card2);
		List<Battle> battleList2 = new ArrayList<Battle>();
		Battle battle2 = new Battle();
		battle2.setMerchant(new Card(CardType.MERCHANT, null, MerchantValue.TWO));
		Map<Player, List<Card>> fleets2 = new HashMap<Player, List<Card>>();
		Player player2 = new PlayerImpl();
		List<Card> fleet2 = new ArrayList<Card>();
		fleet2.add(new Card(CardType.PIRATE, FleetType.GREEN, PirateValue.TWO));
		fleets2.put(player2, fleet2);
		battle2.setFleets(fleets2);
		battleList2.add(battle2);
		gameState2 = new GameState(hand2, battleList2, false);
	}

	public void testEquals() {
		assertTrue(gameState1.equals(gameState2));
	}

	public void testHandNotEquals() {
		gameState2.getHand().add(new Card(CardType.PIRATE, FleetType.GREEN, PirateValue.ONE));
		assertFalse(gameState1.equals(gameState2));
	}

	public void testBoardNotEquals() {
		List<Battle> battleList3 = new ArrayList<Battle>();
		Battle battle3 = new Battle();
		battle3.setMerchant(new Card(CardType.MERCHANT, null, MerchantValue.TWO));
		Map<Player, List<Card>> fleets3 = new HashMap<Player, List<Card>>();
		Player player3 = new PlayerImpl();
		List<Card> fleet3 = new ArrayList<Card>();
		fleet3.add(new Card(CardType.PIRATE, FleetType.GREEN, PirateValue.THREE));
		fleets3.put(player3, fleet3);
		battle3.setFleets(fleets3);
		battleList3.add(battle3);
		gameState2.setBoard(battleList3);
		assertFalse(gameState1.equals(gameState2));
	}
}
