package com.example.androidbaseapplication.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.androidbaseapplication.R

abstract class BaseActivity: AppCompatActivity() {

    protected lateinit var binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private fun init() {

        binding = DataBindingUtil.setContentView(this, getActivityLayout())

        getViewBinding()

    }

    abstract fun getActivityLayout(): Int

    abstract fun getViewBinding()

}