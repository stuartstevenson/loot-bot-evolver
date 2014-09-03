package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.Card;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:44
 */
@Component
public class Table {
	private List<Battle> battleList;
	private List<Card> deck;
	private List<Card> discards;

	public List<Battle> getBattleList() {
		return battleList;
	}

	public void setBattleList(List<Battle> battleList) {
		this.battleList = battleList;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public List<Card> getDiscards() {
		return discards;
	}

	public void setDiscards(List<Card> discards) {
		this.discards = discards;
	}
}
