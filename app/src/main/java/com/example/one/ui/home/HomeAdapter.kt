package com.example.one.ui.home

import android.view.View
import com.example.one.R
import com.example.one.data.network.response.PhotoRes
import com.example.one.databinding.ItemFeedBinding
import com.example.one.ui.base.BaseAdapter
import com.example.one.ui.base.BaseViewHolder

class HomeAdapter : BaseAdapter<PhotoRes, ItemFeedBinding>(R.layout.item_feed) {

    override fun setViewHolder(layout: View): BaseViewHolder<PhotoRes, ItemFeedBinding> {
        return HomeViewHolder(layout)
    }

    override fun initBinding(mRootView: View): ItemFeedBinding {
        return ItemFeedBinding.bind(mRootView)
    }

    inner class HomeViewHolder(view: View) : BaseViewHolder<PhotoRes, ItemFeedBinding>(this, view) {
        override fun bindData(binding: ItemFeedBinding, data: PhotoRes, position: Int) {
            binding.tvText.text = "abcd"
        }
    }
}
