package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Battle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BattleMutatorImpl implements BattleMutator {

    @Autowired
    private MerchantCardMutator merchantCardMutator;

    @Override
    public void mutateBattle(Battle battle) {
        //todo mutate battle
        battle.setMerchant(merchantCardMutator.mutateMerchant(battle.getMerchant()));
    }
}
