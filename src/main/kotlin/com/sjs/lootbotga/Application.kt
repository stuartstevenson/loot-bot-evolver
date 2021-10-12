package com.sjs.lootbotga

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val ctx: ApplicationContext = runApplication<Application>(*args)

    val lootBotGA = ctx.getBean(LootBotGA::class.java)

    lootBotGA.run()
}