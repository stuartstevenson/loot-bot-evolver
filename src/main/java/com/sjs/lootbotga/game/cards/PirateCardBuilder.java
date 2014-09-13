package com.sjs.lootbotga.game.cards;

public class PirateCardBuilder {
    private FleetType fleetType;
    private PirateValue pirateValue;

    public PirateCardBuilder fleet(FleetType fleetType) {
        this.fleetType = fleetType;
        return this;
    }

    public PirateCardBuilder value(PirateValue pirateValue) {
        this.pirateValue = pirateValue;
        return this;
    }

    public final Card build() {
        return new Card(CardType.PIRATE, fleetType, pirateValue);
    }
}
