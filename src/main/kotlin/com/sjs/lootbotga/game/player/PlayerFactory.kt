package com.sjs.lootbotga.game.player

interface PlayerFactory {
    fun generatePlayers(numPlayer: Int, generationCount: Int): List<Player>
}