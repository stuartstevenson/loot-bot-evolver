package com.sjs.lootbotga.game.cards;

public enum MerchantValue implements CardValue{
	TWO (2,5),
	THREE (3,6),
	FOUR (4,5),
	FIVE (5,5),
	SIX (6,2),
	SEVEN (7,1),
	EIGHT (8,1);
	
	private Integer value;
	private Integer amount;

	private MerchantValue(Integer value, Integer amount) {
		this.value = value;
		this.amount  = amount;
	}

	public Integer getValue() {
		return value;
	}

	public Integer getAmount() {
		return amount;
	}
}
