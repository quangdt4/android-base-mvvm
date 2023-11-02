package com.example.one.ui.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.viewModels
import com.example.one.R
import com.example.one.databinding.ActivitySplashBinding
import com.example.one.ui.base.BaseActivity
import com.example.one.ui.main.MainActivity
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
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            },
            2000
        )
    }
}
