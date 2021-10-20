package com.sjs.lootbotga.game.player

import com.sjs.lootbotga.game.Table
import com.sjs.lootbotga.game.cards.Card

interface Player {
    fun getId(): Int?

    fun setId(id: Int?)

    fun getHand(): List<Card?>?

    fun getBooty(): List<Card?>?

    fun planMove(table: Table?): Move?

    fun getStrategy(): Map<GameState?, Move?>?

    fun setStrategy(strategy: Map<GameState?, Move?>?)

    fun setHand(hand: List<Card>)

    fun setBooty(booty: List<Card>)
}