package com.example.inspired.callback

interface OnHomeCallBack {
    fun showFragment(backTag : String, tag : String, isBacked : Boolean)
    fun showFragment(backTag : String,data  : Any?, tag : String, isBacked : Boolean)
    fun closeApp()
}
