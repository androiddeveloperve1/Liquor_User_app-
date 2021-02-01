package com.liquoruser.ui

import android.os.Bundle
import android.view.View
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_notification.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class NotificationActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        initUI()
        setupClickListener()
    }

    private fun initUI() {
        tv_toolbarTitle.text = resources.getString(R.string.notifications)
        iv_toolbarBack.visibility = View.VISIBLE
        iv_toolbarCancel.visibility = View.GONE
        tv_update.visibility = View.GONE
    }

    private fun setupClickListener() {
        iv_toolbarBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_toolbarBack -> {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@NotificationActivity)
            }
        }
    }

//    private fun launchHomeScreen() {
//        val homeIntent = Intent(this@MyOrdersActivity, HomeActivity::class.java)
//        homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//        startActivity(homeIntent)
//        finish()
//        SlideAnimationUtil.slideNextAnimation(this@MyOrdersActivity)
//    }
}