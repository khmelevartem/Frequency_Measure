package com.tubetoast.frequencymeasure.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tubetoast.frequencymeasure.R
import com.tubetoast.frequencymeasure.databinding.FragmentMainBinding
import com.tubetoast.frequencymeasure.di.appComponent
import com.tubetoast.frequencymeasure.presentation.utils.*
import com.tubetoast.frequencymeasure.presentation.viewmodel.MainFragmentViewModel
import com.tubetoast.frequencymeasure.presentation.viewmodel.factories.MainFragmentViewModelFactory
import javax.inject.Inject

class MainFragment : AbstractBindingFragment<FragmentMainBinding>() {

    @Inject
    lateinit var factory: MainFragmentViewModelFactory
    private val viewModel: MainFragmentViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireContext().appComponent.inject(this)
        return FragmentMainBinding.inflate(layoutInflater, container, false)
            .apply {
                lifecycleOwner = fragment
                viewModel = fragment.viewModel
                navigateOnClick(btnSettings, R.id.main_to_settings)
                navigateWithExplosionOnClick(btnStats, R.id.main_to_stats, circle)
            }.root
    }
}