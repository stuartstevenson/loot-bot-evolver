package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.GameState;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.MoveType;
import com.sjs.lootbotga.game.player.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:37
 */
@Component
public class PlayerMutatorImpl implements PlayerMutator {
	public void mutatePlayer(Player player) {
		//todo apply mutation to a player entity
		int numStrategies = player.getStrategy().size();
        if (numStrategies > 0) {
            int strategyToMutate = new Long(Math.round(Math.random() * numStrategies)).intValue();
            Map.Entry<GameState, Move> strategy = new ArrayList<>(player.getStrategy().entrySet()).get((strategyToMutate > 0 ? strategyToMutate - 1 : 0));
            if (Math.random() > 0.5) {
                mutateGameState(strategy.getKey());
            } else {
                mutateMove(strategy.getValue());
            }
        }
	}

	private void mutateMove(Move move) {
		double random = Math.random();
		if (random < 1f/3f) {
			mutateCard(move.getCard());
		}
		else if (random < 2f/3f) {
			mutateMoveType(move.getMoveType());
		}
		else {
			mutateBattle(move.getBattle());
		}
	}

	private void mutateGameState(GameState gameState) {
		double random = Math.random();
		if (random < 1f/3f) {
			mutateHand(gameState.getHand());
		}
		else if (random < 2f/3f) {
			mutateBoard(gameState.getBoard());
		}
		else {
			mutateDeckEmpty(gameState);
		}
	}

	private void mutateDeckEmpty(GameState gameState) {
		gameState.setDeckEmpty(!gameState.isDeckEmpty());
	}

	private void mutateBoard(List<Battle> board) {
		mutateBattle(board.get(new Long(Math.round(Math.random()*(board.size()-1))).intValue()));
	}

	private void mutateHand(List<Card> hand) {
		mutateCard(hand.get(new Long(Math.round(Math.random()*(hand.size()-1))).intValue()));
	}

	private void mutateBattle(Battle battle) {
	}

	private void mutateMoveType(MoveType moveType) {
		//To change body of created methods use File | Settings | File Templates.
	}

	private void mutateCard(Card card) {

	}


}
