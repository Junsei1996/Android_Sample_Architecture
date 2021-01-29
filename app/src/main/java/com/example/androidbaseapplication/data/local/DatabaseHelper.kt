package com.example.androidbaseapplication.data.local

import com.example.androidbaseapplication.models.entity.SampleEntity

interface DatabaseHelper {

    suspend fun insert(users: SampleEntity)

}