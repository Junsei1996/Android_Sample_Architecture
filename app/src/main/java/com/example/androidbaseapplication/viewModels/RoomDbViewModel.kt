package com.example.androidbaseapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidbaseapplication.data.local.DatabaseHelper
import kotlinx.coroutines.launch

class RoomDbViewModel( private val dbHelper: DatabaseHelper) : ViewModel() {

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
//                val usersFromDb = dbHelper.

            } catch (e: Exception) {
                // handler error
            }
        }
    }

}

// implemented this from this link
// https://blog.mindorks.com/room-database-with-kotlin-coroutines-in-android
// article by Amit Shekhar
// 29th April 2020