package com.sjs.lootbotga.game.cards;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CardTest  {
    @Test
	public void testEquals() {
		Card card1 = new Card();
		Card card2 = new Card();
		card1.setCardType(CardType.ADMIRAL);
		card2.setCardType(CardType.ADMIRAL);
		card1.setFleetType(null);
		card2.setFleetType(null);
		card1.setValue(null);
		card2.setValue(null);
		assertThat(card1).isEqualTo(card2);
	}

    @Test
	public void testCardTypeNotEquals() {
		Card card1 = new Card();
		Card card2 = new Card();

		card1.setCardType(CardType.PIRATE);
		card2.setCardType(CardType.CAPTAIN);

		assertThat(card1).isNotEqualTo(card2);
	}

    @Test
	public void testFleetTypeNotEquals() {
		Card card1 = new Card();
		Card card2 = new Card();

		card1.setCardType(CardType.PIRATE);
		card2.setCardType(CardType.PIRATE);

		card1.setFleetType(FleetType.BLUE);
		card2.setFleetType(FleetType.GREEN);

		assertThat(card1).isNotEqualTo(card2);
	}

    @Test
	public void testCardValueEquals() {
		Card card1 = new Card();
		Card card2 = new Card();

		card1.setCardType(CardType.PIRATE);
		card2.setCardType(CardType.PIRATE);

		card1.setFleetType(FleetType.BLUE);
		card2.setFleetType(FleetType.BLUE);

		card1.setValue(PirateValue.ONE);
		card2.setValue(PirateValue.ONE);

		assertThat(card1).isEqualTo(card2);
	}

    @Test
	public void testCardValueNotEquals() {
		Card card1 = new Card();
		Card card2 = new Card();

		card1.setCardType(CardType.PIRATE);
		card2.setCardType(CardType.PIRATE);

		card1.setFleetType(FleetType.BLUE);
		card2.setFleetType(FleetType.BLUE);

		card1.setValue(PirateValue.ONE);
		card2.setValue(PirateValue.TWO);

		assertThat(card1).isNotEqualTo(card2);
	}
}