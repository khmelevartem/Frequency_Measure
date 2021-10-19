package com.tubetoast.frequencymeasure.presentation.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tubetoast.frequencymeasure.R
import com.tubetoast.frequencymeasure.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil
            .setContentView<FragmentSettingsBinding>(requireActivity(), R.layout.fragment_settings)
    }
}