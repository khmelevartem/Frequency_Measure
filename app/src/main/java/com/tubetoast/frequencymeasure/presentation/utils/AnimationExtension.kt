package com.tubetoast.frequencymeasure.presentation.utils

import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.tubetoast.frequencymeasure.R

fun View.startAnimation(animation: Animation, onEnd: () -> Unit) {
    animation.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) = Unit
        override fun onAnimationEnd(animation: Animation?) = onEnd()
        override fun onAnimationRepeat(animation: Animation?) = Unit
    })
    startAnimation(animation)
}

fun View.explode(onEnd: () -> Unit) {
    startAnimation(AnimationUtils.loadAnimation(context, R.anim.explosion_anim).apply {
        duration = 400
        interpolator = AccelerateInterpolator()
    }, onEnd)
}