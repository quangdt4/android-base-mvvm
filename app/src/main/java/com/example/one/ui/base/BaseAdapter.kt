package com.example.one.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T, K : ViewBinding>(@LayoutRes val layoutResId: Int? = null) :
    RecyclerView.Adapter<BaseViewHolder<T, K>>() {

    private var listItems = arrayListOf<T>()
    lateinit var mRootView: View
    var binding: K? = null

    override fun getItemCount(): Int {
        return listItems.size
    }

    abstract fun setViewHolder(layout: View): BaseViewHolder<T, K>

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<T, K> {
        mRootView = LayoutInflater.from(viewGroup.context).inflate(layoutResId!!, viewGroup, false)
        binding = initBinding(mRootView)
        return setViewHolder(mRootView)
    }

    abstract fun initBinding(mRootView: View): K?

    override fun onBindViewHolder(viewHolder: BaseViewHolder<T, K>, position: Int) {
        if (!listItems.isNullOrEmpty() && position < listItems.size) {
            binding?.let { viewHolder.bindData(it, listItems[position], position) }
        }
    }

    open fun setData(data: ArrayList<T>, isLoadMore: Boolean = false) {
        if (isLoadMore) {
            addData(data)
        } else {
            listItems.clear()
            listItems.addAll(data)
            notifyDataSetChanged()
        }
    }

    open fun addData(data: ArrayList<T>) {
        val oldSize = listItems.size
        listItems.addAll(data)
        notifyItemRangeInserted(oldSize, listItems.size)
    }

    open fun clearData() {
        listItems.clear()
        notifyDataSetChanged()
    }

    open fun deleteItem(item: T?) {
        val pos = listItems.indexOf(item)
        listItems.removeAt(pos)
        notifyItemRemoved(pos)
        notifyItemRangeChanged(pos, itemCount - pos)
    }

    fun getItem(position: Int) = listItems[position]

    fun getListItem() = listItems

    fun setDataListItem(list: ArrayList<T>) {
        listItems.clear()
        listItems.addAll(list)
    }
}
