package com.sjs.lootbotga.game.player;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    @Test
	public void testEquals() {
		PlayerImpl player1 = new PlayerImpl();
		PlayerImpl player2 = new PlayerImpl();

		player1.setId(101);
		player2.setId(101);

		assertTrue(player1.equals(player2));
	}

    @Test
	
	public void testNotEquals() {
		PlayerImpl player1 = new PlayerImpl();
		PlayerImpl player2 = new PlayerImpl();

		player1.setId(101);
		player2.setId(102);

		assertFalse(player1.equals(player2));
	}
}
