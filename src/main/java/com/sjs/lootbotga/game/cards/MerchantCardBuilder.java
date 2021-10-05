package com.sjs.lootbotga.game.cards;

public class MerchantCardBuilder implements Cardbuilder {
    private MerchantValue merchantValue;

    public MerchantCardBuilder value(MerchantValue merchantValue) {
        this.merchantValue = merchantValue;
        return this;
    }

    public final Card build() {
        return new Card(CardType.MERCHANT, null, merchantValue);
    }
}
