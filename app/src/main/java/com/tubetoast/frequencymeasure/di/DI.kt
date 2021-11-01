package com.tubetoast.frequencymeasure.di

import androidx.room.Room
import com.tubetoast.frequencymeasure.data.cache.SharedPrefsStateCache
import com.tubetoast.frequencymeasure.data.cache.StateCache
import com.tubetoast.frequencymeasure.data.db.room.RoomDB
import com.tubetoast.frequencymeasure.domain.SeanceIntearactor
import com.tubetoast.frequencymeasure.domain.SeanceInteractorImpl
import com.tubetoast.frequencymeasure.domain.StateInteractor
import com.tubetoast.frequencymeasure.domain.StateInteractorImpl
import com.tubetoast.frequencymeasure.presentation.viewmodel.MainFragmentViewModel
import com.tubetoast.frequencymeasure.presentation.viewmodel.StatsFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val interactors = module {
    single<SeanceIntearactor> { SeanceInteractorImpl(get()) }
    single<StateInteractor> { StateInteractorImpl(get(), get()) }
}

val database = module{
    single { Room.databaseBuilder(androidContext(), RoomDB::class.java, DB_NAME)
        .fallbackToDestructiveMigration()
        .build() }
    single<StateCache> { SharedPrefsStateCache(androidContext()) }
}

val viewModels = module{
    factory { MainFragmentViewModel(get()) }
    factory { StatsFragmentViewModel() }
}


private const val DB_NAME = "freqmeasdb.db"
