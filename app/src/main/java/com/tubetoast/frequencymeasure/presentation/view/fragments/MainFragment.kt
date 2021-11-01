package com.tubetoast.frequencymeasure.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tubetoast.frequencymeasure.R
import com.tubetoast.frequencymeasure.databinding.FragmentMainBinding
import com.tubetoast.frequencymeasure.presentation.utils.*
import com.tubetoast.frequencymeasure.presentation.viewmodel.MainFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : AbstractBindingFragment<FragmentMainBinding>() {

    private val mainVM: MainFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainBinding.inflate(layoutInflater, container, false)
            .apply {
                lifecycleOwner = fragment
                viewModel = fragment.mainVM
                navigateOnClick(btnSettings, R.id.main_to_settings)
                navigateWithExplosionOnClick(btnStats, R.id.main_to_stats, circle)
            }.root
    }
}