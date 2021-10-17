package com.tubetoast.frequencymeasure.domain

import com.tubetoast.frequencymeasure.data.cache.StateCache
import com.tubetoast.frequencymeasure.models.Seance
import java.util.*

class StateInteractorImpl(
    private val cache: StateCache,
    private val seanceInteractor: SeanceIntearactor
) : StateInteractor {

    private val start: Date? get() = cache.getStart()

    override fun activate() {
        cache.saveStart(currentTime())
    }

    override fun deactivate() {
        start?.let{ start ->
            val finish = currentTime()
            seanceInteractor.save(Seance(start, finish))
        }
        cache.eraseStart()
    }

    override val isActive: Boolean get() = start != null

    private fun currentTime(): Date = Calendar.getInstance().time
}