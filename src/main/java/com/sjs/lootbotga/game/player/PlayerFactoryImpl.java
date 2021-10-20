package com.sjs.lootbotga.game.player;

import com.sjs.lootbotga.game.cards.Card;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class PlayerFactoryImpl implements PlayerFactory {
	public List<Player> generatePlayers(int numPlayers, int generationCount) {
		List<Player> players = new ArrayList<Player>();
		int i = 0;
		while (i < numPlayers) {
			players.add(generatePlayer(generationCount, ++i, numPlayers));
		}
		return players;
	}

	private Player generatePlayer(int generationCount, int playerCount, int  numPlayers) {
		Player player = new PlayerImpl();
		generatePlayerId(generationCount, playerCount, player, numPlayers);
		player.setHand(new ArrayList<Card>());
		player.setBooty(new ArrayList<Card>());
		player.setStrategy(new HashMap<GameState, Move>());
		return player;
	}

	public static void generatePlayerId(int generationCount, int playerCount, Player player, int numPlayers) {
		String id = ""+playerCount;
		String digits = "#0";
		if (numPlayers > 9) {
			digits += "0";
		}
		if (numPlayers > 99) {
			digits += "0";
		}
		if (numPlayers > 999) {
			digits += "0";
		}
		DecimalFormat df = new DecimalFormat(digits);

		player.setId(Integer.parseInt(generationCount+df.format(playerCount)));
	}
}
