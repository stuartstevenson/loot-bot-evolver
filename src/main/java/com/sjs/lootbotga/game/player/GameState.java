package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 21:05
 */
public class GameState {
	private List<Card> hand;
	private List<Battle> board;
	private boolean deckEmpty;

	public GameState(List<Card> hand, List<Battle> board, boolean deckEmpty) {
		this.hand = hand;
		this.board = board;
		this.deckEmpty = deckEmpty;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public List<Battle> getBoard() {
		return board;
	}

	public void setBoard(List<Battle> board) {
		this.board = board;
	}

	public boolean isDeckEmpty() {
		return deckEmpty;
	}

	public void setDeckEmpty(boolean deckEmpty) {
		this.deckEmpty = deckEmpty;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof GameState)) return false;

		GameState gameState = (GameState) o;

		Set<Card> thisCardSet = new HashSet<Card>(this.getHand());
		Set<Card> thatCardSet = new HashSet<Card>(gameState.getHand());
		if (!thisCardSet.equals(thatCardSet)) return false;
		
		Set<Battle> thisBattleSet = new HashSet<Battle>(this.getBoard());
		Set<Battle> thatBattleSet = new HashSet<Battle>(gameState.getBoard());
		if (!thisBattleSet.equals(thatBattleSet)) return false;

		if (deckEmpty != gameState.isDeckEmpty()) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = hand != null ? hand.hashCode() : 0;
		result = 31 * result + (board != null ? board.hashCode() : 0);
		return result;
	}
}
