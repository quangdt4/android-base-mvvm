package com.example.one.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.one.App
import com.example.one.callback.OnActionCallBack
import com.example.one.callback.OnHomeCallBack

abstract class BaseFragment<K : ViewBinding?> : Fragment(), OnActionCallBack {

    lateinit var mContext: Context
    lateinit var mRootView: View
    var callBack: OnHomeCallBack? = null
    var mData: Any? = null
    var binding: K? = null

    companion object {
        const val SYS_ERROR: String = "Có lỗi xảy ra!"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = inflater.inflate(layoutId, container, false)
        binding = initBinding(mRootView)
        setUp()
        return mRootView
    }

    protected abstract val layoutId: Int

    abstract fun initBinding(mRootView: View): K?

    protected abstract fun setUp()

    fun setData(data: Any?) {
        mData = data
    }

    fun showToast(text: String) {
        Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT).show()
    }

    fun showToast(text: Int) {
        Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT).show()
    }

    fun showFragment(backTag: String, tag: String, isBacked: Boolean) {
        callBack?.showFragment(backTag, null, tag, isBacked)
    }

    override fun callBack(key: String, data: Any?) {
        if (key == BaseViewModel.KEY_NOTIFY) {
            showToast((data ?: SYS_ERROR) as String)
        } else if (key == BaseViewModel.KEY_ERROR) {
            showToast("SYS_ERROR: $data")
        }
    }
}
