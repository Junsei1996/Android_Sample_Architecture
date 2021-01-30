package com.example.androidbaseapplication.utils

import android.content.Context

object ContextModule {

    private lateinit var mContext: Context

    val context: Context
        get() = mContext

    fun initialize(context: Context) {
        mContext = context
    }

}