package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.player.MoveType;
import com.sjs.lootbotga.provider.RandomProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoveTypeMutatorImplTest {

    @InjectMocks
    private MoveTypeMutatorImpl moveTypeMutator;

    @Mock
    private RandomProvider randomProvider;

    @Test
    public void shouldReturnDiscardMoveTypeThirdOfTheTime() {

        when(randomProvider.random()).thenReturn(0.8);

        MoveType moveType = MoveType.DISCARD;
        
        MoveType newMoveType = moveTypeMutator.mutateMoveType(moveType);

        assertThat(newMoveType).isEqualTo(moveType);
    }

    @Test
    public void shouldReturnPlayMoveTypeThirdOfTheTime() {

        when(randomProvider.random()).thenReturn(0.3);

        MoveType moveType = MoveType.DISCARD;

        MoveType newMoveType = moveTypeMutator.mutateMoveType(moveType);

        assertThat(newMoveType).isEqualTo(moveType);
    }

    @Test
    public void shouldReturnPickupMoveTypeThirdOfTheTime() {

        when(randomProvider.random()).thenReturn(0.6);

        MoveType moveType = MoveType.DISCARD;

        MoveType newMoveType = moveTypeMutator.mutateMoveType(moveType);

        assertThat(newMoveType).isEqualTo(moveType);
    }
}