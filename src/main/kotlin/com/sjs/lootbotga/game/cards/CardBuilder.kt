package com.sjs.lootbotga.game.cards


//TODO: what is the best pattern for this builder as it feels very clumsy
interface CardBuilder {
    fun build(): Card?
}