package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.GameState;
import com.sjs.lootbotga.provider.RandomProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameStateMutatorImplTest {

    @Mock
    private RandomProvider randomProvider;

    @InjectMocks
    private GameStateMutatorImpl gameStateMutator;

    @Mock
    private EmptyDeckMutator emptyDeckMutator;

    @Mock
    private BoardMutator boardMutator;

    @Mock
    private HandMutator handMutator;

    @Test
    public void shouldMutateDeckEmptyThirdOfTheTime() {
        when(randomProvider.random()).thenReturn(0.8);
        GameState gameState = new GameState(Collections.<Card>emptyList(), Collections.<Battle>emptyList(), false);
        gameStateMutator.mutateGameState(gameState);

        verify(emptyDeckMutator, atLeastOnce()).mutateDeckEmpty(gameState);
    }

    @Test
    public void shouldMutateBoardThirdOfTheTime() {
        when(randomProvider.random()).thenReturn(0.6);
        List<Battle> board = Collections.<Battle>emptyList();
        GameState gameState = new GameState(Collections.<Card>emptyList(), board, false);
        gameStateMutator.mutateGameState(gameState);

        verify(boardMutator, atLeastOnce()).mutateBoard(board);
    }

    @Test
    public void shouldMutateHandThirdOfTheTime() {
        when(randomProvider.random()).thenReturn(0.3);
        List<Battle> board = Collections.<Battle>emptyList();
        List<Card> hand = Collections.<Card>emptyList();
        GameState gameState = new GameState(hand, board, false);
        gameStateMutator.mutateGameState(gameState);

        verify(handMutator, atLeastOnce()).mutateHand(hand);
    }
}