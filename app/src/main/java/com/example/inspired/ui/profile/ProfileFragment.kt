package com.example.inspired.ui.profile

import android.view.View
import androidx.fragment.app.viewModels
import com.example.inspired.R
import com.example.inspired.databinding.FragmentProfileBinding
import com.example.inspired.ui.base.BaseFragment

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