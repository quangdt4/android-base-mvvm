package com.example.inspired.ui.blog

import android.view.View
import androidx.fragment.app.viewModels
import com.example.inspired.R
import com.example.inspired.databinding.FragmentBlogBinding
import com.example.inspired.ui.base.BaseFragment
import com.example.inspired.ui.profile.ProfileViewModel
import com.example.inspired.ui.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BlogFragment : BaseFragment<FragmentBlogBinding>() {

//    private val viewModel: BlogViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_blog

    override fun initBinding(mRootView: View): FragmentBlogBinding {
        return FragmentBlogBinding.bind(mRootView)
    }

    override fun setUp() {

    }
}