package com.sjs.lootbotga.game.cards

data class CaptainCardBuilder(val fleetType: FleetType) : CardBuilder {

    override fun build(): Card {
        return Card(CardType.CAPTAIN, fleetType, PirateValue.CAPTAIN)
    }
}