package com.sjs.lootbotga.game.cards

//TODO: is there a way to model these statically as they are fixed?
data class Card(val cardType: CardType, val fleetType: FleetType, val value: CardValue)