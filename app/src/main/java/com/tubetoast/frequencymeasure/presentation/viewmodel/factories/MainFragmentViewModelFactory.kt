package com.tubetoast.frequencymeasure.presentation.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tubetoast.frequencymeasure.domain.StateInteractor
import com.tubetoast.frequencymeasure.presentation.viewmodel.MainFragmentViewModel

class MainFragmentViewModelFactory(
    private val stateInteractor: StateInteractor,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainFragmentViewModel(stateInteractor) as T
    }
}
