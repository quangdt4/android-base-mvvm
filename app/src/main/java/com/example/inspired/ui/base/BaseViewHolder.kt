package com.example.inspired.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

@Suppress("unused", "LeakingThis", "CheckResult")
abstract class BaseViewHolder<T, K : ViewBinding>(private val adapter: BaseAdapter<T, K>?, itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    @Throws(Exception::class)
    abstract fun bindData(binding: K, data: T, position: Int)

    fun getListItem(): List<T> {
        return adapter?.getListItem() ?: arrayListOf()
    }
}