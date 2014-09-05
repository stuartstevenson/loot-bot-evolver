package com.sjs.lootbotga.evolver;

import org.springframework.stereotype.Component;

@Component
public interface LootBotEvolver {
	public void run();

	void setGenerationCount(int generationCount);
	void setGenerationSize(int generationSize);
}
