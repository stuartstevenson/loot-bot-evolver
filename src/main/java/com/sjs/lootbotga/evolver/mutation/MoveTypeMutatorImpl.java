package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.player.MoveType;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveTypeMutatorImpl implements MoveTypeMutator {

    @Autowired
    private RandomProvider randomProvider;

    @Override
    public MoveType mutateMoveType(MoveType moveType) {
        double random = randomProvider.random();
        if (random < 1/3) {
            return MoveType.PLAY;
        } else if (random < 2/3) {
            return MoveType.PICKUP;
        }else {
            return MoveType.DISCARD;
        }
    }
}
