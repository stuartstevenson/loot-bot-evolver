package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoardMutatorImpl implements BoardMutator {

    @Autowired
    private BattleMutator battleMutator;

    @Autowired
    private RandomProvider randomProvider;

    @Override
    public void mutateBoard(List<Battle> board) {
        battleMutator.mutateBattle(board.get(new Long(Math.round(randomProvider.random() * (board.size() - 1))).intValue()));
    }
}
