package com.example.androidbaseapplication.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidbaseapplication.R
import com.example.androidbaseapplication.data.remote.ApiHelper
import com.example.androidbaseapplication.data.remote.RetrofitBuilder
import com.example.androidbaseapplication.models.response.User
import com.example.androidbaseapplication.utils.Enums
import com.example.androidbaseapplication.utils.ViewModelFactory
import com.example.androidbaseapplication.viewModels.MainViewModel

class SampleActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {


    }

    private fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Enums.Status.SUCCESS -> {
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    Enums.Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Enums.Status.LOADING -> {

                    }
                }
            }
        })
    }

    private fun retrieveList(users: List<User>) {

    }
}