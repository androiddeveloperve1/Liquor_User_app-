package com.liquoruser.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivity
import com.liquoruser.ui.fragment.*
import com.liquoruser.utility.AppConstants
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_bottom_navigation.*

class HomeActivity: BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initUI()
        setupClickListener()
        manageBottomNavigationBtnclick(AppConstants.HOME)
    }

    private fun initUI()
    {

    }

    private fun setupClickListener()
    {
        iv_toolbarCart.setOnClickListener(this)
        home_btn.setOnClickListener(this)
        search_btn.setOnClickListener(this)
        explore_btn.setOnClickListener(this)
        favorite_btn.setOnClickListener(this)
        profile_btn.setOnClickListener(this)
        iv_toolbarScan.setOnClickListener(this)
        iv_toolbarCart.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.iv_toolbarCart ->
            {
                ToastMsgUtils.showSuccessMsg(lyt_parent, "Coming soon..")
            }
            R.id.home_btn ->
            {
                manageBottomNavigationBtnclick(AppConstants.HOME)
            }
            R.id.search_btn ->
            {
                manageBottomNavigationBtnclick(AppConstants.SEARCH)
            }
            R.id.explore_btn ->
            {
                manageBottomNavigationBtnclick(AppConstants.EXPLORE)
            }
            R.id.favorite_btn ->
            {
                manageBottomNavigationBtnclick(AppConstants.FAVORITE)
            }
            R.id.profile_btn ->
            {
                manageBottomNavigationBtnclick(AppConstants.PROFILE)
            }
            R.id.iv_toolbarScan->
            {
                ToastMsgUtils.showSuccessMsg(lyt_parent, "No implemented yet...")
            }
        }
    }

    private fun manageBottomNavigationBtnclick(type: String)
    {
        iv_home.setImageResource(R.mipmap.home_off_icon)
        tv_home.visibility = View.GONE

        iv_search.setImageResource(R.mipmap.search_off_icon)
        tv_search.visibility = View.GONE

        iv_explore.setImageResource(R.mipmap.categories_off_icon)
        tv_explore.visibility = View.GONE

        iv_favorite.setImageResource(R.mipmap.tab_faviroite_off_icon)
        tv_favorite.visibility = View.GONE

        iv_profile.setImageResource(R.mipmap.profile_off_icon)
        tv_profile.visibility = View.GONE

        when(type)
        {
            AppConstants.HOME ->
            {
                iv_home.setImageResource(R.mipmap.home_on_icon)
                tv_home.visibility = View.VISIBLE
                setDisplayFragment(1)
            }
            AppConstants.SEARCH ->
            {
                iv_search.setImageResource(R.mipmap.search_on_icon)
                tv_search.visibility = View.VISIBLE
                setDisplayFragment(2)
            }
            AppConstants.EXPLORE ->
            {
                iv_explore.setImageResource(R.mipmap.categories_on_icon)
                tv_explore.visibility = View.VISIBLE
                setDisplayFragment(3)
            }
            AppConstants.FAVORITE ->
            {
                iv_favorite.setImageResource(R.mipmap.tab_faviroite_icon)
                tv_favorite.visibility = View.VISIBLE
                setDisplayFragment(4)
            }
            AppConstants.PROFILE ->
            {
                iv_profile.setImageResource(R.mipmap.profile_on_icon)
                tv_profile.visibility = View.VISIBLE
                setDisplayFragment(5)
            }
        }
    }

    fun setDisplayFragment(fragmentType: Int) {
        var mFragment: Fragment? = null
        var fragmentName: String = ""
        when (fragmentType) {
            1 -> {
                mFragment = HomeFragment()
                fragmentName = "HomeFragment"
                replaceFragment(mFragment, fragmentName)
            }
            2 -> {
                mFragment = SearchFragment()
                fragmentName = "SearchFragment"
                replaceFragment(mFragment, fragmentName)
            }
            3 -> {
                mFragment = ExploreFragment()
                fragmentName = "ExploreFragment"
                replaceFragment(mFragment, fragmentName)
            }
            4 -> {
                mFragment = FavoriteFragment()
                fragmentName = "FavoriteFragment"
                replaceFragment(mFragment, fragmentName)
            }
            5 -> {
                mFragment = ProfileFragment()
                fragmentName = "ProfileFragment"
                replaceFragment(mFragment, fragmentName)
            }
            6 ->
            {
                mFragment = ProductDetailFragment()
                fragmentName = "ProductDetailFragment"
                replaceFragment(mFragment, fragmentName)
            }
        }
    }

    fun replaceFragment(mFragment: Fragment, fragmentName: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, mFragment)
            .addToBackStack(fragmentName)
            .commit()
    }

    fun addFragment(mFragment: Fragment, fragmentName: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, mFragment)
            .addToBackStack(fragmentName)
            .commit()
    }

    private fun removeFragmentFromBackStack() {
        if (supportFragmentManager.findFragmentById(R.id.fragment_container) is HomeFragment) {
            finish()
        } else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is SearchFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is ExploreFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is FavoriteFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is ProfileFragment) {
            supportFragmentManager.popBackStackImmediate()
        }else if (supportFragmentManager.findFragmentById(R.id.fragment_container) is ProductDetailFragment) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            finish()
        }
    }

    override fun onBackPressed() {
        removeFragmentFromBackStack()
    }

    fun setToolbarTitle(string: String)
    {
        tv_pageTitle.text = string
    }

    fun setToolbarViewVisibility(isVisible: Boolean)
    {
        if (isVisible)
        {
            lyt_toolbarView.visibility = View.VISIBLE
        }
        else
        {
            lyt_toolbarView.visibility = View.GONE
        }
    }

    fun setSearchViewVisibility(isVisible: Boolean)
    {
        if (isVisible)
        {
            lyt_searchView.visibility = View.VISIBLE
        }
        else
        {
            lyt_searchView.visibility = View.GONE
        }
    }

    fun getParentView(): View
    {
        return lyt_parent
    }
}