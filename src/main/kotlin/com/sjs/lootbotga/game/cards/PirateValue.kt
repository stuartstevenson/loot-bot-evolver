package com.sjs.lootbotga.game.cards

enum class PirateValue(private val value: Int, private val amount: Int) : CardValue {
    ONE(1, 2),
    TWO(2, 4),
    THREE(3, 4),
    FOUR(4, 2),
    CAPTAIN(999, 1);

    override fun getValue(): Int {
        return value
    }

    override fun getAmount(): Int {
        return amount
    }
}