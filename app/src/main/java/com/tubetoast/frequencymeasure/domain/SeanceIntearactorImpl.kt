package com.tubetoast.frequencymeasure.domain

import com.tubetoast.frequencymeasure.data.db.room.RoomDB
import com.tubetoast.frequencymeasure.data.db.room.entities.toRoomEntity
import com.tubetoast.frequencymeasure.models.Seance

class SeanceIntearactorImpl(
    private val db: RoomDB,
) : SeanceIntearactor {
    override fun save(seance: Seance) {
        Thread {
            db.seanceDao.insert(seance.toRoomEntity())
        }.start()
    }

}