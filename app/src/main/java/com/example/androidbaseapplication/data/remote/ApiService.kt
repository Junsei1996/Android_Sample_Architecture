package com.example.androidbaseapplication.data.remote

import com.example.androidbaseapplication.models.response.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}