package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.PirateFleet;
import com.sjs.lootbotga.game.PirateFleetList;
import com.sjs.lootbotga.game.Table;
import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import com.sjs.lootbotga.game.cards.FleetType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoveFactory {
	public static List<Move> findAllPossibleMoves(PlayerImpl player, Card card, Table table) {
		List<Move> allMoves = new ArrayList<Move>();
		if (table.getDeck().size() > 0) {
			allMoves.add(new Move(null,MoveType.PICKUP, null));
		}
		if (card.getCardType().equals(CardType.ADMIRAL)) {
            allMoves.addAll(table.getBattleList()
                    .stream()
                    .filter(battle -> battle.getPlayer().equals(player))
                    .map(battle -> new Move(card, MoveType.PLAY, battle))
                    .collect(Collectors.toList()));
		}
		else if (card.getCardType().equals(CardType.CAPTAIN)) {
			for (Battle battle : table.getBattleList()){
                allMoves.addAll(battle.getFleets().stream()
                        .filter(fleet -> fleet.getPlayer().equals(player))
                        .map(fleet -> new Move(card, MoveType.PLAY, battle))
                        .collect(Collectors.toList()));
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
				if (!battle.getFleets().getBy(player).isPresent() && !fleetTypeAlreadyPlayed(card.getFleetType(), battle.getFleets())) {
					allMoves.add(new Move(card,MoveType.PLAY,battle));
				}
				if (battle.getFleets().getBy(player).isPresent()) {
					if (battle.getFleets().getBy(player).get().getHand().get(0).getFleetType().equals(card.getFleetType())){
						allMoves.add(new Move(card, MoveType.PLAY, battle));
					}
				}
			}
		}
		return allMoves;
	}

	private static boolean fleetTypeAlreadyPlayed(FleetType fleetType, PirateFleetList fleets) {
		for (PirateFleet playerListEntry : fleets) {
			if (playerListEntry.getHand().get(0).getFleetType().equals(fleetType)){
				return true;
			}
		}
		return false;
	}


}
