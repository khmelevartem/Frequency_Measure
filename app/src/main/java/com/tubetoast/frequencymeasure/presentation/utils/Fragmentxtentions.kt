package com.tubetoast.frequencymeasure.presentation.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tubetoast.frequencymeasure.R

fun Fragment.navigateOnClick(view: View, @IdRes id: Int){
    view.setOnClickListener{
        findNavController().navigate(id)
    }
}

fun Fragment.navigateWithExplosionOnClick(view: View, @IdRes id: Int, explodingVew: View = view){
    view.setOnClickListener{
        it.visibility = View.INVISIBLE
        explodingVew.visibility = View.VISIBLE
        explodingVew.explode{
            findNavController().navigate(id)
            explodingVew.visibility = View.INVISIBLE
        }
    }
}

fun Fragment.navigateBackOnClick(view: View){
    view.setOnClickListener{
        findNavController().popBackStack()
    }
}

val <F : Fragment> F.fragment : F get() = this