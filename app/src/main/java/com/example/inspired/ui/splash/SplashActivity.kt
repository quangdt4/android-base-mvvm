package com.example.inspired.ui.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.viewModels
import com.example.inspired.R
import com.example.inspired.databinding.ActivitySplashBinding
import com.example.inspired.ui.base.BaseActivity
import com.example.inspired.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private val viewModel: SplashViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.activity_splash

    override val containerViewId: Int
        get() = R.id.containerSplash

    override fun initBinding(rootView: View): ActivitySplashBinding {
        return ActivitySplashBinding.bind(rootView)
    }

    override fun setUp() {
        openMainScreen()
    }

    private fun openMainScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

}