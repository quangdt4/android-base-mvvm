package com.example.inspired.ui.splash

import com.example.inspired.ui.base.BaseViewModel
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
