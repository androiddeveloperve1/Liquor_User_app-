package com.liquoruser.ui

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import com.liquoruser.utility.Utility
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class LoginActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener{

    private var isPasswordShow: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initUI()
        setupClickListener()
    }

    private fun initUI()
    {
        tv_toolbarTitle.text = resources.getString(R.string.title_welcome)
        iv_toolbarBack.visibility = View.VISIBLE
        iv_toolbarCancel.visibility = View.GONE
    }

    private fun setupClickListener()
    {
        iv_toolbarBack.setOnClickListener(this)
        btn_signUpWithFacebook.setOnClickListener(this)
        btn_signUpWithEmail.setOnClickListener(this)
        btn_forgotPassword.setOnClickListener(this)
        btn_login.setOnClickListener(this)
        iv_showHidePassword.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.iv_toolbarBack ->
            {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@LoginActivity)
            }
            R.id.btn_signUpWithFacebook ->
            {
                ToastMsgUtils.showSuccessMsg(lyt_parent, "Not implemented yet")
            }
            R.id.btn_signUpWithEmail ->
            {
                launchSignUpScreen()
            }
            R.id.btn_forgotPassword ->
            {
                launchForgotPasswordScreen()
            }
            R.id.btn_login ->
            {
                launchHomeScreen()
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

    private fun launchForgotPasswordScreen() {
        val forgotPassIntent = Intent(this@LoginActivity, ForgotPassword::class.java)
        startActivity(forgotPassIntent)
        SlideAnimationUtil.slideNextAnimation(this@LoginActivity)
    }

    private fun launchSignUpScreen() {
        val signUpIntent = Intent(this@LoginActivity, SignUpStepOneActivity::class.java)
        startActivity(signUpIntent)
        SlideAnimationUtil.slideNextAnimation(this@LoginActivity)
    }

    private fun launchHomeScreen() {
        val homeIntent = Intent(this@LoginActivity, HomeActivity::class.java)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(homeIntent)
        finish()
        SlideAnimationUtil.slideNextAnimation(this@LoginActivity)
    }
}