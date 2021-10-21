package com.tubetoast.frequencymeasure.di

import android.content.Context
import com.tubetoast.frequencymeasure.di.modules.AppModule
import com.tubetoast.frequencymeasure.di.modules.DatabaseModule
import com.tubetoast.frequencymeasure.di.modules.InteractorsModule
import com.tubetoast.frequencymeasure.di.modules.VMFactoriesModule
import com.tubetoast.frequencymeasure.presentation.App
import com.tubetoast.frequencymeasure.presentation.view.MainFragment
import com.tubetoast.frequencymeasure.presentation.view.SettingsFragment
import com.tubetoast.frequencymeasure.presentation.view.StatsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        VMFactoriesModule::class,
        InteractorsModule::class,
        AppModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    fun inject(mainFragment: MainFragment)
    fun inject(statsFragment: StatsFragment)
    fun inject(settingsFragment: SettingsFragment)
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }