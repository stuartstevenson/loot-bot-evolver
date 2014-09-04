package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.*;
import com.sjs.lootbotga.provider.RandomProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerMutatorImplTest {

    @Mock
    private RandomProvider randomProvider;

    @InjectMocks
    private PlayerMutatorImpl playerMutator;

    @Mock
    private MoveMutator moveMutator;

    @Mock
    private GameStateMutator gameStateMutator;

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

        Player player = new PlayerImpl();
        Map<GameState, Move> playerStrategy = new HashMap<GameState, Move>();
        playerStrategy.put(new GameState(Collections.<Card>emptyList(), Collections.<Battle>emptyList(), false), new Move(new Card(), MoveType.PLAY, new Battle()));
        player.setStrategy(playerStrategy);

        when(randomProvider.random()).thenReturn(0.5);

        playerMutator.mutatePlayer(player);

        verify(moveMutator, atLeastOnce()).mutateMove(any(Move.class));
    }

    @Test
    public void shouldMutateGameState50PercentOfTheTime() {
        Player player = new PlayerImpl();
        Map<GameState, Move> playerStrategy = new HashMap<GameState, Move>();
        playerStrategy.put(new GameState(Collections.<Card>emptyList(), Collections.<Battle>emptyList(), false), new Move(new Card(), MoveType.PLAY, new Battle()));
        player.setStrategy(playerStrategy);

        when(randomProvider.random()).thenReturn(0.6);

        playerMutator.mutatePlayer(player);

        verify(gameStateMutator, atLeastOnce()).mutateGameState(any(GameState.class));
    }
}
