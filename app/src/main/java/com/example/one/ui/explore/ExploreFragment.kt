package com.example.one.ui.explore

import android.view.View
import com.example.one.R
import com.example.one.databinding.FragmentExploreBinding
import com.example.one.ui.base.BaseFragment

class ExploreFragment : BaseFragment<FragmentExploreBinding>() {

//    private val viewModel: ExploreViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_explore

    override fun initBinding(mRootView: View): FragmentExploreBinding {
        return FragmentExploreBinding.bind(mRootView)
    }

    override fun setUp() {
    }
}
