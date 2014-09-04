package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.MoveType;
import com.sjs.lootbotga.provider.RandomProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoveMutatorImplTest {

    @Mock
    private RandomProvider randomProvider;

    @InjectMocks
    private MoveMutatorImpl moveMutator;

    @Mock
    private BattleMutator battleMutator;

    @Mock
    private MoveTypeMutator moveTypeMutator;

    @Test
    public void shouldMutateBattleThirdOfTheTime() {

        Battle battle = new Battle();

        Move move = new Move(new Card(), MoveType.PLAY, battle);

        when(randomProvider.random()).thenReturn(0.8);
        moveMutator.mutateMove(move);

        verify(battleMutator).mutateBattle(battle);

    }

    @Test
    public void shouldMutateMoveTypeThirdOfTheTime() {
        Battle battle = new Battle();
        MoveType moveType = MoveType.PLAY;

        Move move = new Move(new Card(), moveType, battle);

        when(randomProvider.random()).thenReturn(0.6);
        moveMutator.mutateMove(move);

        verify(moveTypeMutator).mutateMoveType(moveType);
    }
}