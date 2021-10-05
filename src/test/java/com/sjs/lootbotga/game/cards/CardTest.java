package com.sjs.lootbotga.game.cards;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CardTest  {
    @Test
	public void testEquals() {
		Card card1 = new AdmiralCardBuilder().build();
		Card card2 = new AdmiralCardBuilder().build();
		assertThat(card1).isEqualTo(card2);
	}

    @Test
	public void testCardTypeNotEquals() {
		Card card1 = new PirateCardBuilder().build();
		Card card2 = new CaptainCardBuilder().build();

		assertThat(card1).isNotEqualTo(card2);
	}

    @Test
	public void testFleetTypeNotEquals() {
		Card card1 = new PirateCardBuilder().fleet(FleetType.BLUE).build();
		Card card2 = new PirateCardBuilder().fleet(FleetType.GREEN).build();

		assertThat(card1).isNotEqualTo(card2);
	}

    @Test
	public void testCardValueEquals() {
		Card card1 = new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.ONE).build();
		Card card2 = new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.ONE).build();

		assertThat(card1).isEqualTo(card2);
	}

    @Test
	public void testCardValueNotEquals() {
		Card card1 = new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.ONE).build();
		Card card2 = new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.TWO).build();

		assertThat(card1).isNotEqualTo(card2);
	}
}