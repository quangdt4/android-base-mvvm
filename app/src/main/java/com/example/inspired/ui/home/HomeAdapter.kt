package com.example.inspired.ui.home

import android.view.View
import com.example.inspired.R
import com.example.inspired.data.network.response.PhotoRes
import com.example.inspired.databinding.ItemFeedBinding
import com.example.inspired.ui.base.BaseAdapter
import com.example.inspired.ui.base.BaseViewHolder

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