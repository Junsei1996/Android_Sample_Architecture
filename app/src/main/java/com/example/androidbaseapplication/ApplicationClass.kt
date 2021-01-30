package com.example.androidbaseapplication

import android.app.Application
import com.example.androidbaseapplication.utils.ContextModule

class ApplicationClass : Application() {

    override fun onCreate() {

        super.onCreate()
        mApplicationClass = this
        ContextModule.initialize(this.applicationContext)

    }

    companion object {

        @JvmStatic
        private lateinit var mApplicationClass: ApplicationClass

        @JvmStatic
        val application: ApplicationClass by lazy { mApplicationClass }

    }

}