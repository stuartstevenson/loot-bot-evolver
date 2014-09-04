package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.GameState;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerImpl;
import com.sjs.lootbotga.provider.RandomProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class PlayerMutatorImplTest {

    @Mock
    private RandomProvider randomProvider;

    @InjectMocks
    private PlayerMutatorImpl playerMutator;

    @Test
	public void shouldNotMutatePlayerWithNoStrategies() {
		Player player = new PlayerImpl();
		Map<GameState, Move> playerStrategy = new HashMap<GameState, Move>();
		player.setStrategy(playerStrategy);

		playerMutator.mutatePlayer(player);

		assertThat(playerStrategy).isEqualTo(player.getStrategy());
	}

    @Test
    public void shouldMutateMove50PercentOfTheTime() {

    }

    @Test
    public void shouldMutateGameState50PercentOfTheTime() {

    }
}
