package com.tubetoast.frequencymeasure.presentation.view

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BindingFragment<VB : ViewDataBinding>  : Fragment() {

    protected var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun VB.save() = also{
        _binding = it
    }

}