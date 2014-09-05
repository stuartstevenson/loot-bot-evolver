package com.sjs.lootbotga.game.cards;

public enum PirateValue implements CardValue{
	ONE (1,2),
	TWO (2,4),
	THREE (3,4),
	FOUR (4,2);

	private Integer value;
	private Integer amount;

	private PirateValue(Integer value, Integer amount) {
		this.value = value;
		this.amount = amount;
	}

	public Integer getValue() {
		return value;
	}

	public Integer getAmount() {
		return amount;
	}
}
