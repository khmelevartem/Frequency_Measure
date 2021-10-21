package com.tubetoast.frequencymeasure.presentation.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tubetoast.frequencymeasure.presentation.view.BindingFragment

fun Fragment.navigateOnClick(view: View, @IdRes id: Int){
    view.setOnClickListener{
        findNavController().navigate(id)
    }
}

val <F : Fragment> F.fragment : F get() = this