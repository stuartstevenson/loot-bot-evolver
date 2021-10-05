package com.sjs.lootbotga.game.cards;

public class CaptainCardBuilder implements Cardbuilder {

    private FleetType fleetType;

    public CaptainCardBuilder fleet(FleetType fleetType) {
        this.fleetType = fleetType;
        return this;
    }

    @Override
    public final Card build() {
        return new Card(CardType.CAPTAIN, fleetType, null);
    }
}
