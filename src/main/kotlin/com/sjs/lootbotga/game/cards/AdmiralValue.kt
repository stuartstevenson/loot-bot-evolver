package com.sjs.lootbotga.game.cards

enum class AdmiralValue(private val value: Int, private val amount: Int): CardValue {

    ADMIRAL(9999,1);

    override fun getValue(): Int? {
        return value
    }

    override fun getAmount(): Int? {
        return amount
    }
}