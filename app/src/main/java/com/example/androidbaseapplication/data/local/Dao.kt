package com.example.androidbaseapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import com.example.androidbaseapplication.models.entity.SampleEntity

@Dao
interface Dao {

    @Insert
    fun insert(entity: SampleEntity)

}