package com.tubetoast.frequencymeasure.data.db.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tubetoast.frequencymeasure.models.Seance
import java.util.*

@Entity
data class SeanceRE(
    val start: Long,
    val finish: Long,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    fun toSeance() = Seance(Date(start), Date(finish))
}

fun Seance.toRoomEntity() = SeanceRE(start.time, finish.time)