package com.example.androidbaseapplication.data.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface Dao{

    @Insert
    fun insert()

}