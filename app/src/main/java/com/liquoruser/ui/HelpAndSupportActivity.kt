package com.liquoruser.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.liquoruser.R
import com.liquoruser.listener.ItemClickListener
import com.liquoruser.model.testModels.HelpAndSupportListModel
import com.liquoruser.ui.adapter.HelpAndSupportListAdapter
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.SlideAnimationUtil
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_help_and_support.*
import kotlinx.android.synthetic.main.toolbar_secondry.*

class HelpAndSupportActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener,
    ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_and_support)

        initUI()
        setupHelpAndSupportQusAnsList()
        setupClickListener()
    }

    private fun initUI() {
        tv_toolbarTitle.text = resources.getString(R.string.alcohol_support_amp_resources)
        iv_toolbarBack.visibility = View.GONE
        iv_toolbarCancel.visibility = View.VISIBLE
        tv_update.visibility = View.GONE
    }

    private fun setupHelpAndSupportQusAnsList()
    {
        val mQuesAnsList = ArrayList<HelpAndSupportListModel>()
        val queAnsItem = HelpAndSupportListModel()
        queAnsItem.questionText = "What is Lorem Ipsum?"
        queAnsItem.answerText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        queAnsItem.isAnswerViewExpand = false
        mQuesAnsList.add(queAnsItem)

        val queAnsItem1 = HelpAndSupportListModel()
        queAnsItem1.questionText = "Where does it come from?"
        queAnsItem1.answerText = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words."
        queAnsItem1.isAnswerViewExpand = false
        mQuesAnsList.add(queAnsItem1)

        val queAnsItem2 = HelpAndSupportListModel()
        queAnsItem2.questionText = "Why do we use it?"
        queAnsItem2.answerText = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
        queAnsItem2.isAnswerViewExpand = false
        mQuesAnsList.add(queAnsItem2)

        val queAnsItem3 = HelpAndSupportListModel()
        queAnsItem3.questionText = "Where can I get some?"
        queAnsItem3.answerText = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text."
        queAnsItem3.isAnswerViewExpand = false
        mQuesAnsList.add(queAnsItem3)

        val queAnsItem4 = HelpAndSupportListModel()
        queAnsItem4.questionText = "The standard Lorem Ipsum passage, used since the 1500s"
        queAnsItem4.answerText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
        queAnsItem4.isAnswerViewExpand = false
        mQuesAnsList.add(queAnsItem4)

        val mSearchListAdapter = HelpAndSupportListAdapter(this@HelpAndSupportActivity, this, mQuesAnsList)
        val mLayoutManager = LinearLayoutManager(this@HelpAndSupportActivity)
        rv_helpAndSupport?.layoutManager = mLayoutManager
        rv_helpAndSupport?.adapter = mSearchListAdapter
        rv_helpAndSupport?.hasFixedSize()
        rv_helpAndSupport?.isNestedScrollingEnabled
    }

    private fun setupClickListener() {
        iv_toolbarCancel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_toolbarCancel -> {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@HelpAndSupportActivity)
            }
        }
    }

    override fun onItemClickListener(view: View, position: Int) {

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