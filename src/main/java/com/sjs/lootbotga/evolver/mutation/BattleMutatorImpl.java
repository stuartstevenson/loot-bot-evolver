package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.provider.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BattleMutatorImpl implements BattleMutator {

    @Autowired
    private MerchantCardMutator merchantCardMutator;

    @Autowired
    private RandomProvider randomProvider;

    @Autowired
    private AdmiralCardMutator admiralCardMutator;

    @Override
    public void mutateBattle(Battle battle) {
        //todo mutate battle

        double random = randomProvider.random();

        if (random < 1.0/3.0) {
            battle.setMerchant(merchantCardMutator.mutateMerchant(battle.getMerchant()));
        }else {
            battle.setAdmiral(admiralCardMutator.mutateAdmiral(battle.getAdmiral()));
        }

    }
}
