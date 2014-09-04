package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.*;
import com.sjs.lootbotga.game.player.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:46
 */
@Component
public class DealerImpl implements Dealer {

    public static final int CARD_PER_HAND = 6;

    public List<Card> getNewDeck() {
		List<Card> cards = new ArrayList<Card>();
		//admiral
		cards.add(new Card(CardType.ADMIRAL, null, null));
		//fleet
		for (FleetType fleetType : FleetType.values()) {
			cards.add(new Card(CardType.CAPTAIN, fleetType, null));
			for (PirateValue pirateValue : PirateValue.values()) {
				for (int i = 0; i < pirateValue.getAmount(); i++) {
					cards.add(new Card(CardType.PIRATE, fleetType, pirateValue));
				}
			}
		}
		//merchants
		for (MerchantValue merchantValue: MerchantValue.values()) {
			for (int i = 0; i < merchantValue.getAmount(); i++) {
				cards.add(new Card(CardType.MERCHANT, null, merchantValue));
			}
		}
		Collections.shuffle(cards);
		return cards;
	}

	public void deal(Table table, List<Player> players) {
		List<Card> hands = table.getDeck().subList(0, players.size()* CARD_PER_HAND);
		for (int i = 0; i < hands.size(); i++) {
			players.get(i % players.size()).getHand().add(hands.get(i));
		}
		table.setDeck(table.getDeck().subList((players.size()*CARD_PER_HAND), table.getDeck().size()));
	}

//	public static void main(String[] args) {
//		List<Card> deck = Dealer.getNewDeck();
//		for (Card card : deck) {
//			System.out.println(card.toString());
//		}
//		System.out.println(deck.size());
//	}
}
