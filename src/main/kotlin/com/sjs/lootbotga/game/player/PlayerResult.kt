package com.sjs.lootbotga.game.player

data class PlayerResult(val player: Player, var numberOfWins: Int) {
    fun incrementWin() = numberOfWins++
}