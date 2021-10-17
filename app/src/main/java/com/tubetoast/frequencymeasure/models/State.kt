package com.tubetoast.frequencymeasure.models

sealed class State
object ActiveState : State()
object InactiveState : State()