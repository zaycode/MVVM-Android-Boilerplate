package com.zaycode.mvvm.ui

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.zaycode.mvvm.MVVMViewModel

import com.zaycode.mvvm.R
import org.koin.android.viewmodel.ext.android.viewModel

class InboxFragment : Fragment(R.layout.splash_fragment){
    private val vm: MVVMViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}