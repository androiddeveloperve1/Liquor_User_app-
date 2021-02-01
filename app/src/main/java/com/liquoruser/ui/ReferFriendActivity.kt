package com.liquoruser.ui

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_refer_a_friend.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class ReferFriendActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refer_a_friend)

        initUI()
        setupClickListener()
    }

    private fun initUI()
    {
        tv_toolbarTitle.text = resources.getString(R.string.refer_a_friend)
        iv_toolbarBack.visibility = View.VISIBLE
        iv_toolbarCancel.visibility = View.GONE
    }

    private fun setupClickListener()
    {
        iv_toolbarBack.setOnClickListener(this)
        btn_share.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.iv_toolbarBack ->
            {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@ReferFriendActivity)
            }
            R.id.btn_share ->
            {
                ToastMsgUtils.showSuccessMsg(lyt_parent, "Not implemented yet")
            }
        }
    }

    private fun launchHomeScreen() {
        val homeIntent = Intent(this@ReferFriendActivity, HomeActivity::class.java)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(homeIntent)
        finish()
        SlideAnimationUtil.slideNextAnimation(this@ReferFriendActivity)
    }
}