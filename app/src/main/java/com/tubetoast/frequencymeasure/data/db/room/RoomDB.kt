package com.tubetoast.frequencymeasure.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tubetoast.frequencymeasure.data.db.room.dao.SeanceDao
import com.tubetoast.frequencymeasure.data.db.room.entities.SeanceRE

@Database(entities = [SeanceRE::class], version = 1)
abstract class RoomDB : RoomDatabase() {
    abstract val seanceDao: SeanceDao
}