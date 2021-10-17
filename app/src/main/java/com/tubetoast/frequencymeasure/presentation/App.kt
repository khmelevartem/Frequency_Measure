package com.tubetoast.frequencymeasure.presentation

import android.app.Application
import com.tubetoast.frequencymeasure.di.AppComponent
import com.tubetoast.frequencymeasure.di.AppModule
import com.tubetoast.frequencymeasure.di.InteractorsModule
import com.tubetoast.frequencymeasure.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent : AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .build()
    }
}