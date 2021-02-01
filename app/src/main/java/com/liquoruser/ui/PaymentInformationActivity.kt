package com.liquoruser.ui

import android.os.Bundle
import android.view.View
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_payment_information.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class PaymentInformationActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_information)

        initUI()
        setupClickListener()
    }

    private fun initUI() {
        tv_toolbarTitle.text = resources.getString(R.string.payment_information)
        iv_toolbarBack.visibility = View.GONE
        iv_toolbarCancel.visibility = View.VISIBLE
        tv_update.visibility = View.GONE
        tv_save.visibility = View.VISIBLE
    }

    private fun setupClickListener() {
        iv_toolbarCancel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_toolbarCancel -> {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@PaymentInformationActivity)
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