package com.example.androidbaseapplication.data.local

import com.example.androidbaseapplication.models.entity.SampleEntity

class DatabaseImpl(private val appDb: AppDb) : DatabaseHelper {
    override suspend fun insert(users: SampleEntity) = appDb.userDao().insert(users)
}