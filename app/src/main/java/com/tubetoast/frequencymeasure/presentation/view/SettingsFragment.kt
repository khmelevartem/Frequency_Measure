package com.tubetoast.frequencymeasure.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tubetoast.frequencymeasure.R
import com.tubetoast.frequencymeasure.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentSettingsBinding.inflate(layoutInflater, container, false).root
    }
}