package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.cards.CardType;
import com.sjs.lootbotga.game.player.Move;
import com.sjs.lootbotga.game.player.MoveType;
import com.sjs.lootbotga.game.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:43
 */
@Component
public class GameEngineImpl implements GameEngine {

    @Autowired
    private DealerImpl dealer;

	private Table table = new Table();
	private List<Player> players;

	public void playGame() {
		dealer.deal(table, players);
		boolean endgame = false;
		do {
			for (Player player : players) {
				checkBattlesForWin(player);
				Move move = player.planMove(table);
				if (move == null) {
					endgame = true;
				}
				else {
					executeMove(player,move);
				}
			}
		}while (!endgame);
	}

	private void checkBattlesForWin(Player player) {
		List<Battle> battlesWon = new ArrayList<Battle>();
		for (Battle battle : table.getBattleList()) {
			if (battle.getCurrentLeader().equals(player)) {
				battlesWon.add(battle);
				player.getBooty().add(battle.getMerchant());
			}
		}
		table.getBattleList().removeAll(battlesWon);
	}

	private void executeMove(Player player, Move move) {
		player.getHand().remove(move.getCard());
		if (move.getMoveType().equals(MoveType.DISCARD)) {
			table.getDiscards().add(move.getCard());
		}
		else if (move.getMoveType().equals(MoveType.PICKUP)) {
			player.getHand().add(table.getDeck().remove(0));
		}
		else {
			addToBattle(player, move.getCard(), move.getBattle());
		}
	}

	private void addToBattle(Player player, Card card, Battle battle) {
		if (battle == null) {
			table.getBattleList().add(new Battle(player, card, player));
		}
		else {
			if (card.getCardType().equals(CardType.ADMIRAL)) {
				battle.setAdmiral(card);
				battle.setCurrentLeader(player);
			}
			else {
				addToFleet(player,card, battle);
				updateCurrentLeader(player, card, battle);
			}
		}
	}

	private void updateCurrentLeader(Player player, Card card, Battle battle) {
		if (card.getCardType().equals(CardType.CAPTAIN)){
			battle.setCurrentLeader(player);
		}
		else {
			if (battle.getAdmiral() ==  null){
				Map<Player, Integer> playerScore = new HashMap<Player, Integer>();
				for (Map.Entry<Player, List<Card>> fleet: battle.getFleets().entrySet()) {
					Integer score = 0;
					for (Card ship : fleet.getValue()) {
						if (ship.getCardType().equals(CardType.CAPTAIN)) {
							score = 10000;
							break;
						}
						else {
							score += ship.getValue().getValue();
						}
					}
					playerScore.put(player, score);
				}
				Player currentLeader = battle.getCurrentLeader();
				Integer topScore = 0;
				for (Map.Entry<Player, Integer> playerIntegerEntry : playerScore.entrySet()) {
					if (playerIntegerEntry.getValue() > topScore) {
						currentLeader = playerIntegerEntry.getKey();
						topScore = playerIntegerEntry.getValue();
					}
				}
				if (topScore != 10000) {
					battle.setCurrentLeader(currentLeader);
				}
			}
		}
	}

	private void addToFleet(Player player, Card card, Battle battle) {
		if (battle.getFleets().containsKey(player)) {
			battle.getFleets().get(player).add(card);
		}
		else {
			List<Card> newFleet = new ArrayList<Card>();
			newFleet.add(card);
			battle.getFleets().put(player, newFleet);
		}
	}

	public void setup(List<Player> playerList) {
		table.setDeck(dealer.getNewDeck());
		players = playerList;
		table.setDiscards(new ArrayList<Card>());
		table.setBattleList(new ArrayList<Battle>());
	}

//	public static void main(String[] args) {
//		List<Player> players = new PlayerFactoryImpl().generatePlayers(4, 1);
//		GameEngine gameEngine = new GameEngineImpl();
//		gameEngine.setup(players);
//		gameEngine.playGame();
//		for (Player player : players) {
//			System.out.println(player.getId());
//		}
//	}
}
