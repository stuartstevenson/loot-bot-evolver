package com.sjs.lootbotga.game.player

import com.sjs.lootbotga.game.Battle
import com.sjs.lootbotga.game.cards.Card

data class Move(val card: Card?, var moveType: MoveType, val battle: Battle?)