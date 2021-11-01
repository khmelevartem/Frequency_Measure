package com.tubetoast.frequencymeasure.domain

import com.tubetoast.frequencymeasure.data.db.room.RoomDB
import com.tubetoast.frequencymeasure.data.db.room.entities.toRoomEntity
import com.tubetoast.frequencymeasure.models.Seance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SeanceInteractorImpl(
    private val db: RoomDB,
) : SeanceIntearactor {
    override fun save(seance: Seance) {
        GlobalScope.launch(Dispatchers.IO) {
            db.seanceDao.insert(seance.toRoomEntity())
        }
    }

}