package com.tubetoast.frequencymeasure.presentation.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigateOnClick(view: View, @IdRes id: Int){
    view.setOnClickListener{
        findNavController().navigate(id)
    }
}

fun Fragment.navigateBackOnClick(view: View){
    view.setOnClickListener{
        findNavController().popBackStack()
    }
}

val <F : Fragment> F.fragment : F get() = this