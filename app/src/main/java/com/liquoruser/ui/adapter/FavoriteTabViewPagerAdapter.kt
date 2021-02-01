package com.liquoruser.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.liquoruser.ui.fragment.PastPurchaseItemFragment
import com.liquoruser.ui.fragment.SavedItemFragment

class FavoriteTabViewPagerAdapter (fm: FragmentManager, totalTabs: Int) : FragmentPagerAdapter(fm) {

    private var TOTAL_TAB_COUNT: Int = 0
    init {
        this.TOTAL_TAB_COUNT = totalTabs
    }
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = SavedItemFragment()
            1 -> fragment = PastPurchaseItemFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return TOTAL_TAB_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "SAVED ITEMS"
            else -> {
                return "PAST PURCHASES"
            }
        }
        //return "Tab " + (position + 1)
    }
}