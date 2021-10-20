package com.sjs.lootbotga.game.cards

class AdmiralCardBuilder : CardBuilder {
    override fun build(): Card {
        return Card(CardType.ADMIRAL, FleetType.MERCHANT, AdmiralValue.ADMIRAL)
    }
}