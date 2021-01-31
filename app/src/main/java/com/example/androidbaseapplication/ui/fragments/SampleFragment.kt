package com.example.androidbaseapplication.ui.fragments

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidbaseapplication.R
import com.example.androidbaseapplication.databinding.FragmentSampleFragmentBinding
import com.example.androidbaseapplication.viewModels.MainActivityViewModel

class SampleFragment : BaseFragment() {

    private lateinit var mBinding: FragmentSampleFragmentBinding
    private lateinit var mViewModel: MainActivityViewModel

    override fun initializeViewBinding() {
        mBinding = binding as FragmentSampleFragmentBinding
    }

    override fun initializeViewModel() {
        mViewModel = ViewModelProviders.of(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun setClickListeners() {

    }

    override fun setListeners() {

    }

    override fun setObservers() {

        mViewModel.getUsers().observe(this, Observer {


        })

    }

    override fun getViewResource(): Int {
        return R.layout.fragment_sample_fragment
    }

    override fun setViews() {
    }

    override fun onClick(p0: View?) {

    }
}