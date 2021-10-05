package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;

public class Move {
	private Card card;
	private MoveType moveType;
	private Battle battle;

	public Move(Card card, MoveType moveType, Battle battle) {
		this.card = card;
		this.moveType = moveType;
		this.battle = battle;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public MoveType getMoveType() {
		return moveType;
	}

	public void setMoveType(MoveType moveType) {
		this.moveType = moveType;
	}

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Move move = (Move) o;

		if (card != null ? !card.equals(move.card) : move.card != null) return false;
		if (moveType != move.moveType) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = card != null ? card.hashCode() : 0;
		result = 31 * result + (moveType != null ? moveType.hashCode() : 0);
		return result;
	}
}
