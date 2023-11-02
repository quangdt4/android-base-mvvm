package com.example.one.ui.home

import android.view.View
import androidx.fragment.app.viewModels
import com.example.one.R
import com.example.one.data.network.response.PhotoRes
import com.example.one.databinding.FragmentHomeBinding
import com.example.one.ui.base.BaseFragment
import com.example.one.ui.dialog.ConfirmDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    private val homeAdapter by lazy { HomeAdapter() }

    val list: ArrayList<PhotoRes> = ArrayList()

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun initBinding(mRootView: View): FragmentHomeBinding {
        return FragmentHomeBinding.bind(mRootView)
    }

    override fun setUp() {
        initView()
        initData()
        binding?.srlHomeList?.setOnRefreshListener {
            onRefresh()
        }
    }

    private fun initView() {
        binding?.rcvHomeList?.adapter = homeAdapter

        binding?.includeActionBar?.tvAppTitle?.setOnClickListener {
            showAlert()
        }
    }

    private fun initData() {

        for (i in 1..10) list.add(PhotoRes(i.toString()))
        homeAdapter.setData(list)
    }

    private fun showAlert() {
        ConfirmDialog.Builder(mContext)
            .setDialogMsg(getString(R.string.confirm_exit))
            .setNumberOfButton(2)
            .setPositiveButton(
                R.string.ok,
                onClickPositive = {
                }
            )
            .setNegativeButton(R.string.cancel)
            .setOnTouchOutSide(false)
            .setFontTitleDialog(R.font.manrope_bold)
            .setFontContentDialog(R.font.manrope_regular)
            .create()
            .show()
    }

    fun onRefresh() {
        homeAdapter.clearData()
        list.clear()
        binding?.srlHomeList?.isRefreshing = false
        for (i in 1..15) list.add(PhotoRes(i.toString()))
        homeAdapter.setData(list)
    }
}
