package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        if (!this.getHand().equals(gameState.getHand())) return false;

        if (!this.getBoard().equals(gameState.getBoard())) return false;

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
