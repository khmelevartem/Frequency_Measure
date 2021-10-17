package com.tubetoast.frequencymeasure.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.tubetoast.frequencymeasure.domain.StateInteractor

class ButtonsFragmentViewModel(
    private val stateInteractor: StateInteractor,
) : ViewModel() {

    private val seanceActive = MutableLiveData(stateInteractor.isActive)

    val startVisibility: LiveData<Int> get() = visibleIf(seanceActive.inverse())
    val finishVisibility: LiveData<Int> get() = visibleIf(seanceActive)

    fun start() {
        stateInteractor.activate()
        seanceActive.value = true
    }

    fun finish() {
        stateInteractor.deactivate()
        seanceActive.value = false
    }

    private fun visibleIf(liveData: LiveData<Boolean>) =
        Transformations.map(liveData) { if (it) View.VISIBLE else View.GONE }

    private fun LiveData<Boolean>.inverse() =
        Transformations.map(this) { !it }
}

