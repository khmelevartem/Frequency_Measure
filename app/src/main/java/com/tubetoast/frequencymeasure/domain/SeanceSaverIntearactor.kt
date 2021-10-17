package com.tubetoast.frequencymeasure.domain

import com.tubetoast.frequencymeasure.models.Seance

interface SeanceSaverIntearactor {
    fun save(seance: Seance)
}