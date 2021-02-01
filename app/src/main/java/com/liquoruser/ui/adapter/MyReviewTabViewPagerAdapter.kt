package com.liquoruser.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.liquoruser.ui.fragment.*

class MyReviewTabViewPagerAdapter (fm: FragmentManager, totalTabs: Int) : FragmentPagerAdapter(fm) {

    private var TOTAL_TAB_COUNT: Int = 0
    init {
        this.TOTAL_TAB_COUNT = totalTabs
    }
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = NotReviewedFragment()
            1 -> fragment = ReviewedFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return TOTAL_TAB_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "NOT REVIEWED"
            else -> {
                return "REVIEWED"
            }
        }
    }
}