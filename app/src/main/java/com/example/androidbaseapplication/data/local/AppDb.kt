package com.example.androidbaseapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidbaseapplication.models.entity.SampleEntity

@Database(entities = arrayOf(SampleEntity::class), version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun userDao(): Dao
}