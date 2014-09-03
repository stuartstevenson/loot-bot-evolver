package com.sjs.lootbotga;

import com.sjs.lootbotga.evolver.LootBotEvolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * User: StuartS
 * Date: 26/03/12
 * Time: 19:53
 */
@Component
public class LootBotGA {
	@Autowired
	private LootBotEvolver lootBotEvolver;

	private void run() {
		lootBotEvolver.setGenerationCount(10);
		//multiple of 4 for now
		lootBotEvolver.setGenerationSize(16);
		lootBotEvolver.run();
	}

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("C:\\_stu_projects\\LootBotGA\\src\\applicationContext.xml");
		LootBotGA lootBotGA = (LootBotGA) context.getBean("lootBotGA");
		lootBotGA.run();
	}

}
