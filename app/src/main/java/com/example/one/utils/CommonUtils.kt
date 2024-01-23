package com.example.one.utils

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.os.Build
import android.view.Display
import android.view.Surface
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.one.App
import com.example.one.R
import java.lang.reflect.InvocationTargetException
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.math.min

class CommonUtils private constructor() {

    fun isInternetAvailable(): Boolean {
        val cm: ConnectivityManager =
            App.getInstance().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        val networkInfor = cm.activeNetworkInfo
        return networkInfor != null && networkInfor.isConnectedOrConnecting
    }

    fun isMail(email: String): Boolean {
        val pattern: Pattern = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE
        )
        val matcher: Matcher = pattern.matcher(email)
        return matcher.find()
    }

    fun isPhone(phone: String): Boolean {
        return phone.matches("^(09|03|07|08|05)\\d{8}$".toRegex())
    }

    fun ImageView.loadImage(
        url: String?,
        width: Int? = null,
        height: Int? = null,
        isDefaultPlaceHolder: Boolean = true
    ) {
        val imageWidth =
            (
                context.resources.displayMetrics.widthPixels -
                    context.resources.getDimensionPixelSize(
                        R.dimen.d_24
                    )
                ) / 2
        val imageHeight = this@loadImage.getHeight(imageWidth, width, height)
//        val bitmap = AppCompatResources.getDrawable(
//            context,
//            if (isDefaultPlaceHolder) {
//            R.drawable.image_placeholder
//            } else {
//            R.drawable.im_64color_placeholder_standard
//    }
//        )?.toBitmap()
//        val placeHolder = bitmap?.let {
//            Bitmap.createScaledBitmap(it, imageWidth, imageWidth, false)
//        }
        Glide.with(context).load(url).override(imageWidth, imageHeight).centerCrop()
//            .placeholder(R.drawable.image_placeholder)
//            .error(R.drawable.image_placeholder)
            .dontAnimate().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    setImageDrawable(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // do nothing
                }
            })
    }

    private fun ImageView.getHeight(imageWidth: Int, width: Int?, height: Int?): Int {
        val maxHeight = context.resources.getDimensionPixelSize(R.dimen.d_80)
        if (width == null || width == 0 || height == null || height == 0) {
            return min(maxHeight, imageWidth)
        }
        val ratio = height.toFloat() / width
        return min((imageWidth * ratio).toInt(), maxHeight)
    }

    internal fun Activity.getStatusBarHeightInPx(): Int {
        val rectangle = Rect()
        window.decorView.getWindowVisibleDisplayFrame(rectangle)
        if (rectangle.top > 0) {
            return rectangle.top
        }
        return resources.run {
            val resourceId = getIdentifier("status_bar_height", "dimen", "android")
            getDimensionPixelSize(if (resourceId > 0) resourceId else R.dimen.d_24)
        }
    }

    internal fun Activity.getScreenHeight(): Int {
        val screenDisplay = Rect()
        window.decorView.getWindowVisibleDisplayFrame(screenDisplay)
        return screenDisplay.bottom - screenDisplay.top
    }

    private fun Activity.getRealScreenSize(): Point {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val defaultDisplay = windowManager.defaultDisplay
        val size = Point()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            defaultDisplay.getRealSize(size)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            try {
                size.x = Display::class.java.getMethod("getRawWidth").invoke(defaultDisplay) as Int
                size.y = Display::class.java.getMethod("getRawHeight").invoke(defaultDisplay) as Int
            } catch (e: IllegalAccessException) {
            } catch (e: InvocationTargetException) {
            } catch (e: NoSuchMethodException) {
            }
        }
        return size
    }

    internal fun Activity.getNavigationBarSizeInPx(): Int {
        val realScreenSize = getRealScreenSize()
        val appUsableScreenSize = getAppUsableScreenSize()
        val navigationBarPosition = getNavigationBarPosition()

        var cutoutTop = 0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val displayCutout = this.window.decorView.rootWindowInsets?.displayCutout
            displayCutout?.let {
                cutoutTop = displayCutout.safeInsetTop
            }
        }

        return if (navigationBarPosition == NavigationBarPosition.LEFT ||
            navigationBarPosition == NavigationBarPosition.RIGHT
        ) {
            realScreenSize.x - appUsableScreenSize.x
        } else {
            realScreenSize.y - appUsableScreenSize.y - cutoutTop
        }
    }

    private fun Activity.getNavigationBarPosition(): NavigationBarPosition {
        return when (windowManager.defaultDisplay.rotation) {
            Surface.ROTATION_0 -> NavigationBarPosition.BOTTOM
            Surface.ROTATION_90 -> NavigationBarPosition.RIGHT
            Surface.ROTATION_270 -> NavigationBarPosition.LEFT
            else -> NavigationBarPosition.TOP
        }
    }

    private fun Activity.getAppUsableScreenSize(): Point {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val defaultDisplay = windowManager.defaultDisplay
        val size = Point()
        defaultDisplay.getSize(size)
        return size
    }

    internal enum class NavigationBarPosition {
        BOTTOM, RIGHT, LEFT, TOP
    }

    companion object {
        private var INSTANCE: CommonUtils? = null
        fun getInstance(): CommonUtils {
            if (INSTANCE == null) {
                INSTANCE = CommonUtils()
            }
            return INSTANCE!!
        }
    }
}
