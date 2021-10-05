package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Battle;

import java.util.List;

public interface BoardMutator {
    void mutateBoard(List<Battle> board);
}
