package com.example.androidbaseapplication.data.remote

import com.example.androidbaseapplication.utils.Enums.Status
import com.example.androidbaseapplication.utils.Enums.Status.SUCCESS
import com.example.androidbaseapplication.utils.Enums.Status.ERROR
import com.example.androidbaseapplication.utils.Enums.Status.LOADING

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> = Resource(status = LOADING, data = data, message = null)
    }
}