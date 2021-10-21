package com.tubetoast.frequencymeasure.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tubetoast.frequencymeasure.R
import com.tubetoast.frequencymeasure.databinding.FragmentStatsBinding
import com.tubetoast.frequencymeasure.di.appComponent
import com.tubetoast.frequencymeasure.presentation.utils.fragment
import com.tubetoast.frequencymeasure.presentation.utils.navigateOnClick
import com.tubetoast.frequencymeasure.presentation.viewmodel.StatsFragmentViewModel
import com.tubetoast.frequencymeasure.presentation.viewmodel.factories.StatsFragmentViewModelFactory
import javax.inject.Inject

class StatsFragment : BindingFragment<FragmentStatsBinding>() {

    @Inject
    lateinit var factory: StatsFragmentViewModelFactory
    private val viewModel by viewModels<StatsFragmentViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        requireContext().appComponent.inject(this)
        return FragmentStatsBinding.inflate(layoutInflater, container, false)
            .save()
            .apply {
                lifecycleOwner = fragment
                viewModel = fragment.viewModel
                navigateOnClick(btnSettings, R.id.stats_to_settings)
            }.root
    }

}