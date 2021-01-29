package com.example.androidbaseapplication.data.local

import android.content.Context
import androidx.room.Room

class DatabaseBuilder {

    private var INSTANCE: AppDb? = null

    fun getInstance(context: Context): AppDb {
        if (INSTANCE == null) {
            synchronized(AppDb::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDb::class.java,
            "mindorks-example-coroutines"
        ).build()

}