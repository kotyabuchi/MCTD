package com.github.kotyabuchi.mctd

import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MCTD: JavaPlugin() {

    override fun onEnable() {
        setupKoin()
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