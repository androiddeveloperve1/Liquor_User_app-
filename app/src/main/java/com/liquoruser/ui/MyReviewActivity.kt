package com.liquoruser.ui

import android.os.Bundle
import android.view.View
import com.liquoruser.R
import com.liquoruser.ui.adapter.MyReviewTabViewPagerAdapter
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_my_review.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class MyReviewActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_review)

        initUI()
        setupTabLayout()
        setupClickListener()
    }

    private fun initUI() {
        tv_toolbarTitle.text = resources.getString(R.string.my_review)
        iv_toolbarBack.visibility = View.VISIBLE
        iv_toolbarCancel.visibility = View.GONE
        tv_update.visibility = View.GONE
    }

    private fun setupTabLayout()
    {
        tabLayoutMyReview?.addTab(tabLayoutMyReview?.newTab()!!.setText("NOT REVIEWED"))
        tabLayoutMyReview?.addTab(tabLayoutMyReview?.newTab()!!.setText("REVIEWED"))

        val adapter = MyReviewTabViewPagerAdapter(supportFragmentManager, 2)
        viewPagerReview?.adapter = adapter

        tabLayoutMyReview?.setupWithViewPager(viewPagerReview)
    }

    private fun setupClickListener() {
        iv_toolbarBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_toolbarBack -> {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@MyReviewActivity)
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