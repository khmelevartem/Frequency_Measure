package com.tubetoast.frequencymeasure.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tubetoast.frequencymeasure.R
import com.tubetoast.frequencymeasure.databinding.FragmentStatsBinding
import com.tubetoast.frequencymeasure.presentation.utils.fragment
import com.tubetoast.frequencymeasure.presentation.utils.navigateOnClick
import com.tubetoast.frequencymeasure.presentation.viewmodel.StatsFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatsFragment : AbstractBindingFragment<FragmentStatsBinding>() {

    private val statsVM : StatsFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentStatsBinding.inflate(layoutInflater, container, false)
            .save()
            .apply {
                lifecycleOwner = fragment
                viewModel = fragment.statsVM
                navigateOnClick(btnSettings, R.id.stats_to_settings)
            }.root
    }

}