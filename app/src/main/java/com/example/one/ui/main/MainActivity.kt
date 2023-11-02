package com.example.one.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.example.one.R
import com.example.one.databinding.ActivityMainBinding
import com.example.one.ui.base.BaseActivity
import com.example.one.ui.blog.BlogFragment
import com.example.one.ui.explore.ExploreFragment
import com.example.one.ui.home.HomeFragment
import com.example.one.ui.profile.ProfileFragment
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavTransactionOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

//    private val viewModel: MainViewModel by viewModels()

    companion object {
        const val TAB_1 = FragNavController.TAB1
        const val TAB_2 = FragNavController.TAB2
        const val TAB_3 = FragNavController.TAB3
        const val TAB_4 = FragNavController.TAB4
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    override val containerViewId: Int
        get() = R.id.containerHome

    override fun initBinding(rootView: View): ActivityMainBinding {
        return ActivityMainBinding.bind(rootView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragNav(savedInstanceState)
    }

    override fun setUp() {
    }

    private fun initFragNav(savedInstanceState: Bundle?) {
        fragNavController = FragNavController(supportFragmentManager, R.id.navHostContainer)
        fragNavController?.rootFragmentListener = object : FragNavController.RootFragmentListener {

            override val numberOfRootFragments: Int
                get() = 4

            override fun getRootFragment(index: Int): Fragment {
                when (index) {
                    TAB_1 -> return HomeFragment()
                    TAB_2 -> return ExploreFragment()
                    TAB_3 -> return BlogFragment()
                    TAB_4 -> return ProfileFragment()
                }
                throw IllegalStateException("Need to send an index that we know")
            }
        }

        fragNavController?.initialize(FragNavController.TAB1, savedInstanceState)

        binding?.bottomNav?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tabFeed -> {
                    updateViewBottomBar(View.VISIBLE)
                    if (fragNavController?.currentFrag is HomeFragment) {
                        Handler().postDelayed(
                            {
                                (fragNavController?.currentFrag as HomeFragment).onRefresh()
                            },
                            500
                        )
                    }
                    fragNavController?.switchTab(
                        TAB_1,
                        FragNavTransactionOptions.newBuilder().build()
                    )
                }

                R.id.tabSearch -> {
                    fragNavController?.switchTab(
                        TAB_2,
                        FragNavTransactionOptions.newBuilder().build()
                    )
                }

                R.id.tabVideo -> {
                    fragNavController?.switchTab(
                        TAB_3,
                        FragNavTransactionOptions.newBuilder().build()
                    )
                }

                R.id.tabProfile -> {
                    fragNavController?.switchTab(
                        TAB_4,
                        FragNavTransactionOptions.newBuilder().build()
                    )
                }
            }
            true
        }
    }

    private fun updateViewBottomBar(visible: Int) {
        binding?.bottomNav?.visibility = visible
    }
}
