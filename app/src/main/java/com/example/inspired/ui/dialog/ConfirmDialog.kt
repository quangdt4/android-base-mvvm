package com.example.inspired.ui.dialog

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.inspired.R

class ConfirmDialog(context: Context) : AlertDialog(context) {

    class Builder(val context: Context) {
        var dynamicDialog: AlertDialog? = null
        private var mTitle = context.getString(R.string.app_name)
        private var mContentDialog = ""
        private var mCancelable = true
        private var mCancelOnTouchOutSide = true
        private var mColorButtonPositive = R.color.colorAccent
        private var mColorButtonNegative = R.color.colorAccent
        private var mColorButtonNeutral = R.color.colorAccent
        private var mFontTitleDialog = -1
        private var mFontContentDialog = -1
        private var mNumberOfButton = 1
        private var mPositiveName = R.string.ok
        private var mNegativeName = R.string.cancel
        private var clickPositive: () -> Unit = {}
        private var clickNegative: () -> Unit = {}
        private var clickNeutral: () -> Unit = {}

        fun setPositiveButton(stringRes: Int, onClickPositive: () -> Unit = {}): Builder {
            mPositiveName = stringRes
            clickPositive = onClickPositive
            return this
        }

        fun setOnClickPositive(onClickPositive: () -> Unit = {}): Builder {
            clickPositive = onClickPositive
            return this
        }

        fun setNegativeButton(stringRes: Int, onClickNegative: () -> Unit = {}): Builder {
            mNegativeName = stringRes
            clickNegative = onClickNegative
            return this
        }

        fun setTitle(stringRes: String): Builder {
            mTitle = stringRes
            return this
        }

        fun setDialogMsg(msg: String): Builder {
            mContentDialog = msg
            return this
        }

        fun setCancelable(isCancelable: Boolean): Builder {
            mCancelable = isCancelable
            return this
        }

        fun setOnTouchOutSide(isCancelOnTouchOutSide: Boolean): Builder {
            mCancelOnTouchOutSide = isCancelOnTouchOutSide
            return this
        }

        fun setColorButtonPositive(colorRes: Int): Builder {
            mColorButtonPositive = colorRes
            return this
        }

        fun setColorButtonNegative(colorRes: Int): Builder {
            mColorButtonNegative = colorRes
            return this
        }

        fun setColorButtonNeutral(colorRes: Int): Builder {
            mColorButtonNeutral = colorRes
            return this
        }

        fun setColorButtons(colorRes: Int): Builder {
            mColorButtonPositive = colorRes
            mColorButtonNegative = colorRes
            mColorButtonNeutral = colorRes
            return this
        }

        fun setFontTitleDialog(fontRes: Int): Builder {
            mFontTitleDialog = fontRes
            return this
        }

        fun setFontContentDialog(fontRes: Int): Builder {
            mFontContentDialog = fontRes
            return this
        }

        fun setNumberOfButton(numberOfButton: Int): Builder {
            mNumberOfButton = numberOfButton
            return this
        }

        fun create(): AlertDialog {
            val alertDialogBuilder = AlertDialog.Builder(ContextThemeWrapper(context, R.style.AppTheme))

            /**
             *  Custom font title dialog
             */
            if (-1 != mFontTitleDialog) {
                val tf: Typeface = ResourcesCompat.getFont(context, mFontTitleDialog)!!
                val tfSpan = CustomTFSpan(tf)
                val spannableString = SpannableString(mTitle)
                spannableString.setSpan(
                    tfSpan,
                    0,
                    spannableString.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                alertDialogBuilder.setTitle(spannableString)
            } else {
                alertDialogBuilder.setTitle(mTitle)
            }

            /**
             *  Handler display button of dialog
             */
            when (mNumberOfButton) {
                2 -> {
                    alertDialogBuilder.setPositiveButton(mPositiveName) { dialogInterface, _ ->
                        clickPositive()
                        dialogInterface.dismiss()
                    }

                    alertDialogBuilder.setNegativeButton(mNegativeName) { dialogInterface, _ ->
                        clickNegative()
                        dialogInterface.dismiss()
                    }
                }
                3 -> {
                    alertDialogBuilder.setPositiveButton(mPositiveName) { dialogInterface, _ ->
                        clickPositive()
                        dialogInterface.dismiss()
                    }

                    alertDialogBuilder.setNegativeButton(mNegativeName) { dialogInterface, _ ->
                        clickNegative()
                        dialogInterface.dismiss()
                    }
                }
                else -> {
                    alertDialogBuilder.setPositiveButton(mPositiveName) { dialogInterface, _ ->
                        clickPositive()
                        dialogInterface.dismiss()
                    }
                }
            }
            /**
             *  Custom font content dialog
             */
            if (-1 != mFontContentDialog) {
                val tf: Typeface = ResourcesCompat.getFont(context, mFontContentDialog)!!
                val tfSpan = CustomTFSpan(tf)
                val spannableString = SpannableString(mContentDialog)
                spannableString.setSpan(
                    tfSpan,
                    0,
                    spannableString.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                alertDialogBuilder.setMessage(spannableString)
            } else {
                alertDialogBuilder.setMessage(mContentDialog)
            }


            /**
             * Set color button dialog
             */
            val alertDialog = alertDialogBuilder.create()
            alertDialog.setOnShowListener {
                alertDialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE)
                    .setTextColor(ContextCompat.getColor(context, mColorButtonPositive))

                alertDialog.getButton(android.app.AlertDialog.BUTTON_NEGATIVE)
                    .setTextColor(ContextCompat.getColor(context, mColorButtonNegative))

                alertDialog.getButton(android.app.AlertDialog.BUTTON_NEUTRAL)
                    .setTextColor(ContextCompat.getColor(context, mColorButtonNeutral))

            }

            alertDialog.setCanceledOnTouchOutside(mCancelOnTouchOutSide)
            alertDialog.setCancelable(mCancelable)
            dynamicDialog = alertDialog
            return alertDialog
        }

        fun showDialog() {
            if (dynamicDialog == null) {
                create().show()
            } else {
                if (!dynamicDialog!!.isShowing) {
                    dynamicDialog!!.show()
                }
            }
        }
    }
}