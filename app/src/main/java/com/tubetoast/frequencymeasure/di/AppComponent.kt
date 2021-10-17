package com.tubetoast.frequencymeasure.di

import android.content.Context
import com.tubetoast.frequencymeasure.data.cache.SharedPrefsStateCache
import com.tubetoast.frequencymeasure.data.cache.StateCache
import com.tubetoast.frequencymeasure.domain.SeanceSaverIntearactor
import com.tubetoast.frequencymeasure.domain.SeanceSaverIntearactorImpl
import com.tubetoast.frequencymeasure.domain.StateInteractor
import com.tubetoast.frequencymeasure.domain.StateInteractorImpl
import com.tubetoast.frequencymeasure.presentation.App
import com.tubetoast.frequencymeasure.presentation.view.MainActivity
import com.tubetoast.frequencymeasure.presentation.viewmodel.MainViewModelFactory
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [InteractorsModule::class, AppModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}

@Module
class InteractorsModule {
    @Provides
    fun mainViewModelFactory(interactor: StateInteractor): MainViewModelFactory =
        MainViewModelFactory(interactor)

    @Provides
    fun seanceSaverInteractor(): SeanceSaverIntearactor =
        SeanceSaverIntearactorImpl()

    @Provides
    fun stateInteractor(cache: StateCache, saver: SeanceSaverIntearactor): StateInteractor =
        StateInteractorImpl(cache, saver)

    @Provides
    fun stateCache(context: Context): StateCache =
        SharedPrefsStateCache(context)

}

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }