package com.tubetoast.frequencymeasure.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.tubetoast.frequencymeasure.domain.StateInteractor

class MainFragmentViewModel(
    private val stateInteractor: StateInteractor,
) : BaseViewModel() {

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

    private fun visibleIf(condition: LiveData<Boolean>) =
        Transformations.map(condition) { isTrue -> if (isTrue) View.VISIBLE else View.GONE }

    private fun LiveData<Boolean>.inverse() =
        Transformations.map(this) { isTrue -> !isTrue }
}

