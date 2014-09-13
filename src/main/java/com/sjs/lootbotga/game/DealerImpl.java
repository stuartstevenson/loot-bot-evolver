package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.*;
import com.sjs.lootbotga.game.player.Player;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DealerImpl implements Dealer {

    public static final int CARD_PER_HAND = 6;

    public List<Card> getNewDeck() {
		List<Card> cards = new ArrayList<Card>();

		cards.add(getAdmiral());

        cards.addAll(getPirateFleets());

        cards.addAll(getMerchants());

        Collections.shuffle(cards);
		return cards;
	}

    public List<Card> getMerchants() {
        List<Card> cards = new ArrayList<>();
        for (MerchantValue merchantValue: MerchantValue.values()) {
            for (int i = 0; i < merchantValue.getAmount(); i++) {
                cards.add(new MerchantCardBuilder().value(merchantValue).build());
            }
        }
        return cards;
    }

    public List<Card> getPirateFleets() {

        List<Card> cards = new ArrayList<>();

        for (FleetType fleetType : FleetType.values()) {
            cards.add(new CaptainCardBuilder().fleet(fleetType).build());
            for (PirateValue pirateValue : PirateValue.values()) {
                for (int i = 0; i < pirateValue.getAmount(); i++) {
                    cards.add(new PirateCardBuilder().fleet(fleetType).value(pirateValue).build());
                }
            }
        }

        return cards;
    }

    public Card getAdmiral() {
        return new AdmiralCardBuilder().build();
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
