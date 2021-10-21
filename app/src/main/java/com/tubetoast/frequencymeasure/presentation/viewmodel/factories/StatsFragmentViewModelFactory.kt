package com.tubetoast.frequencymeasure.presentation.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tubetoast.frequencymeasure.presentation.viewmodel.StatsFragmentViewModel

class StatsFragmentViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StatsFragmentViewModel() as T
    }
}