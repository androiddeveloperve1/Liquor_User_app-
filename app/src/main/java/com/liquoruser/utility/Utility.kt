package com.liquoruser.utility

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class Utility {
    companion object
    {
        /**
         * Extension method to show a keyboard for View.
         */
        fun showKeyboard(context: Context, view: View) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            view.requestFocus()
            imm.showSoftInput(view, 0)
        }

        /**
         * Try to hide the keyboard and returns whether it worked
         * https://stackoverflow.com/questions/1109022/close-hide-the-android-soft-keyboard
         */
        fun hideKeyboard(context: Context, view: View) {
            view.apply {
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}