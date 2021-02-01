package com.liquoruser.ui

import android.os.Bundle
import android.view.View
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_my_order.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class MyOrdersActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener {

    private val isFilterOptionShow: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_order)

        initUI()
        setupClickListener()
    }

    private fun initUI() {
        tv_toolbarTitle.text = resources.getString(R.string.my_order)
        iv_toolbarBack.visibility = View.VISIBLE
        iv_toolbarCancel.visibility = View.GONE
    }

    private fun setupClickListener() {
        iv_toolbarBack.setOnClickListener(this)
        lyt_filter.setOnClickListener(this)
        tv_allOrder.setOnClickListener(this)
        tv_activeOrder.setOnClickListener(this)
        tv_completedOrder.setOnClickListener(this)
        tv_canceledOrder.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_toolbarBack -> {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@MyOrdersActivity)
            }
            R.id.lyt_filter -> {
                showAllFilterOptions()
            }
            R.id.tv_allOrder -> {
                dismissAllFilterOptions()
            }
            R.id.tv_activeOrder -> {
                dismissAllFilterOptions()
            }
            R.id.tv_completedOrder -> {
                dismissAllFilterOptions()
            }
            R.id.tv_canceledOrder -> {
                dismissAllFilterOptions()
            }
        }
    }

    private fun showAllFilterOptions() {
        lyt_allFilterOption.visibility = View.VISIBLE
        lyt_filter.visibility = View.GONE
    }

    private fun dismissAllFilterOptions() {
        lyt_allFilterOption.visibility = View.GONE
        lyt_filter.visibility = View.VISIBLE
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