package com.example.one.ui.home

import android.content.Intent
import android.view.View
import androidx.fragment.app.viewModels
import com.example.one.R
import com.example.one.data.network.response.PhotoRes
import com.example.one.databinding.FragmentHomeBinding
import com.example.one.ui.base.BaseFragment
import com.example.one.ui.esign.ESignActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    private val homeAdapter by lazy { HomeAdapter() }

    private val list: ArrayList<PhotoRes> = ArrayList()

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun initBinding(mRootView: View): FragmentHomeBinding {
        return FragmentHomeBinding.bind(mRootView)
    }

    override fun setUp() {
        initView()
        initData()
    }

    private fun initView() {
        binding?.rcvHomeList?.adapter = homeAdapter

        binding?.srlHome?.setOnRefreshListener {
            onRefresh()
        }

        val menu = binding?.fabMenu
        val disableLayout = binding?.layoutDisable
        menu?.setOnMenuButtonClickListener {
            if (menu.isOpened) {
                menu.close(true)
                disableLayout?.visibility = View.GONE
            } else {
                menu.open(true)
                disableLayout?.visibility = View.VISIBLE
            }
        }

        disableLayout?.setOnClickListener {
            if (menu?.isOpened == true) {
                menu.close(true)
                disableLayout.visibility = View.GONE
            }
        }

        binding?.fabDocs?.setOnClickListener {
            openDocuments()
        }

        binding?.fabESign?.setOnClickListener {
            val intent = Intent(requireContext(), ESignActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openDocuments() {
        TODO("Not yet implemented")
    }

    private fun initData() {

//        for (i in 1..10) list.add(PhotoRes(i.toString()))
//        homeAdapter.setData(list)
    }

    private fun onRefresh() {
//        homeAdapter.clearData()
//        list.clear()
//        binding?.srlHome?.isRefreshing = false
//        for (i in 1..15) list.add(PhotoRes(i.toString()))
//        homeAdapter.setData(list)
    }
}
