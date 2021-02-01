package com.liquoruser.ui

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_signup_step_two.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class SignUpStepTwoActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener {

    private var isPasswordShow: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_step_two)

        initUI()
        setupClickListener()
    }

    private fun initUI()
    {
        tv_toolbarTitle.text = resources.getString(R.string.title_signup_two)
        iv_toolbarBack.visibility = View.VISIBLE
        iv_toolbarCancel.visibility = View.GONE
    }

    private fun setupClickListener()
    {
        iv_toolbarBack.setOnClickListener(this)
        btn_signUp.setOnClickListener(this)
        iv_showHidePassword.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.iv_toolbarBack ->
            {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@SignUpStepTwoActivity)
            }
            R.id.btn_signUp ->
            {
                ToastMsgUtils.showSuccessMsg(lyt_parent, "Not implemented yet")
            }
            R.id.iv_showHidePassword ->
            {
                showHidePassword()
            }
        }
    }

    private fun showHidePassword()
    {
        if (isPasswordShow) {
            isPasswordShow = false
            iv_showHidePassword.setImageResource(R.mipmap.visible)
            et_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            isPasswordShow = true
            iv_showHidePassword.setImageResource(R.mipmap.hidden)
            et_password.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }
}