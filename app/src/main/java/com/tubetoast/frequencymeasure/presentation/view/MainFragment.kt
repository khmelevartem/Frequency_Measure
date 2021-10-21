package com.tubetoast.frequencymeasure.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tubetoast.frequencymeasure.R
import com.tubetoast.frequencymeasure.databinding.FragmentMainBinding
import com.tubetoast.frequencymeasure.di.appComponent
import com.tubetoast.frequencymeasure.presentation.utils.navigateOnClick
import com.tubetoast.frequencymeasure.presentation.viewmodel.ButtonsFragmentViewModel
import com.tubetoast.frequencymeasure.presentation.viewmodel.ButtonsFragmentViewModelFactory
import javax.inject.Inject

class MainFragment : Fragment() {

    private val fragment get() = this
    @Inject
    lateinit var factory: ButtonsFragmentViewModelFactory
    private val viewModel: ButtonsFragmentViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().appComponent.inject(this)
        return  FragmentMainBinding.inflate(layoutInflater, container, false)
            .apply {
                lifecycleOwner = fragment
                viewModel = fragment.viewModel
                navigateOnClick(btnSettings, R.id.main_to_settings)
                navigateOnClick(btnStats, R.id.main_to_stats)
            }.root
    }
}