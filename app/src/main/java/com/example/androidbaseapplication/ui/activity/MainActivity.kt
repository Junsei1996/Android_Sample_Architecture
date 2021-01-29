package com.example.androidbaseapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidbaseapplication.R

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}