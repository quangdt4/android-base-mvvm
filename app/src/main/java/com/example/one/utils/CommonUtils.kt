package com.example.one.utils

import android.content.Context
import android.net.ConnectivityManager
import com.example.one.App
import java.util.regex.Matcher
import java.util.regex.Pattern

class CommonUtils private constructor() {

    fun isInternetAvailable(): Boolean {
        val cm: ConnectivityManager = App.getInstance().applicationContext
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfor = cm.activeNetworkInfo
        return networkInfor != null && networkInfor.isConnectedOrConnecting
    }

    fun isMail(email: String): Boolean {
        val pattern: Pattern = Pattern
            .compile(
                "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE
            )
        val matcher: Matcher = pattern.matcher(email)
        return matcher.find()
    }

    fun isPhone(phone: String): Boolean {
        return phone.matches("^(09|03|07|08|05)\\d{8}$".toRegex())
    }

    companion object {
        private var INSTANCE: CommonUtils? = null
        fun getInstance(): CommonUtils {
            if (INSTANCE == null) {
                INSTANCE = CommonUtils()
            }
            return INSTANCE!!
        }
    }
}
