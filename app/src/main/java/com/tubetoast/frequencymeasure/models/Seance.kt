package com.tubetoast.frequencymeasure.models

import java.util.*

data class Seance(
    val start: Date,
    val finish: Date,
) {
    val lengthInMillis: Long get() = finish.time - start.time
}