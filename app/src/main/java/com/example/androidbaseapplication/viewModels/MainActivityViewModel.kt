package com.example.androidbaseapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.androidbaseapplication.data.remote.MainRepository
import com.example.androidbaseapplication.data.remote.Resource
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel() : ViewModel() {

    private lateinit var mainRepository: MainRepository

    constructor(mainRepository: MainRepository) : this() {
        this.mainRepository = mainRepository
    }

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}