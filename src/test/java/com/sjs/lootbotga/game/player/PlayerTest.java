package com.sjs.lootbotga.game.player;

import junit.framework.TestCase;

/**
 * User: StuartS
 * Date: 01/04/12
 * Time: 10:32
 */
public class PlayerTest extends TestCase{
	public void testEquals() {
		PlayerImpl player1 = new PlayerImpl();
		PlayerImpl player2 = new PlayerImpl();

		player1.setId(101);
		player2.setId(101);

		assertTrue(player1.equals(player2));
	}
	
	public void testNotEquals() {
		PlayerImpl player1 = new PlayerImpl();
		PlayerImpl player2 = new PlayerImpl();

		player1.setId(101);
		player2.setId(102);

		assertFalse(player1.equals(player2));
	}
}
