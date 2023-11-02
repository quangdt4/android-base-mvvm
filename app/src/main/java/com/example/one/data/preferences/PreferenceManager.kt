package com.example.one.data.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    /**
     * String Type
     */
    fun putString(key: String?, value: String?) { // set value = String vao shared preferences
        mPrefs.edit().putString(key, value).apply()
    }

    fun getString(key: String?, defaultValue: String?): String? {
        return mPrefs.getString(key, defaultValue)
    }

    /**
     * Int Type
     */
    fun putInt(key: String?, value: Int) {
        mPrefs.edit().putInt(key, value).apply()
    }

    fun getInt(key: String?, defaultValue: Int): Int {
        return mPrefs.getInt(key, defaultValue)
    }

    /**
     * Boolean Type
     */
    var isCheck: Boolean
        get() = mPrefs.getBoolean(KEY_CHECK, false)
        set(isCheck) {
            mPrefs.edit().putBoolean(KEY_CHECK, isCheck).apply()
        }

    fun clearPref() {
        mPrefs.edit().clear().apply()
    }

//    inline var mString: String?
//        get() = getString(KEY)
//        set(value) {
//            putString(KEY, value ?: "")
//        }

    companion object {
        private var instance: PreferenceManager? = null

        @Synchronized
        private fun createInstance(context: Context) {
            if (instance == null) {
                instance = PreferenceManager(context)
            }
        }

        fun getInstance(context: Context): PreferenceManager? {
            if (instance == null) createInstance(context)
            return instance
        }

        const val KEY_CHECK = "KEY_CHECK"
    }
}
