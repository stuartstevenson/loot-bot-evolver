package com.sjs.lootbotga.game.cards;

public final class AdmiralCardBuilder implements Cardbuilder {
    @Override
    public final Card build() {
        return new Card(CardType.ADMIRAL, null, null);
    }
}
