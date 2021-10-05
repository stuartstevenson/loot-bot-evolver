package com.sjs.lootbotga.game.player;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PlayerTest {

    @Test
	public void testEquals() {
		PlayerImpl player1 = new PlayerImpl();
		PlayerImpl player2 = new PlayerImpl();

		player1.setId(101);
		player2.setId(101);

		assertThat(player1).isEqualTo(player2);
	}

    @Test
	
	public void testNotEquals() {
		PlayerImpl player1 = new PlayerImpl();
		PlayerImpl player2 = new PlayerImpl();

		player1.setId(101);
		player2.setId(102);

		assertThat(player1).isNotEqualTo(player2);
	}
}
