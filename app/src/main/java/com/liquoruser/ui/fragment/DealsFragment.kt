package com.liquoruser.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.liquoruser.R
import com.liquoruser.listener.CategoryItemClickListener
import com.liquoruser.ui.adapter.deals.BeerDealsListAdapter
import com.liquoruser.ui.adapter.deals.LiquorDealsListAdapter
import com.liquoruser.ui.adapter.deals.WineDealsListAdapter
import com.liquoruser.utility.AppConstants
import kotlinx.android.synthetic.main.fragment_deals.view.*

class DealsFragment : Fragment(), CategoryItemClickListener {
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
        mView = inflater.inflate(R.layout.fragment_deals, container, false)
        initialiseView()
        setupLiquorCategoryList()
        setupBeerCategoryList()
        setupWineCategoryList()
        setupExtrasCategoryList()
        return mView
    }

    private fun initialiseView()
    {

    }

    /*  Setup Liquor Category List*/
    private fun setupLiquorCategoryList() {

        val mLiquorDealsList = ArrayList<String>()
        val mLiquorDealsAdapter = LiquorDealsListAdapter(activity!!,this, mLiquorDealsList!!)
        val mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mView?.rv_liquorCategory?.layoutManager = mLayoutManager
        mView?.rv_liquorCategory?.adapter = mLiquorDealsAdapter
        mView?.rv_liquorCategory?.hasFixedSize()
        mView?.rv_liquorCategory?.isNestedScrollingEnabled
    }

    /*  Setup Beer Category List*/
    private fun setupBeerCategoryList() {
        val mBeerDealsList = ArrayList<String>()
        val mBeerDealsAdapter = BeerDealsListAdapter(activity!!,this, mBeerDealsList!!)
        val mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mView?.rv_beerCategory?.layoutManager = mLayoutManager
        mView?.rv_beerCategory?.adapter = mBeerDealsAdapter
        mView?.rv_beerCategory?.hasFixedSize()
        mView?.rv_beerCategory?.isNestedScrollingEnabled
    }

    /*  Setup Wine Category List*/
    private fun setupWineCategoryList() {
        val mWineDealsList = ArrayList<String>()
        val mWineDealsAdapter = WineDealsListAdapter(activity!!,this, mWineDealsList)
        val mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mView?.rv_wineCategory?.layoutManager = mLayoutManager
        mView?.rv_wineCategory?.adapter = mWineDealsAdapter
        mView?.rv_wineCategory?.hasFixedSize()
        mView?.rv_wineCategory?.isNestedScrollingEnabled
    }

    /*  Setup Extras Category List*/
    private fun setupExtrasCategoryList() {
        val mExtraDealsList = ArrayList<String>()
        val mExtrasDealsAdapter = WineDealsListAdapter(activity!!,this, mExtraDealsList)
        val mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mView?.rv_extrasCategory?.layoutManager = mLayoutManager
        mView?.rv_extrasCategory?.adapter = mExtrasDealsAdapter
        mView?.rv_extrasCategory?.hasFixedSize()
        mView?.rv_extrasCategory?.isNestedScrollingEnabled
    }

    override fun onItemClickListener(view: View, position: Int, categoryType: Int) {
//        var selectedCategoryItem = ""
//        when (categoryType) {
//            AppConstants.LIQUOR -> {
//                selectedCategoryItem = mLiquorCategoryList?.get(position)?.categoryName!!
//            }
//            AppConstants.BEER -> {
//                selectedCategoryItem = mBeerCategoryList?.get(position)?.categoryName!!
//            }
//            AppConstants.WINE -> {
//                selectedCategoryItem = mWineCategoryList?.get(position)?.categoryName!!
//            }
//            AppConstants.EXTRAS -> {
//                selectedCategoryItem = mExtraCategoryList?.get(position)?.categoryName!!
//            }
//        }
//
//        ToastMsgUtils.showSuccessMsg((activity as HomeActivity).getParentView(), "Selected Category -> " + selectedCategoryItem)
    }
}