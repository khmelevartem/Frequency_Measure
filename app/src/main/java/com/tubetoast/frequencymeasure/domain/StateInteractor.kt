package com.tubetoast.frequencymeasure.domain

interface StateInteractor {
    fun activate()
    fun deactivate()
    val isActive: Boolean
}