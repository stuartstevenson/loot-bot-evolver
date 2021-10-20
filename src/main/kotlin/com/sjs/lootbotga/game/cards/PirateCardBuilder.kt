package com.sjs.lootbotga.game.cards

data class PirateCardBuilder(private val fleetType: FleetType, private val pirateValue: PirateValue) : CardBuilder {
    override fun build(): Card {
        return Card(CardType.PIRATE, fleetType, pirateValue)
    }
}