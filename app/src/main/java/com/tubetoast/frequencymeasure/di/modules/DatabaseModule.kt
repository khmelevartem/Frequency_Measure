package com.tubetoast.frequencymeasure.di.modules

import android.content.Context
import androidx.room.Room
import com.tubetoast.frequencymeasure.data.cache.SharedPrefsStateCache
import com.tubetoast.frequencymeasure.data.cache.StateCache
import com.tubetoast.frequencymeasure.data.db.room.RoomDB
import com.tubetoast.frequencymeasure.data.db.room.dao.SeanceDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

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
    fun seanceDao(db: RoomDB): SeanceDao = db.seanceDao

    companion object {
        private const val DB_NAME = "freqmeasdb.db"
    }
}
