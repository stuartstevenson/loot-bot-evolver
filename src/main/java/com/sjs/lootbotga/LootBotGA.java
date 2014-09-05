package com.sjs.lootbotga;

import com.sjs.lootbotga.evolver.LootBotEvolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LootBotGA {
	@Autowired
	private LootBotEvolver lootBotEvolver;

    @Value("${loot.generation.count}")
    public int generationCount;

    @Value("${loot.generation.size}")
    public int generationSize;

	public void run() {
		lootBotEvolver.setGenerationCount(generationCount);
		//multiple of 4 for now
		lootBotEvolver.setGenerationSize(generationSize);
		lootBotEvolver.run();
	}

}