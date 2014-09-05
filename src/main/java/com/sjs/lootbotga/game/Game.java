package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import com.sjs.lootbotga.game.player.Player;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game implements Runnable {
	private GameEngine gameEngine;
	private List<Player> playerList;

	public Game() {
	}

	public Game( List<Player> playerList) {
		this.gameEngine = new GameEngineImpl();
		this.playerList = playerList;
	}

	public void run() {
		gameEngine.setup(playerList);
		gameEngine.playGame();
	}

	public Player winner() {
		Map<Player, Integer> playerScores = scoreGame();
		Player winner = null;
		Integer score = 0;
		for (Map.Entry<Player, Integer> playerIntegerEntry : playerScores.entrySet()) {
			if (playerIntegerEntry.getValue() > score) {
				winner = playerIntegerEntry.getKey();
				score = playerIntegerEntry.getValue();
			}
		}
		return winner;
	}

	private Map<Player, Integer> scoreGame() {
		Map<Player, Integer> playerScores = new HashMap<Player, Integer>();
		for (Player player : playerList) {
			playerScores.put(player, scoreCards(player.getBooty()) - scoreCards(player.getHand()));
		}
		return playerScores;
	}

	private Integer scoreCards(List<Card> cards) {
		Integer score = 0;
		for (Card card : cards) {
			if (card.getCardType().equals(CardType.MERCHANT)) {
				score += card.getValue().getValue();
			}
		}
		return score;
	}
}
