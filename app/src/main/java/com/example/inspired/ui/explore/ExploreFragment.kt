package com.example.inspired.ui.explore

import android.view.View
import androidx.fragment.app.viewModels
import com.example.inspired.R
import com.example.inspired.databinding.FragmentExploreBinding
import com.example.inspired.ui.base.BaseFragment
import com.example.inspired.ui.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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