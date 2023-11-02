package com.example.one.ui.splash

import com.example.one.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    var openMainActivity: () -> Unit = {}
    var openLoginActivity: () -> Unit = {}

    fun check() {
        openMainActivity.invoke()
    }
}
