package com.sjs.lootbotga.evolver;

import org.springframework.stereotype.Component;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 19:57
 */
@Component
public interface LootBotEvolver {
	public void run();

	void setGenerationCount(int generationCount);
	void setGenerationSize(int generationSize);
}
