package com.example.androidbaseapplication.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample")
class SampleEntity {

    @PrimaryKey
    var id: Int = 0

}