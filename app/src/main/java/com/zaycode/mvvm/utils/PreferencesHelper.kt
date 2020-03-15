package com.zaycode.mvvm.utils

import android.content.Context
import android.content.SharedPreferences

open class PreferencesHelper(context: Context) {

    companion object {


        private const val DEFAULT_INT = -1

        private const val DEFAULT_LONG = -1L

        private const val DEFAULT_STRING = ""

        private const val DEFAULT_FLOAT = -1f

        private const val DEFAULT_BOOLEAN = false
    }


    fun getPreferences() = fundtasticPref

    private val fundtasticPref: SharedPreferences = context.getSharedPreferences("${context.packageName}.cache", Context.MODE_PRIVATE)

    fun clearData() {
        fundtasticPref.all.forEach {
            fundtasticPref.edit().remove(it.key).apply()
        }
    }
    fun saveString(key: String, value: String?) {
        if (value == null) {
            fundtasticPref.edit().putString(key,
                DEFAULT_STRING
            ).apply()
        } else {
            fundtasticPref.edit().putString(key, value).apply()
        }
    }

    fun saveLong(key: String, value: Long) {
        fundtasticPref.edit().putLong(key, value).apply()
    }

    fun saveFloat(key: String, value: Float) {
        fundtasticPref.edit().putFloat(key, value).apply()
    }

    fun saveInt(key: String, value: Int) {
        fundtasticPref.edit().putInt(key, value).apply()
    }

    fun saveBoolean(key: String, value: Boolean) {
        fundtasticPref.edit().putBoolean(key, value).apply()
    }

    fun getString(key: String, defaultValue: String = DEFAULT_STRING) =
        fundtasticPref.getString(key, defaultValue)

    fun getFloat(key: String, defaultValue: Float = DEFAULT_FLOAT) =
        fundtasticPref.getFloat(key, defaultValue)

    fun getInt(key: String, defaultValue: Int = DEFAULT_INT) =
        fundtasticPref.getInt(key, defaultValue)

    fun getLong(key: String, defaultValue: Long = DEFAULT_LONG) = fundtasticPref.getLong(key, defaultValue)

    fun getBoolean(key: String, defaultValue: Boolean = DEFAULT_BOOLEAN) = fundtasticPref.getBoolean(key, defaultValue)

}