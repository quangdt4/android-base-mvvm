package com.example.one.ui.esign

import android.view.View
import com.example.one.R
import com.example.one.databinding.FragmentEsignBinding
import com.example.one.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ESignFragment : BaseFragment<FragmentEsignBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_esign

    override fun initBinding(mRootView: View): FragmentEsignBinding {
        return FragmentEsignBinding.bind(mRootView)
    }

    override fun setUp() {
        initView()
        initData()
    }

    private fun initView() {
    }

    private fun initData() {
    }
}
