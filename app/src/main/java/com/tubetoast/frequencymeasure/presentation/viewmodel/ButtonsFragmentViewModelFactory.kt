package com.tubetoast.frequencymeasure.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tubetoast.frequencymeasure.domain.StateInteractor

class ButtonsFragmentViewModelFactory(
    val stateInteractor: StateInteractor,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ButtonsFragmentViewModel(stateInteractor) as T
    }
}
