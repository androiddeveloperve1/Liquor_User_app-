package com.liquoruser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.liquoruser.R
import com.liquoruser.listener.CategoryItemClickListener
import com.liquoruser.model.testModels.BeerCategoryModel
import com.liquoruser.model.testModels.ExtrasCategoryModel
import com.liquoruser.model.testModels.LiquorCategoryModel
import com.liquoruser.model.testModels.WineCategoryModel
import com.liquoruser.ui.HomeActivity
import com.liquoruser.ui.adapter.category.BeerCategoryListAdapter
import com.liquoruser.ui.adapter.category.ExtraCategoryListAdapter
import com.liquoruser.ui.adapter.category.LiquorCategoryListAdapter
import com.liquoruser.ui.adapter.category.WineCategoryListAdapter
import com.liquoruser.utility.AppConstants
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.fragment_categories.view.*

class CategoriesFragment : Fragment(), CategoryItemClickListener {

    private var mLiquorCategoryList: ArrayList<LiquorCategoryModel>? = null
    private var mLiquorCategoryAdapter: LiquorCategoryListAdapter? = null

    private var mBeerCategoryList: ArrayList<BeerCategoryModel>? = null
    private var mBeerCategoryAdapter: BeerCategoryListAdapter? = null

    private var mWineCategoryList: ArrayList<WineCategoryModel>? = null
    private var mWineCategoryAdapter: WineCategoryListAdapter? = null

