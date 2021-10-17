package com.tubetoast.frequencymeasure.domain

import com.tubetoast.frequencymeasure.models.Seance

interface SeanceIntearactor {
    fun save(seance: Seance)
}