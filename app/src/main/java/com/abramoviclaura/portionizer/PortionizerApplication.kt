package com.abramoviclaura.portionizer

import android.app.Application
import com.abramoviclaura.portionizer.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PortionizerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            androidLogger()
            androidContext(this@PortionizerApplication)
            modules(appModule)
        }
    }
}
