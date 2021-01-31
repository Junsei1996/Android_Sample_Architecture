package com.example.androidbaseapplication.ui.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.example.androidbaseapplication.R
import com.example.androidbaseapplication.databinding.ActivityMainBinding
import com.example.androidbaseapplication.viewModels.MainActivityViewModel

class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainActivityViewModel
    private lateinit var mNavController: NavController
    private lateinit var mNavDestination: NavDestination

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        init()

    }

    private fun init() {
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        initNavController()
        observe()
    }

    private fun observe() {


    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun initNavController() {

        mNavController = findNavController(R.id.nav_host_fragment)

        mNavController.apply {
            addOnDestinationChangedListener { _, destination, _ ->
                mNavDestination = destination
            }
        }

    }

    override fun getActivityLayout(): Int {
        return R.layout.activity_main
    }

    override fun getViewBinding() {
        mBinding = binding as ActivityMainBinding
    }

}