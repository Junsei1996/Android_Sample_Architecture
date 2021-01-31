package com.example.androidbaseapplication.utils

import android.view.View

interface FragmentMethods : View.OnClickListener {

    fun initializeViewBinding()

    fun initializeViewModel()

    fun setClickListeners()

    fun setListeners()

    fun setObservers()

    fun getViewResource(): Int

    fun setViews()

}