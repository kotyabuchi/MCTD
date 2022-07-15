package com.github.kotyabuchi.mctd

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MCTD: JavaPlugin() {

    private val events: List<Listener> = listOf(
    )

    private fun registerEvents() {
        events.forEach { event ->
            server.pluginManager.registerEvents(event, this)
        }
    }

    override fun onEnable() {
        setupKoin()
        if (!dataFolder.exists()) dataFolder.mkdirs()
        registerEvents()
    }

    override fun onDisable() {
    }

    private val pluginModule = module {
        single { this@MCTD }
    }

    private fun setupKoin() {
        startKoin {
            modules(pluginModule)
        }
    }
}