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

    @Autowired
    private FleetsMutator fleetsMutator;

    @Override
    public void mutateBattle(Battle battle) {

        double random = randomProvider.random();

        if (random < 1.0/3.0) {
            battle.setMerchant(merchantCardMutator.mutateMerchant(battle.getMerchant()));
        } else if (random < 2.0/3.0){
            battle.setAdmiral(admiralCardMutator.mutateAdmiral(battle.getAdmiral()));
        } else {
            battle.setFleets(fleetsMutator.mutateFleets(battle.getFleets()));
        }

    }
}