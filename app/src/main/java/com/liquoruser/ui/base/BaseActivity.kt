package com.liquoruser.ui.base

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.liquoruser.utility.SlideAnimationUtil

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar()
    }

    private fun setStatusBar() {
        supportActionBar?.hide()
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                statusBarColor = Color.TRANSPARENT
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags: Int = window.decorView.getSystemUiVisibility()
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.decorView.setSystemUiVisibility(flags)
            window.setStatusBarColor(Color.TRANSPARENT)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        SlideAnimationUtil.slideBackAnimation(this)
    }

    fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

    fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

//    public fun showMyConfirmaationDialog(
//        title: String,
//        msg: String,
//        negativeButtonText: String,
//        positiveButtonText: String,
//        listener: DialogClickListener
//    ) {
//        AlertDialog.Builder(this)
//            .setTitle(title)
//            .setMessage(msg)
//            // .setIcon(android.R.drawable.ic_dialog_alert)
//            .setPositiveButton(
//                positiveButtonText,
//                DialogInterface.OnClickListener { dialog, whichButton ->
//                    listener.onPositiveButtonClick()
//                    dialog.dismiss()
//                }).setNegativeButton(
//                negativeButtonText,
//                DialogInterface.OnClickListener { dialog, whichButton ->
//                    listener.onNegativeButtonClick()
//                    dialog.dismiss()
//                })
//            .show()
//    }

//    fun isNetworkConnected(): Boolean {
//        return NetworkUtils.isNetworkConnected(applicationContext)
//    }

    public fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun logout(){

//        appPreferencesHelper?.clearAllData()
//        val intent = Intent(this, LoginActivity::class.java)
//        intent.flags =
//            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        startActivity(intent)
//        finish()
    }

}
