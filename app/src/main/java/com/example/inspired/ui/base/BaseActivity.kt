package com.example.inspired.ui.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewbinding.ViewBinding
import com.example.inspired.R
import com.example.inspired.callback.OnHomeCallBack
import com.example.inspired.ui.dialog.ConfirmDialog
import com.ncapdevi.fragnav.FragNavController

abstract class BaseActivity<V : ViewBinding> : AppCompatActivity(), OnHomeCallBack {

    var binding: V? = null

    var fragNavController: FragNavController? = null

    var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootView = LayoutInflater.from(this).inflate(layoutId, null)
        setContentView(rootView)
        binding = initBinding(rootView)
        setUp()
    }

    protected abstract val layoutId: Int

    protected abstract val containerViewId: Int

    abstract fun initBinding(rootView: View): V?

    protected abstract fun setUp()

    private fun showToast(sms: String) {
        Toast.makeText(this, sms, Toast.LENGTH_SHORT).show()
    }

    override fun showFragment(backTag: String, data: Any?, tag: String, isBacked: Boolean) {
        try {
            val clazz = Class.forName(tag)
            val constructor = clazz.getConstructor()
            val frg = constructor.newInstance() as BaseFragment<*>

            frg.callBack = this
            frg.mData = data

            val trans: FragmentTransaction = supportFragmentManager.beginTransaction()
            if (isBacked) {
                trans.addToBackStack(backTag)
            }
            trans.replace(containerViewId, frg).commit()
        } catch (e: Exception) {
            showToast("Err: " + e.message)
            e.printStackTrace()
        }
    }

    override fun showFragment(backTag: String, tag: String, isBacked: Boolean) {
        showFragment(backTag, null, tag, isBacked)
    }

    override fun closeApp() {
        finish()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        showToast(getString(R.string.confirm_exit))

        Handler(Looper.getMainLooper())
            .postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

}

