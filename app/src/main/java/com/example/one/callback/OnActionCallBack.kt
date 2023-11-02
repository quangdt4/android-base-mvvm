package com.example.one.callback

interface OnActionCallBack {
    fun callBack(key: String, data: Any?) {}
    fun logout() {}
    fun showWarnNoInternet() {}
}
