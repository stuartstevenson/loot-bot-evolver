package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.Table;
import com.sjs.lootbotga.game.cards.Card;

import java.util.List;
import java.util.Map;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:09
 */
public interface Player {
	Integer getId();

	void setId(Integer id);
	
	List<Card> getHand();

	List<Card> getBooty();

	Move planMove(Table table);

	Map<GameState, Move> getStrategy();

	void setStrategy(Map<GameState, Move> strategy);
}
