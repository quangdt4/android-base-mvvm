package com.example.one.ui.profile

import android.view.View
import com.example.one.R
import com.example.one.databinding.FragmentProfileBinding
import com.example.one.ui.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

//    private val viewModel: ProfileViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_profile

    override fun initBinding(mRootView: View): FragmentProfileBinding {
        return FragmentProfileBinding.bind(mRootView)
    }

    override fun setUp() {
    }
}
