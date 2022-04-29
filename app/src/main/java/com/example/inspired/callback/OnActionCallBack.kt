package com.example.inspired.callback

interface OnActionCallBack {
    fun callBack(key: String, data: Any?) {}
    fun logout() {}
    fun showWarnNoInternet() {}
}
