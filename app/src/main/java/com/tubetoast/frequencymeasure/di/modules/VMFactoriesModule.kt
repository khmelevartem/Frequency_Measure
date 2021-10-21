package com.tubetoast.frequencymeasure.di.modules

import com.tubetoast.frequencymeasure.domain.StateInteractor
import com.tubetoast.frequencymeasure.presentation.viewmodel.factories.MainFragmentViewModelFactory
import com.tubetoast.frequencymeasure.presentation.viewmodel.factories.StatsFragmentViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class VMFactoriesModule{
    @Singleton
    @Provides
    fun mainViewModelFactory(interactor: StateInteractor): MainFragmentViewModelFactory =
        MainFragmentViewModelFactory(interactor)

    @Singleton
    @Provides
    fun statsViewModelFactory(): StatsFragmentViewModelFactory =
        StatsFragmentViewModelFactory()

}