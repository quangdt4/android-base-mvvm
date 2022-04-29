package com.example.inspired.ui.base

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.inspired.App
import com.example.inspired.Storage
import com.example.inspired.callback.OnActionCallBack
import com.example.inspired.data.repository.CommonRepository
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ViewModel() {
    val ex = MutableLiveData(false)
    private var mCallback: OnActionCallBack? = null

    @Inject
    lateinit var repository: CommonRepository

    @SuppressLint("StaticFieldLeak")
    @Inject
    lateinit var context: Context

    protected fun notifyToView(msg: String?) {
        mCallback!!.callBack(KEY_NOTIFY, msg)
    }

    fun setCallBack(mCallBack: OnActionCallBack?) {
        this.mCallback = mCallBack
    }

    val storage: Storage
        get() = App.getInstance().getStorage()

    companion object {
        const val KEY_NOTIFY = "KEY_NOTIFY"
        const val KEY_LOGOUT = "KEY_LOGOUT"
        const val KEY_ERROR = "KEY_ERROR"
        const val TOKEN = "TOKEN"
        const val PHONE: String = "PHONE"
        const val USER_NAME: String = "USER_NAME"

        protected const val CODE_400 = 400
        protected const val CODE_401 = 401
        protected const val CODE_403 = 403
        protected const val CODE_404 = 404
        protected const val CODE_500 = 500
        protected const val CODE_200 = 200
        protected const val CODE_201 = 201
        private val TAG = BaseViewModel::class.java.name
    }
}