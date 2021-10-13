package com.sjs.lootbotga

import com.sjs.lootbotga.evolver.LootBotEvolver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val ctx: ApplicationContext = runApplication<Application>(*args)

    val lootBotEvolver = ctx.getBean(LootBotEvolver::class.java)

    lootBotEvolver.run()
}