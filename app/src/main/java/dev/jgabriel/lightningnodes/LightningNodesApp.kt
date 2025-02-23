package dev.jgabriel.lightningnodes

import android.app.Application
import dev.jgabriel.di.injectModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class LightningNodesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LightningNodesApp)
            injectModules()
        }
    }
}