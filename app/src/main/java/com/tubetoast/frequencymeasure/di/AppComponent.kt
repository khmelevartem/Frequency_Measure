package com.tubetoast.frequencymeasure.di

import android.content.Context
import androidx.room.Room
import com.tubetoast.frequencymeasure.data.cache.SharedPrefsStateCache
import com.tubetoast.frequencymeasure.data.cache.StateCache
import com.tubetoast.frequencymeasure.data.db.room.RoomDB
import com.tubetoast.frequencymeasure.data.db.room.dao.SeanceDao
import com.tubetoast.frequencymeasure.domain.SeanceIntearactor
import com.tubetoast.frequencymeasure.domain.SeanceIntearactorImpl
import com.tubetoast.frequencymeasure.domain.StateInteractor
import com.tubetoast.frequencymeasure.domain.StateInteractorImpl
import com.tubetoast.frequencymeasure.presentation.App
import com.tubetoast.frequencymeasure.presentation.view.MainFragment
import com.tubetoast.frequencymeasure.presentation.viewmodel.ButtonsFragmentViewModelFactory
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(
    modules = [InteractorsModule::class, AppModule::class, DatabaseModule::class]
)
interface AppComponent {
    fun inject(mainFragment: MainFragment)
}

@Module
class InteractorsModule {
    @Singleton
    @Provides
    fun mainViewModelFactory(interactor: StateInteractor): ButtonsFragmentViewModelFactory =
        ButtonsFragmentViewModelFactory(interactor)

    @Singleton
    @Provides
    fun seanceInteractor(db: RoomDB): SeanceIntearactor =
        SeanceIntearactorImpl(db)

    @Singleton
    @Provides
    fun stateInteractor(cache: StateCache, saver: SeanceIntearactor): StateInteractor =
        StateInteractorImpl(cache, saver)

}

@Module
class DatabaseModule{

    @Singleton
    @Provides
    fun stateCache(context: Context): StateCache =
        SharedPrefsStateCache(context)

    @Singleton
    @Provides
    fun db(context: Context): RoomDB {
        return Room.databaseBuilder(context, RoomDB::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun seanceDao(db: RoomDB) : SeanceDao = db.seanceDao

    companion object {
        private const val DB_NAME = "freqmeasdb.db"
    }
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