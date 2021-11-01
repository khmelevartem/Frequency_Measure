package com.tubetoast.frequencymeasure.presentation

import android.app.Application
import com.tubetoast.frequencymeasure.di.database
import com.tubetoast.frequencymeasure.di.interactors
import com.tubetoast.frequencymeasure.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidFileProperties()
            modules(listOf(interactors, database, viewModels))
        }
    }
}