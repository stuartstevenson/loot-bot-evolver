package com.sjs.lootbotga.game;

import com.sjs.lootbotga.game.cards.Card;
import com.sjs.lootbotga.game.player.Player;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 20:48
 */
@Component
public class Battle {
	private Player player;
	private Card merchant;
	private Card admiral;
	private Player currentLeader;
	private Map<Player, List<Card>> fleets;

	public Battle() {
	}

	public Battle(Player player, Card merchant, Player currentLeader) {
		this.player = player;
		this.merchant = merchant;
		this.currentLeader = currentLeader;
		this.fleets = new HashMap<Player, List<Card>>();
	}

	public Player getCurrentLeader() {
		return currentLeader;
	}

	public void setCurrentLeader(Player currentLeader) {
		this.currentLeader = currentLeader;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Card getMerchant() {
		return merchant;
	}

	public void setMerchant(Card merchant) {
		this.merchant = merchant;
	}

	public Card getAdmiral() {
		return admiral;
	}

	public void setAdmiral(Card admiral) {
		this.admiral = admiral;
	}

	public Map<Player, List<Card>> getFleets() {
		return fleets;
	}

	public void setFleets(Map<Player, List<Card>> fleets) {
		this.fleets = fleets;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Battle battle = (Battle) o;

		if (admiral != null ? !admiral.equals(battle.admiral) : battle.admiral != null) return false;
		if (merchant != null ? !merchant.equals(battle.merchant) : battle.merchant != null) return false;
		
		Set<Set<Card>> thisCardSet = new HashSet<Set<Card>>();
		if (fleets == null && battle.getFleets() == null ) {
			return true;
		}
		for (List<Card> cards : fleets.values()) {
			thisCardSet.add(new HashSet<Card>(cards));
		}
		Set<Set<Card>> thatCardSet = new HashSet<Set<Card>>();
		for (List<Card> cards : battle.getFleets().values()) {
			 thatCardSet.add(new HashSet<Card>(cards));
		}

        return thisCardSet.equals(thatCardSet);
    }

	@Override
	public int hashCode() {
		int result = player != null ? player.hashCode() : 0;
		result = 31 * result + (merchant != null ? merchant.hashCode() : 0);
		result = 31 * result + (admiral != null ? admiral.hashCode() : 0);
		result = 31 * result + (currentLeader != null ? currentLeader.hashCode() : 0);
		result = 31 * result + (fleets != null ? fleets.hashCode() : 0);
		return result;
	}
}
