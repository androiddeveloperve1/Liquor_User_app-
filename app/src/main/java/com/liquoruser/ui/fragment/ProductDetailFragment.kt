package com.liquoruser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.liquoruser.R
import com.liquoruser.listener.CategoryItemClickListener
import com.liquoruser.listener.ItemClickListener
import com.liquoruser.model.testModels.home.HomePageItemModel
import com.liquoruser.model.testModels.home.ItemModel
import com.liquoruser.model.testModels.itemDetail.ItemAvailableQuantityModel
import com.liquoruser.model.testModels.itemDetail.ItemReviewRatingProgressModel
import com.liquoruser.ui.HomeActivity
import com.liquoruser.ui.adapter.home.HomeHorizontalItemListAdapter
import com.liquoruser.ui.adapter.itemDetail.*
import com.liquoruser.utility.AppConstants
import kotlinx.android.synthetic.main.fragment_product_detail.view.*

class ProductDetailFragment : Fragment(), View.OnClickListener, ItemClickListener,
    CategoryItemClickListener {

    private var mItemAvlQtyList: ArrayList<ItemAvailableQuantityModel>? = null
    private var mItemAvailableQtyAdapter: ItemAvailableQuantityListAdapter? = null
    private var mCustomerAlsoViewedList: ArrayList<ItemModel>? = null
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
        mView = inflater.inflate(R.layout.fragment_product_detail, container, false)
        setupToolbar()
        setupItemQuantityList()
        setupItemQtySelectionList()
        setupGetItNowLaterShippingView(AppConstants.GET_IT_NOW)
        setupProductDetailReviewView(AppConstants.PRODUCT_DETAIL)
        setupCustomerViewedItemList()
        setupclickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as HomeActivity).setCenterToolbarTitle("Item name")
        (activity as HomeActivity).setToolbarViewVisibility(true)
        (activity as HomeActivity).setToolbarCenterTitleViewVisibility(true)
        (activity as HomeActivity).setToolbarLeftTitleViewVisibility(false)
        (activity as HomeActivity).setSearchViewVisibility(false)
    }

    private fun setupItemQuantityList() {

        mItemAvlQtyList = ArrayList<ItemAvailableQuantityModel>()
        val item = ItemAvailableQuantityModel("750ml", "Bottle", true)
        mItemAvlQtyList?.add(item)
        val item1 = ItemAvailableQuantityModel("4x", "187ml Plastic Bottle", false)
        mItemAvlQtyList?.add(item1)
        val item2 = ItemAvailableQuantityModel("1.5L", "Bottle", false)
        mItemAvlQtyList?.add(item2)

        mItemAvailableQtyAdapter =
            ItemAvailableQuantityListAdapter(activity!!, this, mItemAvlQtyList!!)
        val mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mView?.rv_itemQuantity?.layoutManager = mLayoutManager
        mView?.rv_itemQuantity?.adapter = mItemAvailableQtyAdapter
        mView?.rv_itemQuantity?.hasFixedSize()
        mView?.rv_itemQuantity?.isNestedScrollingEnabled
    }

    private fun setupCustomerViewedItemList()
    {
        mCustomerAlsoViewedList = ArrayList<ItemModel>()
        val item = ItemModel(
            "Tito's Handmade Vodka",
            R.mipmap.image_one,
            false,
            "Deal-Save 21.0%",
            "19.99",
            "750.0ml Bottle",
            4.5,
            "300"
        )
        mCustomerAlsoViewedList?.add(item)
        val item1 = ItemModel(
            "Tito's Handmade Vodka",
            R.mipmap.image_one,
            true,
            "Deal-Save 21.0%",
            "19.99",
            "750.0ml Bottle",
            4.5,
            "300"
        )
        mCustomerAlsoViewedList?.add(item1)
        val item2 = ItemModel(
            "Tito's Handmade Vodka",
            R.mipmap.image_one,
            false,
            "Deal-Save 21.0%",
            "19.99",
            "750.0ml Bottle",
            4.5,
            "300"
        )
        mCustomerAlsoViewedList?.add(item2)
        val item3 = ItemModel(
            "Tito's Handmade Vodka",
            R.mipmap.image_one,
            true,
            "Deal-Save 21.0%",
            "19.99",
            "750.0ml Bottle",
            4.5,
            "300"
        )
        mCustomerAlsoViewedList?.add(item3)
        val item4 = ItemModel(
            "Tito's Handmade Vodka",
            R.mipmap.image_one,
            false,
            "Deal-Save 21.0%",
            "19.99",
            "750.0ml Bottle",
            4.5,
            "300"
        )
        mCustomerAlsoViewedList?.add(item4)
        val item5 = ItemModel(
            "Tito's Handmade Vodka",
            R.mipmap.image_one,
            true,
            "Deal-Save 21.0%",
            "19.99",
            "750.0ml Bottle",
            3.5,
            "200"
        )

        val mCustomerViewItemListAdapter = HomeHorizontalItemListAdapter(activity!!, this, mCustomerAlsoViewedList!!)
        val mLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mView?.rv_customerViewedItem?.layoutManager = mLayoutManager
        mView?.rv_customerViewedItem?.adapter = mCustomerViewItemListAdapter
        mView?.rv_customerViewedItem?.hasFixedSize()
        mView?.rv_customerViewedItem?.isNestedScrollingEnabled
    }

    private fun setupItemQtySelectionList() {
        val roleList = ArrayList<String>()
        for (i in 1 until 50) {
            roleList.add(i.toString())
        }
        val nRoleSelectionAdapter = ItemQuantitySelectionAdapter(activity!!, roleList)
        mView?.spinner_qty?.adapter = nRoleSelectionAdapter

        mView?.spinner_qty?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

    private fun setupclickListener() {
        mView?.lyt_itmQty?.setOnClickListener(this)
        mView?.iv_spinnerDropDown?.setOnClickListener(this)
        mView?.btn_getItNow?.setOnClickListener(this)
        mView?.btn_getItLater?.setOnClickListener(this)
        mView?.btn_shipping?.setOnClickListener(this)
        mView?.btn_productDetail?.setOnClickListener(this)
        mView?.btn_productReview?.setOnClickListener(this)
        mView?.tv_showAllDetails?.setOnClickListener(this)
        mView?.btn_addToCart?.setOnClickListener(this)
        mView?.btn_writeAReview?.setOnClickListener(this)
        mView?.lyt_reviewSortBy?.setOnClickListener(this)
        mView?.iv_dropDown?.setOnClickListener(this)
        mView?.btn_showAllReviews?.setOnClickListener(this)
        mView?.btn_viewAllProduct?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.lyt_itmQty ->
            {
                mView?.spinner_qty?.performClick()
            }
            R.id.iv_spinnerDropDown ->
            {
                mView?.spinner_qty?.performClick()
            }
            R.id.btn_getItNow ->
            {
                setupGetItNowLaterShippingView(AppConstants.GET_IT_NOW)
            }
            R.id.btn_getItLater ->
            {
                setupGetItNowLaterShippingView(AppConstants.GET_IT_LATER)
            }
            R.id.btn_shipping ->
            {
                setupGetItNowLaterShippingView(AppConstants.SHIPPING)
            }
            R.id.btn_productDetail ->
            {
                setupProductDetailReviewView(AppConstants.PRODUCT_DETAIL)
            }
            R.id.btn_productReview ->
            {
                setupProductDetailReviewView(AppConstants.PRODUCT_REVIEW)
            }
            R.id.tv_showAllDetails ->
            {

            }
            R.id.btn_addToCart->
            {

            }
            R.id.btn_writeAReview->
            {
                (activity as HomeActivity).setDisplayFragment(8)
            }
            R.id.btn_showAllReviews->
            {
                (activity as HomeActivity).setDisplayFragment(7)
            }
            R.id.lyt_reviewSortBy->
            {
                mView?.rv_reviewRatingProgress?.performClick()
            }
            R.id.iv_dropDown ->
            {
                mView?.rv_reviewRatingProgress?.performClick()
            }
            R.id.btn_viewAllProduct ->
            {
                (activity as HomeActivity).setDisplayFragment(10)
            }
        }
    }

    private fun setupGetItNowLaterShippingView(type: String)
    {
        mView?.tv_getItNow?.setTextColor(resources.getColor(R.color.colorBlack))
        mView?.view_getItNow?.setBackgroundColor(resources.getColor(R.color.colorWhite2))

        mView?.tv_getItLater?.setTextColor(resources.getColor(R.color.colorBlack))
        mView?.view_getItLater?.setBackgroundColor(resources.getColor(R.color.colorWhite2))

        mView?.tv_shipping?.setTextColor(resources.getColor(R.color.colorBlack))
        mView?.view_shipping?.setBackgroundColor(resources.getColor(R.color.colorWhite2))

        mView?.lyt_getItNowView?.visibility = View.GONE
        mView?.lyt_getItLaterView?.visibility = View.GONE
        mView?.lyt_shippingView?.visibility = View.GONE

        when(type)
        {
            AppConstants.GET_IT_NOW ->
            {
                mView?.tv_getItNow?.setTextColor(resources.getColor(R.color.colorRed))
                mView?.view_getItNow?.setBackgroundColor(resources.getColor(R.color.colorRed))
                mView?.lyt_getItNowView?.visibility = View.VISIBLE
            }
            AppConstants.GET_IT_LATER ->
            {
                mView?.tv_getItLater?.setTextColor(resources.getColor(R.color.colorRed))
                mView?.view_getItLater?.setBackgroundColor(resources.getColor(R.color.colorRed))
                mView?.lyt_getItLaterView?.visibility = View.VISIBLE
            }
            AppConstants.SHIPPING ->
            {
                mView?.tv_shipping?.setTextColor(resources.getColor(R.color.colorRed))
                mView?.view_shipping?.setBackgroundColor(resources.getColor(R.color.colorRed))
                mView?.lyt_shippingView?.visibility = View.VISIBLE
            }
        }
    }

    private fun setupProductDetailReviewView(viewType: String) {
        mView?.tv_productDetail?.setTextColor(resources.getColor(R.color.colorBlack))
        mView?.view_productDetail?.setBackgroundColor(resources.getColor(R.color.colorWhite2))

        mView?.tv_productReview?.setTextColor(resources.getColor(R.color.colorBlack))
        mView?.view_productReview?.setBackgroundColor(resources.getColor(R.color.colorWhite2))

        mView?.lyt_detailView?.visibility = View.GONE
        mView?.lyt_reviewView?.visibility = View.GONE

        when(viewType)
        {
            AppConstants.PRODUCT_DETAIL ->
            {
                mView?.tv_productDetail?.setTextColor(resources.getColor(R.color.colorRed))
                mView?.view_productDetail?.setBackgroundColor(resources.getColor(R.color.colorRed))
                mView?.lyt_detailView?.visibility = View.VISIBLE
            }
            AppConstants.PRODUCT_REVIEW ->
            {
                mView?.tv_productReview?.setTextColor(resources.getColor(R.color.colorRed))
                mView?.view_productReview?.setBackgroundColor(resources.getColor(R.color.colorRed))
                mView?.lyt_reviewView?.visibility = View.VISIBLE
                setupReviewRatingProgressList()
                setupSortByRatingReviewView()
                setupUsersReviewList()
            }
        }
    }

    private fun setupReviewRatingProgressList()
    {
        val itemReviewRatingProgressList = ArrayList<ItemReviewRatingProgressModel>()
        val item = ItemReviewRatingProgressModel("5", 80, "136")
        itemReviewRatingProgressList.add(item)
        val item1 = ItemReviewRatingProgressModel("4", 50, "25")
        itemReviewRatingProgressList.add(item1)
        val item2 = ItemReviewRatingProgressModel("3", 30, "17")
        itemReviewRatingProgressList.add(item2)
        val item3 = ItemReviewRatingProgressModel("2", 20, "10")
        itemReviewRatingProgressList.add(item3)
        val item4 = ItemReviewRatingProgressModel("1", 10, "1")
        itemReviewRatingProgressList.add(item4)

        val mItemReviewRatingProgress = ItemReviewRatingProgressListAdapter(activity!!, itemReviewRatingProgressList)
        val mLayoutManager = LinearLayoutManager(activity)
        mView?.rv_reviewRatingProgress?.layoutManager = mLayoutManager
        mView?.rv_reviewRatingProgress?.adapter = mItemReviewRatingProgress
        mView?.rv_reviewRatingProgress?.hasFixedSize()
        mView?.rv_reviewRatingProgress?.isNestedScrollingEnabled
    }

    private fun setupSortByRatingReviewView()
    {
        val sortByList = ArrayList<String>()
        sortByList.add("Newest")
        sortByList.add("Highest Rating")
        sortByList.add("Lowest Rating")

        val mSortBySelectionAdapter = SortByReviewRatingListAdapter(activity!!, sortByList)
        mView?.spinner_sortByReviewRating?.adapter = mSortBySelectionAdapter

        mView?.spinner_sortByReviewRating?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

    private fun setupUsersReviewList()
    {
        val userReviewList = ArrayList<String>()
        val mItemReviewListAdapter = ItemUserReviewListAdapter(activity!!, userReviewList)
        val mLayoutManager = LinearLayoutManager(activity)
        mView?.rv_userReviewList?.layoutManager = mLayoutManager
        mView?.rv_userReviewList?.adapter = mItemReviewListAdapter
        mView?.rv_userReviewList?.hasFixedSize()
        mView?.rv_userReviewList?.isNestedScrollingEnabled = false
    }

    override fun onItemClickListener(view: View, position: Int) {
        val selectedItem = mItemAvlQtyList?.get(position)
        for (i in 0 until mItemAvlQtyList?.size!!) {
            val item = mItemAvlQtyList?.get(i)
            item?.isSelectedQuantity = false
        }
        selectedItem?.isSelectedQuantity = true
        mItemAvailableQtyAdapter?.notifyDataSetChanged()
    }

    override fun onItemClickListener(view: View, position: Int, categoryType: Int) {
        (activity as HomeActivity).setDisplayFragment(6)
    }
}