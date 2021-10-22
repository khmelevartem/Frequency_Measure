package com.tubetoast.frequencymeasure.presentation.view.fragments

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class AbstractBindingFragment<VB : ViewDataBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun VB.save() = also {
        _binding = it
    }

}