package com.zaycode.mvvm.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zaycode.mvvm.R
import com.zaycode.mvvm.MVVMViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment:Fragment(R.layout.fragment_home){
    private val vm:MVVMViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}