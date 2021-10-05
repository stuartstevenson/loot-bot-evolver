package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.Table;
import com.sjs.lootbotga.game.cards.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class PlayerImpl implements Player {
	private Integer id;
	private List<Card> hand;
	private List<Card> booty;
	private Map<GameState, Move> strategy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public List<Card> getBooty() {
		return booty;
	}

	public void setBooty(List<Card> booty) {
		this.booty = booty;
	}

	public Map<GameState, Move> getStrategy() {
		return strategy;
	}

	public void setStrategy(Map<GameState, Move> strategy) {
		this.strategy = strategy;
	}



	public Move planMove(Table table) {
		if (strategy.containsKey(new GameState(getHand(), table.getBattleList(), table.getDeck().isEmpty()))) {
			return strategy.get(new GameState(getHand(), table.getBattleList(), table.getDeck().isEmpty()));
		}
		else {
			Move move = randomValidMove(table);
			strategy.put(new GameState(getHand(), table.getBattleList(), table.getDeck().isEmpty()), move);
			return move;
		}
	}

	private Move randomValidMove(Table table) {
		List<Move> possibleMoves = new ArrayList<Move>();
		for (Card card : hand) {
			possibleMoves.addAll(MoveFactory.findAllPossibleMoves(this, card, table));
		}
		if (possibleMoves.size() > 0) {
			Collections.shuffle(possibleMoves);
			return possibleMoves.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PlayerImpl player = (PlayerImpl) o;

		if (id != null ? !id.equals(player.id) : player.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
