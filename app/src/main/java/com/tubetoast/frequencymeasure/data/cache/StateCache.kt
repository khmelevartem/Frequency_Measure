package com.tubetoast.frequencymeasure.data.cache

import java.util.*

interface StateCache {
    fun getStart(): Date?
    fun saveStart(start: Date)
    fun eraseStart()
}