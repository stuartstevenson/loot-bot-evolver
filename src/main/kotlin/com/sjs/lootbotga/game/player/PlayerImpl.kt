package com.sjs.lootbotga.game.player

import com.sjs.lootbotga.game.Table
import com.sjs.lootbotga.game.cards.Card
import java.util.*

class PlayerImpl : Player{
    private var id: Int? = null
    private var hand: List<Card?>? = null
    private var booty: List<Card?>? = null
    private var strategy: MutableMap<GameState?, Move?>? = null

    override fun getId(): Int? {
        return id
    }

    override fun setId(id: Int?) {
        this.id = id
    }

    override fun getHand(): List<Card?>? {
        return hand
    }

    override fun setHand(hand: List<Card?>?) {
        this.hand = hand
    }

    override override fun getBooty(): List<Card?>? {
        return booty
    }

    override fun setBooty(booty: List<Card?>?) {
        this.booty = booty
    }

    override fun getStrategy(): Map<GameState?, Move?>? {
        return strategy
    }

    fun setStrategy(strategy: MutableMap<GameState?, Move?>?) {
        this.strategy = strategy
    }


    fun planMove(table: Table): Move? {
        return if (strategy!!.containsKey(GameState(getHand(), table.battleList, table.deck.isEmpty()))) {
            strategy!![GameState(getHand(), table.battleList, table.deck.isEmpty())]
        } else {
            val move = randomValidMove(table)
            strategy!![GameState(getHand(), table.battleList, table.deck.isEmpty())] = move
            move
        }
    }

    private fun randomValidMove(table: Table): Move? {
        val possibleMoves: MutableList<Move?> = ArrayList()
        for (card in hand!!) {
            possibleMoves.addAll(MoveFactory.findAllPossibleMoves(this, card, table))
        }
        return if (possibleMoves.size > 0) {
            Collections.shuffle(possibleMoves)
            possibleMoves[0]
        } else {
            null
        }
    }

}