package com.example.one.ui.blog

import android.view.View
import com.example.one.R
import com.example.one.databinding.FragmentBlogBinding
import com.example.one.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

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
