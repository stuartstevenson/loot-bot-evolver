package com.sjs.lootbotga.game.cards;

import org.springframework.stereotype.Component;

@Component
public class Card {
	private CardType cardType;
	private FleetType fleetType;
	private CardValue value;

	public Card() {
	}

    //todo Card builders

	public Card(CardType cardType, FleetType fleetType, CardValue value) {
		this.cardType = cardType;
		this.fleetType = fleetType;
		this.value = value;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public FleetType getFleetType() {
		return fleetType;
	}

	public void setFleetType(FleetType fleetType) {
		this.fleetType = fleetType;
	}

	public CardValue getValue() {
		return value;
	}

	public void setValue(CardValue value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Card{" +
				"cardType=" + (cardType != null ? cardType.toString() : "") +
				", fleetType=" + (fleetType != null ? fleetType.toString() : "") +
				", value=" + (value != null ? value : "") +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Card card = (Card) o;

		if (cardType != card.getCardType()) return false;
		if (fleetType != card.getFleetType()) return false;
		if (value != card.getValue()) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = cardType != null ? cardType.hashCode() : 0;
		result = 31 * result + (fleetType != null ? fleetType.hashCode() : 0);
		result = 31 * result + (value != null ? value.hashCode() : 0);
		return result;
	}
}
