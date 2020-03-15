package com.zaycode.mvvm.ui

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

import com.zaycode.mvvm.R

class SplashFragment : Fragment(R.layout.splash_fragment){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_homeFragment)
        }, 2000L)
    }
}