package com.example.one.utils

import android.app.Dialog
import android.content.Context
import android.os.Handler
import android.view.Gravity
import android.view.Window
import android.widget.Toast
import com.example.one.R

object ProgressLoadingUtils {
    private var pdLoading: Dialog? = null
    private var isHide = false
    fun donShow() {
        isHide = true
    }

    fun show(context: Context?) {
        if (!CommonUtils.getInstance().isInternetAvailable()) {
            Toast.makeText(
                context,
                context!!.resources.getString(R.string.unavailable_internet),
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        if (!isLoading && context != null && !isHide) {
            try {
                if (pdLoading == null) {
                    pdLoading = Dialog(context)
                    pdLoading!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    pdLoading!!.setContentView(R.layout.item_progress_loading)
                    if (pdLoading!!.window != null) {
                        pdLoading!!.window!!.setBackgroundDrawableResource(R.color.transparent)
                    }
                    pdLoading!!.setCanceledOnTouchOutside(false)
                    pdLoading!!.window!!.setGravity(Gravity.CENTER)
                    pdLoading!!.setCancelable(false)
                }
                pdLoading!!.show()
            } catch (ignored: Exception) {
                // ignored.printStackTrace();
            }
        }
        isHide = false
    }

    fun dismiss() {
        if (pdLoading != null && pdLoading!!.isShowing) {
            Handler().postDelayed(
                {
                    try {
                        if (pdLoading != null && pdLoading!!.isShowing) {
                            pdLoading!!.dismiss()
                            pdLoading = null
                        }
                    } catch (ignored: Exception) {
                        // ignored.printStackTrace();
                    }
                },
                800
            )
        }
    }

    private val isLoading: Boolean
        get() = pdLoading != null && pdLoading!!.isShowing
}
