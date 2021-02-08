package com.liquoruser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.liquoruser.R
import com.liquoruser.ui.HomeActivity
import com.liquoruser.ui.adapter.ExploreTabViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_explore.view.*

class ExploreFragment : Fragment(), View.OnClickListener {

    private var mView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_explore, container, false)
        setupToolbar()
        initialiseUI()
        setupclickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as HomeActivity).setCenterToolbarTitle(activity?.resources?.getString(R.string.title_explore)!!)
        (activity as HomeActivity).setToolbarViewVisibility(true)
        (activity as HomeActivity).setToolbarCenterTitleViewVisibility(true)
        (activity as HomeActivity).setToolbarLeftTitleViewVisibility(false)
        (activity as HomeActivity).setSearchViewVisibility(false)
    }

    private fun initialiseUI()
    {
        mView?.tabLayoutExplore?.addTab(mView?.tabLayoutExplore?.newTab()!!.setText("CATEGORIES"))
        mView?.tabLayoutExplore?.addTab(mView?.tabLayoutExplore?.newTab()!!.setText("DEALS"))

        val adapter = ExploreTabViewPagerAdapter(childFragmentManager, 2)
        mView?.viewPagerExplore?.adapter = adapter

        mView?.tabLayoutExplore?.setupWithViewPager(mView?.viewPagerExplore)
    }

    private fun setupclickListener()
    {
//        mView?.lyt_buy_points?.setOnClickListener(this)
//        mView?.lyt_sell_points?.setOnClickListener(this)
//        mView?.lyt_donate_points?.setOnClickListener(this)
//        mView?.lyt_history?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
//            R.id.lyt_buy_points ->
//            {
//                (activity as HomeActivity).setDisplayFragment(4)
//            }
//            R.id.lyt_sell_points ->
//            {
//                (activity as HomeActivity).setDisplayFragment(10)
//            }
//            R.id.lyt_donate_points ->
//            {
//                (activity as HomeActivity).setDisplayFragment(11)
//            }
//            R.id.lyt_history ->
//            {
//                (activity as HomeActivity).setDisplayFragment(9)
//            }
        }
    }
}