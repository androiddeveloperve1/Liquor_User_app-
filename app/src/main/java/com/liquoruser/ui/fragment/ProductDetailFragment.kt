package com.liquoruser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.liquoruser.R
import com.liquoruser.listener.ItemClickListener
import com.liquoruser.model.testModels.itemDetail.ItemAvailableQuantityModel
import com.liquoruser.ui.HomeActivity
import com.liquoruser.ui.adapter.itemDetail.ItemAvailableQuantityListAdapter
import com.liquoruser.ui.adapter.itemDetail.ItemQuantitySelectionAdapter
import com.liquoruser.utility.AppConstants
import kotlinx.android.synthetic.main.fragment_product_detail.view.*

class ProductDetailFragment : Fragment(), View.OnClickListener, ItemClickListener {

    private var mItemAvlQtyList: ArrayList<ItemAvailableQuantityModel>? = null
    private var mItemAvailableQtyAdapter: ItemAvailableQuantityListAdapter? = null
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
        setupclickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as HomeActivity).setToolbarTitle("Item name")
        (activity as HomeActivity).setToolbarViewVisibility(true)
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
            }
        }
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
}