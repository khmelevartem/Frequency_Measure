package com.tubetoast.frequencymeasure.di.modules

import com.tubetoast.frequencymeasure.data.cache.StateCache
import com.tubetoast.frequencymeasure.data.db.room.RoomDB
import com.tubetoast.frequencymeasure.domain.SeanceIntearactor
import com.tubetoast.frequencymeasure.domain.SeanceIntearactorImpl
import com.tubetoast.frequencymeasure.domain.StateInteractor
import com.tubetoast.frequencymeasure.domain.StateInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorsModule {

    @Singleton
    @Provides
    fun seanceInteractor(db: RoomDB): SeanceIntearactor =
        SeanceIntearactorImpl(db)

    @Singleton
    @Provides
    fun stateInteractor(cache: StateCache, saver: SeanceIntearactor): StateInteractor =
        StateInteractorImpl(cache, saver)

}