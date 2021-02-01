package com.liquoruser.ui

import android.os.Bundle
import android.view.View
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class ForgotPassword : BaseActivityWithoutActionBarActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        initUI()
        setupClickListener()
    }

    private fun initUI()
    {
        tv_toolbarTitle.text = resources.getString(R.string.title_reset_password)
        iv_toolbarBack.visibility = View.GONE
        iv_toolbarCancel.visibility = View.VISIBLE
    }

    private fun setupClickListener()
    {
        iv_toolbarCancel.setOnClickListener(this)
        btn_resetPassword.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.iv_toolbarCancel ->
            {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@ForgotPassword)
            }
            R.id.btn_resetPassword ->
            {
                ToastMsgUtils.showSuccessMsg(lyt_parent, "Not implemented yet")
            }
        }
    }
}