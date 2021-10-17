package com.tubetoast.frequencymeasure.domain

import android.util.Log
import com.tubetoast.frequencymeasure.models.Seance

class SeanceSaverIntearactorImpl : SeanceSaverIntearactor {
    private val seances = ArrayList<Seance>()
    override fun save(seance: Seance) {
        seances.add(seance)
        Log.e("Saved", seance.toString())
    }


}