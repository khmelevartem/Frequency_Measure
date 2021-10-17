package com.tubetoast.frequencymeasure.data.db.room.dao

import androidx.room.*
import com.tubetoast.frequencymeasure.data.db.room.entities.SeanceRE

@Dao
interface SeanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(seance: SeanceRE)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg seances: SeanceRE)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(seances: List<SeanceRE>)

    @Delete
    fun delete(seance: SeanceRE)

    @Delete
    fun delete(vararg seances: SeanceRE)

    @Delete
    fun delete(seances: List<SeanceRE>)

    @Query("SELECT * FROM SeanceRE")
    fun getAll(): List<SeanceRE>

//    @Query("SELECT * FROM SeanceRE WHERE ")
//    fun findForDateInterval(interval: ?): List<SeanceRE>
}