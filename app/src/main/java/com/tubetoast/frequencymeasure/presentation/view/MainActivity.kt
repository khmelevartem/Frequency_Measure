package com.tubetoast.frequencymeasure.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tubetoast.frequencymeasure.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater)
    }

}