    private var mExtraCategoryList: ArrayList<ExtrasCategoryModel>? = null
    private var mExtraCategoryAdapter: ExtraCategoryListAdapter? = null

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
        mView = inflater.inflate(R.layout.fragment_categories, container, false)
        initialiseView()
        setupLiquorCategoryList()
        setupBeerCategoryList()
        setupWineCategoryList()
        setupExtrasCategoryList()
        return mView
    }

    private fun initialiseView() {

    }

    /*  Setup Liquor Category List*/
    private fun setupLiquorCategoryList() {
        mLiquorCategoryList = ArrayList<LiquorCategoryModel>()
        val liquorItem = LiquorCategoryModel("Vodka", R.mipmap.beer_icon)
        mLiquorCategoryList?.add(liquorItem)
        val liquorItem1 = LiquorCategoryModel("Tequila", R.mipmap.beer_icon)
        mLiquorCategoryList?.add(liquorItem1)
        val liquorItem2 = LiquorCategoryModel("Whiskey", R.mipmap.beer_icon)
        mLiquorCategoryList?.add(liquorItem2)
        val liquorItem3 = LiquorCategoryModel("Rum", R.mipmap.beer_icon)
        mLiquorCategoryList?.add(liquorItem3)
        val liquorItem4 = LiquorCategoryModel("Liqueur", R.mipmap.beer_icon)
        mLiquorCategoryList?.add(liquorItem4)
        val liquorItem5 = LiquorCategoryModel("Gin", R.mipmap.beer_icon)
        mLiquorCategoryList?.add(liquorItem5)

        mLiquorCategoryAdapter =
            LiquorCategoryListAdapter(
                activity!!,
                this,
                mLiquorCategoryList!!
            )
        val mLayoutManager = GridLayoutManager(activity, 2)
        mView?.rv_liquorCategory?.layoutManager = mLayoutManager
        mView?.rv_liquorCategory?.adapter = mLiquorCategoryAdapter
        mView?.rv_liquorCategory?.hasFixedSize()
        mView?.rv_liquorCategory?.isNestedScrollingEnabled
    }

    /*  Setup Beer Category List*/
    private fun setupBeerCategoryList() {
        mBeerCategoryList = ArrayList<BeerCategoryModel>()
        val liquorItem = BeerCategoryModel("Light Beer", R.mipmap.beer_icon)
        mBeerCategoryList?.add(liquorItem)
        val liquorItem1 = BeerCategoryModel("Lager", R.mipmap.beer_icon)
        mBeerCategoryList?.add(liquorItem1)
        val liquorItem2 = BeerCategoryModel("IPA", R.mipmap.beer_icon)
        mBeerCategoryList?.add(liquorItem2)
        val liquorItem3 = BeerCategoryModel("Cider", R.mipmap.beer_icon)
        mBeerCategoryList?.add(liquorItem3)
        val liquorItem4 = BeerCategoryModel("Pilsner", R.mipmap.beer_icon)
        mBeerCategoryList?.add(liquorItem4)
        val liquorItem5 = BeerCategoryModel("Stout", R.mipmap.beer_icon)
        mBeerCategoryList?.add(liquorItem5)

        mBeerCategoryAdapter =
            BeerCategoryListAdapter(
                activity!!,
                this,
                mBeerCategoryList!!
            )
        val mLayoutManager = GridLayoutManager(activity, 2)
        mView?.rv_beerCategory?.layoutManager = mLayoutManager
        mView?.rv_beerCategory?.adapter = mBeerCategoryAdapter
        mView?.rv_beerCategory?.hasFixedSize()
        mView?.rv_beerCategory?.isNestedScrollingEnabled
    }

    /*  Setup Wine Category List*/
    private fun setupWineCategoryList() {
        mWineCategoryList = ArrayList<WineCategoryModel>()
        val liquorItem = WineCategoryModel("White Wine", R.mipmap.beer_icon)
        mWineCategoryList?.add(liquorItem)
        val liquorItem1 = WineCategoryModel("Rose Wine", R.mipmap.beer_icon)
        mWineCategoryList?.add(liquorItem1)
        val liquorItem2 = WineCategoryModel("Red Wine", R.mipmap.beer_icon)
        mWineCategoryList?.add(liquorItem2)
        val liquorItem3 = WineCategoryModel("Champagne & Sparkling Wine", R.mipmap.beer_icon)
        mWineCategoryList?.add(liquorItem3)
        val liquorItem4 = WineCategoryModel("Sauvignon Blanc", R.mipmap.beer_icon)
        mWineCategoryList?.add(liquorItem4)
        val liquorItem5 = WineCategoryModel("Cabernet Sauvignon", R.mipmap.beer_icon)
        mWineCategoryList?.add(liquorItem5)

        mWineCategoryAdapter =
            WineCategoryListAdapter(
                activity!!,
                this,
                mWineCategoryList!!
            )
        val mLayoutManager = GridLayoutManager(activity, 2)
        mView?.rv_wineCategory?.layoutManager = mLayoutManager
        mView?.rv_wineCategory?.adapter = mWineCategoryAdapter
        mView?.rv_wineCategory?.hasFixedSize()
        mView?.rv_wineCategory?.isNestedScrollingEnabled
    }

    /*  Setup Extras Category List*/
    private fun setupExtrasCategoryList() {
        mExtraCategoryList = ArrayList<ExtrasCategoryModel>()
        val liquorItem = ExtrasCategoryModel("Soda", R.mipmap.beer_icon)
        mExtraCategoryList?.add(liquorItem)
        val liquorItem1 = ExtrasCategoryModel("Mixers", R.mipmap.beer_icon)
        mExtraCategoryList?.add(liquorItem1)
        val liquorItem2 = ExtrasCategoryModel("Ice & Barware", R.mipmap.beer_icon)
        mExtraCategoryList?.add(liquorItem2)
        val liquorItem3 = ExtrasCategoryModel("Juice", R.mipmap.beer_icon)
        mExtraCategoryList?.add(liquorItem3)
        val liquorItem4 = ExtrasCategoryModel("Energy Drinks", R.mipmap.beer_icon)
        mExtraCategoryList?.add(liquorItem4)
        val liquorItem5 = ExtrasCategoryModel("Fruits & Garnishes", R.mipmap.beer_icon)
        mExtraCategoryList?.add(liquorItem5)

        mExtraCategoryAdapter =
            ExtraCategoryListAdapter(
                activity!!,
                this,
                mExtraCategoryList!!
            )
        val mLayoutManager = GridLayoutManager(activity, 2)
        mView?.rv_extrasCategory?.layoutManager = mLayoutManager
        mView?.rv_extrasCategory?.adapter = mExtraCategoryAdapter
        mView?.rv_extrasCategory?.hasFixedSize()
        mView?.rv_extrasCategory?.isNestedScrollingEnabled
    }

    override fun onItemClickListener(view: View, position: Int, categoryType: Int) {
        var selectedCategoryItem = ""
        when (categoryType) {
            AppConstants.LIQUOR -> {
                selectedCategoryItem = mLiquorCategoryList?.get(position)?.categoryName!!
            }
            AppConstants.BEER -> {
                selectedCategoryItem = mBeerCategoryList?.get(position)?.categoryName!!
            }
            AppConstants.WINE -> {
                selectedCategoryItem = mWineCategoryList?.get(position)?.categoryName!!
            }
            AppConstants.EXTRAS -> {
                selectedCategoryItem = mExtraCategoryList?.get(position)?.categoryName!!
            }
        }

        ToastMsgUtils.showSuccessMsg((activity as HomeActivity).getParentView(), "Selected Category -> " + selectedCategoryItem)
    }
}