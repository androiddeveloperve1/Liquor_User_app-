package com.liquoruser.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.AppConstants
import com.liquoruser.utility.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_signup_step_one.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class SignUpStepOneActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_step_one)

        initUI()
        setupClickListener()
    }

    private fun initUI()
    {
        tv_toolbarTitle.text = resources.getString(R.string.title_signup_one)
        iv_toolbarBack.visibility = View.VISIBLE
        iv_toolbarCancel.visibility = View.GONE

        et_address.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!s?.isEmpty()!!)
                {
                    iv_clear.visibility = View.VISIBLE
                }
                else
                {
                    iv_clear.visibility = View.GONE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun setupClickListener()
    {
        iv_toolbarBack.setOnClickListener(this)
        iv_clear.setOnClickListener(this)
        btn_continue.setOnClickListener(this)
        btn_home.setOnClickListener(this)
        btn_work.setOnClickListener(this)
        btn_custom.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.iv_toolbarBack ->
            {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@SignUpStepOneActivity)
            }
            R.id.iv_clear ->
            {
                clearAddressTextField()
            }
            R.id.btn_continue ->
            {
                launchSignUpScreenTwo()
            }
            R.id.btn_home ->
            {
                manageAddressType(AppConstants.HOME_ADDRESS)
            }
            R.id.btn_work ->
            {
                manageAddressType(AppConstants.WORK_ADDRESS)
            }
            R.id.btn_custom ->
            {
                manageAddressType(AppConstants.CUSTOM_ADDRESS)
            }
        }
    }

    private fun manageAddressType(type: String)
    {
        btn_home.setTextColor(resources.getColor(R.color.colorBlack2))
        btn_home.background = resources.getDrawable(R.drawable.bg_solid_white_with_gray_border)

        btn_work.setTextColor(resources.getColor(R.color.colorBlack2))
        btn_work.background = resources.getDrawable(R.drawable.bg_solid_white_with_gray_border)

        btn_custom.setTextColor(resources.getColor(R.color.colorBlack2))
        btn_custom.background = resources.getDrawable(R.drawable.bg_solid_white_with_gray_border)

        when(type)
        {
            AppConstants.HOME_ADDRESS ->
            {
                btn_home.setTextColor(resources.getColor(R.color.colorWhite))
                btn_home.background = resources.getDrawable(R.drawable.bg_red_with_rounded_corner)
            }
            AppConstants.WORK_ADDRESS ->
            {
                btn_work.setTextColor(resources.getColor(R.color.colorWhite))
                btn_work.background = resources.getDrawable(R.drawable.bg_red_with_rounded_corner)
            }
            AppConstants.CUSTOM_ADDRESS ->
            {
                btn_custom.setTextColor(resources.getColor(R.color.colorWhite))
                btn_custom.background = resources.getDrawable(R.drawable.bg_red_with_rounded_corner)
            }
        }
    }

    private fun clearAddressTextField()
    {
        if (!TextUtils.isEmpty(et_address.text.toString().trim()))
        {
            et_address.setText("")
            iv_clear.visibility = View.GONE
        }
    }

    private fun launchSignUpScreenTwo() {
        val signUpIntent = Intent(this@SignUpStepOneActivity, SignUpStepTwoActivity::class.java)
        startActivity(signUpIntent)
        SlideAnimationUtil.slideNextAnimation(this@SignUpStepOneActivity)
    }
}