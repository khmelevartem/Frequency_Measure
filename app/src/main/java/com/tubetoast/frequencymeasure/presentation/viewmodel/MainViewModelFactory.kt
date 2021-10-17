package com.tubetoast.frequencymeasure.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tubetoast.frequencymeasure.domain.StateInteractor

class MainViewModelFactory(
    val stateInteractor: StateInteractor,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(stateInteractor) as T
    }
}
