package com.liquoruser.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.liquoruser.R
import com.liquoruser.ui.adapter.ContactUsReasonAdapter
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_contact_us.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class ContactUsActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        initUI()
        setupClickListener()
    }

    private fun initUI() {
        tv_toolbarTitle.text = resources.getString(R.string.title_contact_us)
        iv_toolbarBack.visibility = View.VISIBLE
        iv_toolbarCancel.visibility = View.GONE
        tv_update.visibility = View.GONE

        val roleList = ArrayList<String>()
        roleList.add("Reason for contacting Liquor")
        roleList.add("Test reason 1")
        roleList.add("Test reason 2")
        val nRoleSelectionAdapter = ContactUsReasonAdapter(this@ContactUsActivity, roleList)
        spinner_reason?.adapter = nRoleSelectionAdapter

        spinner_reason?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //val selectedRole = parent!!.adapter.getItem(position) as String
            }
        }
    }

    private fun setupClickListener() {
        iv_toolbarBack.setOnClickListener(this)
        lyt_reason.setOnClickListener(this)
        iv_dropDown.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_toolbarBack -> {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@ContactUsActivity)
            }
            R.id.lyt_reason -> {
                spinner_reason.performClick()
            }
            R.id.iv_dropDown -> {
                spinner_reason.performClick()
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