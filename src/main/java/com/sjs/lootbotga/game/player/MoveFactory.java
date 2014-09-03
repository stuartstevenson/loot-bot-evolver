package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.Table;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import com.sjs.lootbotga.game.cards.FleetType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MoveFactory {
	public static List<Move> findAllPossibleMoves(PlayerImpl player, Card card, Table table) {
		List<Move> allMoves = new ArrayList<Move>();
		if (table.getDeck().size() > 0) {
			allMoves.add(new Move(null,MoveType.PICKUP, null));
		}
		if (card.getCardType().equals(CardType.ADMIRAL)) {
			for (Battle battle : table.getBattleList()){
				if (battle.getPlayer().equals(player)) {
					allMoves.add(new Move(card, MoveType.PLAY, battle));
				}
			}
		}
		else if (card.getCardType().equals(CardType.CAPTAIN)) {
			for (Battle battle : table.getBattleList()){
				for (Map.Entry<Player, List<Card>> fleet: battle.getFleets().entrySet()) {
					if (fleet.getKey().equals(player)) {
						allMoves.add(new Move(card, MoveType.PLAY, battle));
					}
				}
			}
		}
		else if (card.getCardType().equals(CardType.MERCHANT)) {
			allMoves.add(new Move(card, MoveType.PLAY, null));
		}
		else {
			if (table.getDeck().size() == 0) {
				allMoves.add(new Move(card, MoveType.DISCARD, null));
			}
			for (Battle battle : table.getBattleList()){
				if (!battle.getFleets().containsKey(player) && !fleetTypeAlreadyPlayed(card.getFleetType(), battle.getFleets())) {
					allMoves.add(new Move(card,MoveType.PLAY,battle));
				}
				if (battle.getFleets().containsKey(player)) {
					if (battle.getFleets().get(player).get(0).equals(card.getFleetType())){
						allMoves.add(new Move(card, MoveType.PLAY, battle));
					}
				}
			}
		}
		return allMoves;
	}

	private static boolean fleetTypeAlreadyPlayed(FleetType fleetType, Map<Player, List<Card>> fleets) {
		for (Map.Entry<Player, List<Card>> playerListEntry : fleets.entrySet()) {
			if (playerListEntry.getValue().get(0).getFleetType().equals(fleetType)){
				return true;
			}
		}
		return false;
	}


}
