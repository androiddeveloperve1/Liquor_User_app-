package com.liquoruser.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.liquoruser.R
import com.liquoruser.model.testModels.filter.FilterItemModel
import com.liquoruser.model.testModels.filter.FilterModel
import com.liquoruser.ui.adapter.itemDetail.FilterListAdapter
import com.liquoruser.ui.base.BaseActivity
import com.liquoruser.utility.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
       // window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        setupFilterList()
        setupClickListener()
    }

    private fun setupFilterList()
    {
//        var filterTypeName: String?,
//        var filteItems: ArrayList<FilterItemModel>?,
//        var isFilterTypeShowing: Boolean?,
//        var isFilterTypeViewShowing: Boolean?

        val filterList = ArrayList<FilterModel>()
        val categoryTypeList = ArrayList<FilterItemModel>()

//        var filterItemName: String?,
//        var filterCount: String?,
//        var isFilterItemSelected: Boolean?

        val categoryTypeFilterItem = FilterItemModel("White Wine", "12", false)
        categoryTypeList.add(categoryTypeFilterItem)
        val categoryTypeFilterItem1 = FilterItemModel("Red Wine", "5", false)
        categoryTypeList.add(categoryTypeFilterItem1)
        val categoryTypeFilterItem2 = FilterItemModel("Pink Wine", "23", false)
        categoryTypeList.add(categoryTypeFilterItem2)
        val categoryTypeFilterItem3 = FilterItemModel("Wine Spritzer", "8", false)
        categoryTypeList.add(categoryTypeFilterItem3)
        val categoryTypeFilterItem4 = FilterItemModel("Red Blend", "20", false)
        categoryTypeList.add(categoryTypeFilterItem4)
        val categoryTypeFilterItem5 = FilterItemModel("Chardonnay", "62", false)
        categoryTypeList.add(categoryTypeFilterItem5)

        val item = FilterModel("Category", categoryTypeList, false, false)
        filterList.add(item)

        val countryTypeList = ArrayList<FilterItemModel>()
        val countryFilterItem = FilterItemModel("United States", "12", false)
        countryTypeList.add(countryFilterItem)
        val countryFilterItem1 = FilterItemModel("France", "8", false)
        countryTypeList.add(countryFilterItem1)
        val item1 = FilterModel("Country", countryTypeList, false, false)
        filterList.add(item1)

        val stateTypeList = ArrayList<FilterItemModel>()
        val stateFilterItem = FilterItemModel("California", "38", false)
        stateTypeList.add(stateFilterItem)
        val item2 = FilterModel("State", stateTypeList, false, false)
        filterList.add(item2)

        val spacialOfferTypeList = ArrayList<FilterItemModel>()
        val specialOffersItem = FilterItemModel("Deals", "28", false)
        spacialOfferTypeList.add(specialOffersItem)
        val specialOffersItem1 = FilterItemModel("Closeout", "20", false)
        spacialOfferTypeList.add(specialOffersItem1)
        val item3 = FilterModel("Special Offers", spacialOfferTypeList, false, false)
        filterList.add(item3)

        val availabilityTypeList = ArrayList<FilterItemModel>()
        val availabilityItem = FilterItemModel("Now (1 hours or Less)", "19", false)
        availabilityTypeList.add(availabilityItem)
        val availabilityItem1 = FilterItemModel("Today", "10", false)
        availabilityTypeList.add(availabilityItem1)
        val availabilityItem2 = FilterItemModel("Tomorrow or Later", "10", false)
        availabilityTypeList.add(availabilityItem2)
        val item4 = FilterModel("Availability", availabilityTypeList, false, false)
        filterList.add(item4)

        val priceTypeList = ArrayList<FilterItemModel>()
        val priceItem = FilterItemModel("Under $10", "10", false)
        priceTypeList.add(priceItem)
        val priceItem1 = FilterItemModel("$10 to $20", "20", false)
        priceTypeList.add(priceItem1)
        val priceItem2 = FilterItemModel("$20 to $30", "15", false)
        priceTypeList.add(priceItem2)
        val item5 = FilterModel("Price", availabilityTypeList, false, false)
        filterList.add(item5)

        val ratingTypeList = ArrayList<FilterItemModel>()
        val ratingItem = FilterItemModel("5 stars", "10", false)
        ratingTypeList.add(ratingItem)
        val ratingItem1 = FilterItemModel("4 star & up", "39", false)
        ratingTypeList.add(ratingItem1)
        val ratingItem2 = FilterItemModel("3 star & up", "65", false)
        ratingTypeList.add(ratingItem2)
        val item6 = FilterModel("Ratings", ratingTypeList, false, false)
        filterList.add(item6)

        val storeTypeList = ArrayList<FilterItemModel>()
        val storeItem = FilterItemModel("Gary's Liquor", "39", false)
        storeTypeList.add(storeItem)
        val storeItem1 = FilterItemModel("NJ Liquor", "35", false)
        storeTypeList.add(storeItem1)
        val storeItem2 = FilterItemModel("Lucky's Liquor", "40", false)
        storeTypeList.add(storeItem2)
        val item7 = FilterModel("Store Name", storeTypeList, false, false)
        filterList.add(item7)

        val brandTypeList = ArrayList<FilterItemModel>()
        val brandItem = FilterItemModel("Barefoot", "39", false)
        brandTypeList.add(brandItem)
        val brandItem1 = FilterItemModel("99 Brand", "15", false)
        brandTypeList.add(brandItem1)
        val brandItem2 = FilterItemModel("Bacardi", "10", false)
        brandTypeList.add(brandItem2)
        val item8 = FilterModel("Brand Name", brandTypeList, false, false)
        filterList.add(item8)

        val filterListAdapter = FilterListAdapter(this@FilterActivity, filterList)
        val mLayoutManager = LinearLayoutManager(this@FilterActivity)
        rv_filter?.layoutManager = mLayoutManager
        rv_filter?.adapter = filterListAdapter
        rv_filter?.hasFixedSize()
        rv_filter?.isNestedScrollingEnabled
    }

    private fun setupClickListener()
    {
        lyt_leftView.setOnClickListener(this)
        btn_apply.setOnClickListener(this)
        btn_reset.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.lyt_leftView ->
            {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@FilterActivity)
            }
            R.id.btn_apply ->
            {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@FilterActivity)
            }
            R.id.btn_reset ->
            {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@FilterActivity)
            }
        }
    }
}