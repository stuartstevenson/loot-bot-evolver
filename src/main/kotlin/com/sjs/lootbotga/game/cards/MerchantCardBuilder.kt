package com.sjs.lootbotga.game.cards

data class MerchantCardBuilder(private val merchantValue: MerchantValue) : CardBuilder {

    override fun build(): Card {
        return Card(CardType.MERCHANT, FleetType.MERCHANT, merchantValue)
    }
}