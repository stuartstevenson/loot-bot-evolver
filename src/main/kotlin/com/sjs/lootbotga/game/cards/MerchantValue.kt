package com.sjs.lootbotga.game.cards

enum class MerchantValue(private val value: Int, private val amount: Int) : CardValue {
    TWO(2, 5),
    THREE(3, 6),
    FOUR(4, 5),
    FIVE(5, 5),
    SIX(6, 2),
    SEVEN(7, 1),
    EIGHT(8, 1);

    override fun getValue(): Int {
        return value
    }

    override fun getAmount(): Int {
        return amount
    }
}