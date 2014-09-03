package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.GameState;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerImpl;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * User: StuartS
 * Date: 01/04/12
 * Time: 12:24
 */
public class PlayerMutatorImplTest extends TestCase{

	public void testMutatePlayer() {
		Player player = new PlayerImpl();
		Map<GameState, Move> playerStrategy = new HashMap<GameState, Move>();
		player.setStrategy(playerStrategy);

		PlayerMutator playerMutator = new PlayerMutatorImpl();
		playerMutator.mutatePlayer(player);

		assertFalse(playerStrategy.equals(player.getStrategy()));
	}
}
