package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.GameState;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class PlayerMutatorImplTest {

    @Test
	public void testMutatePlayer() {
		Player player = new PlayerImpl();
		Map<GameState, Move> playerStrategy = new HashMap<GameState, Move>();
		player.setStrategy(playerStrategy);

		PlayerMutator playerMutator = new PlayerMutatorImpl();
		playerMutator.mutatePlayer(player);

		assertFalse(playerStrategy.equals(player.getStrategy()));
	}
}
