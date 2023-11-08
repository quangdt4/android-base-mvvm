package com.example.one.ui.esign

import android.view.View
import com.example.one.R
import com.example.one.databinding.ActivityEsignBinding
import com.example.one.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ESignActivity : BaseActivity<ActivityEsignBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_esign

    override val containerViewId: Int
        get() = R.id.containerESign

    override fun initBinding(rootView: View): ActivityEsignBinding {
        return ActivityEsignBinding.bind(rootView)
    }

    override fun setUp() {
        supportFragmentManager.beginTransaction().replace(android.R.id.content, ESignFragment())
            .commit()
    }
}
