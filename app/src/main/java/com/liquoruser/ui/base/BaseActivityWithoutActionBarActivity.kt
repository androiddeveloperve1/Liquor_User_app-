package com.liquoruser.ui.base

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.liquoruser.utility.SlideAnimationUtil

open class BaseActivityWithoutActionBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        SlideAnimationUtil.slideBackAnimation(this)
    }

//    public fun showMyDialog(title: String, msg: String) {
//        AlertDialog.Builder(this)
//            .setTitle(title)
//            .setMessage(msg)
//            // .setIcon(android.R.drawable.ic_dialog_alert)
//            .setPositiveButton(
//                android.R.string.ok,
//                DialogInterface.OnClickListener { dialog, whichButton ->
//                    dialog.dismiss()
//                }).show()
//    }


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

    public fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

//    public fun logout() {
//
//        appPreferencesHelper?.clearAllData()
//        val intent = Intent(this, LoginActivity::class.java)
//        intent.flags =
//            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        startActivity(intent)
//        finish()
//    }

    fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

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
}
