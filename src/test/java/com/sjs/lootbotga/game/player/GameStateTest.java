package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.PirateFleet;
import com.sjs.lootbotga.game.PirateFleetList;
import com.sjs.lootbotga.game.cards.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameStateTest {
	private GameState gameState1;
	private GameState gameState2;

    @Before
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

        PirateFleetList pirateFleetList1 = new PirateFleetList();
		Player player1 = new PlayerImpl();
		List<Card> fleet1 = new ArrayList<Card>();
		fleet1.add(new Card(CardType.PIRATE, FleetType.GREEN, PirateValue.TWO));
		pirateFleetList1.add(new PirateFleet(player1, fleet1));
		battle1.setFleets(pirateFleetList1);
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
		PirateFleetList pirateFleetList2 = new PirateFleetList();
		Player player2 = new PlayerImpl();
		List<Card> fleet2 = new ArrayList<Card>();
		fleet2.add(new Card(CardType.PIRATE, FleetType.GREEN, PirateValue.TWO));
		pirateFleetList2.add(new PirateFleet(player2, fleet2));
		battle2.setFleets(pirateFleetList2);
		battleList2.add(battle2);
		gameState2 = new GameState(hand2, battleList2, false);
	}

    @Test
	public void testEquals() {
		assertThat(gameState1).isEqualTo(gameState2);
	}

    @Test
	public void testHandNotEquals() {
		gameState2.getHand().add(new PirateCardBuilder().fleet(FleetType.GREEN).value(PirateValue.ONE).build());
		assertThat(gameState1).isNotEqualTo(gameState2);
	}

    @Test
	public void testBoardNotEquals() {
		List<Battle> battleList3 = new ArrayList<Battle>();
		Battle battle3 = new Battle();
		battle3.setMerchant(new MerchantCardBuilder().value(MerchantValue.TWO).build());

        PirateFleetList pirateFleetList3 = new PirateFleetList();

		Player player3 = new PlayerImpl();
		List<Card> fleet3 = new ArrayList<Card>();
		fleet3.add(new PirateCardBuilder().fleet(FleetType.GREEN).value(PirateValue.THREE).build());
		pirateFleetList3.add(new PirateFleet(player3, fleet3));
		battle3.setFleets(pirateFleetList3);
		battleList3.add(battle3);
		gameState2.setBoard(battleList3);
		assertThat(gameState1).isNotEqualTo(gameState2);
	}
}