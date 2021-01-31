package com.example.androidbaseapplication.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.util.Log


class SharedPrefHelper {

    companion object {

        private var sharedPref: SharedPrefHelper? = null
        private var sharedPrefName: String? = null
        private var context: Context? = null

    }

//    private fun SharedPrefHandler() {}

    fun getInstance(
        cntx: Context,
        sharedPrefFileName: Enums.PrefFiles
    ): SharedPrefHelper? {
        if (sharedPref == null) {
            sharedPref = SharedPrefHelper()
        }
        context = cntx
        sharedPrefName = sharedPrefFileName.name
        return sharedPref
    }

    fun getBooleanValue(key: String?): Boolean {
        val prefs =
            context!!.getSharedPreferences(sharedPrefName, MODE_PRIVATE)
        return prefs.getBoolean(key, false)
    }

    fun getIntValue(key: String?): Int {
        val prefs =
            context!!.getSharedPreferences(sharedPrefName, MODE_PRIVATE)
        return prefs.getInt(key, 0)
    }

    fun getStringValue(key: String?): String {
        val prefs =
            context!!.getSharedPreferences(sharedPrefName, MODE_PRIVATE)
        return prefs.getString(key, "") ?: ""
    }

    fun getFloatValue(key: String?): Float {
        val prefs =
            context!!.getSharedPreferences(sharedPrefName, MODE_PRIVATE)
        return prefs.getFloat(key, 0F)
    }

    fun add(key: String?, value: String?): SharedPrefHelper? {
        return try {
            context!!
                .getSharedPreferences(sharedPrefName, MODE_PRIVATE)
                .edit()
                .putString(key, value)
                .apply()
            sharedPref
        } catch (ex: Exception) {
            Log.e(Constants.TAG, "SharedPrefHandler: AddSharedPref: Exception: " + ex.message, ex)
            throw ex
        }
    }

    fun add(key: String?, value: Boolean): SharedPrefHelper? {
        return try {
            context!!
                .getSharedPreferences(sharedPrefName, MODE_PRIVATE)
                .edit()
                .putBoolean(key, value)
                .apply()
            sharedPref
        } catch (e: Exception) {
            Log.e(Constants.TAG, "SharedPrefHandler: AddSharedPref: Exception: " + e.message, e)
            throw e
        }
    }

    fun add(key: String?, value: Int): SharedPrefHelper? {
        return try {
            context!!
                .getSharedPreferences(sharedPrefName, MODE_PRIVATE)
                .edit()
                .putInt(key, value)
                .apply()
            sharedPref
        } catch (e: Exception) {
            Log.e(Constants.TAG, "SharedPrefHandler: AddSharedPref: Exception: " + e.message, e)
            throw e
        }
    }

    fun add(key: String?, value: Float): SharedPrefHelper? {
        return try {
            context!!
                .getSharedPreferences(sharedPrefName, MODE_PRIVATE)
                .edit()
                .putFloat(key, value)
                .apply()
            sharedPref
        } catch (e: Exception) {
            Log.e(Constants.TAG, "SharedPrefHandler: AddSharedPref: Exception: " + e.message, e)
            throw e
        }
    }

    fun clear(): SharedPrefHelper? {
        return try {
            context!!
                .getSharedPreferences(sharedPrefName, MODE_PRIVATE)
                .edit()
                .clear()
                .apply()
            sharedPref
        } catch (t: Throwable) {
            Log.e(Constants.TAG, "SharedPrefHandler: ClearSharedPref: Exception: " + t.message, t)
            throw t
        }

    }

}

// made using this link
//https://medium.com/@ashishkudale/shared-preference-helper-in-android-51df912c963d
//article by Ashish Kudale