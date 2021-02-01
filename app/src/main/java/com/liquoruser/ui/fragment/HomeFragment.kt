package com.liquoruser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.liquoruser.R
import com.liquoruser.listener.CategoryItemClickListener
import com.liquoruser.model.testModels.home.HomePageItemModel
import com.liquoruser.model.testModels.home.ItemModel
import com.liquoruser.ui.HomeActivity
import com.liquoruser.ui.adapter.home.HomePageListAdapter
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(), View.OnClickListener, CategoryItemClickListener {

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
        mView = inflater.inflate(R.layout.fragment_home, container, false)
        setupToolbar()
        setupHomeItemsList()
        setupclickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as HomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.title_home)!!)
        (activity as HomeActivity).setToolbarViewVisibility(true)
        (activity as HomeActivity).setSearchViewVisibility(false)
    }

    //    var itemName: String?,
//    var itemImage: Int?,
//    var isItemFavorite: Boolean?,
//    var itemDealsTitle: String?,
//    var itemPrice: String?,
//    var itemQuantity: String?,
//    var itemRating: Int?,
//    var itemReview: String?
    /*  Setup Home Item List*/
    private fun setupHomeItemsList() {

        val mHomeItemList = ArrayList<HomePageItemModel>()
        val mItemList = ArrayList<ItemModel>()
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
        mItemList.add(item)
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
        mItemList.add(item1)
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
        mItemList.add(item2)
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
        mItemList.add(item3)
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
        mItemList.add(item4)
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
        mItemList.add(item5)
        val homeItem = HomePageItemModel("Best Seller", mItemList)
        mHomeItemList.add(homeItem)
        val homeItem2 = HomePageItemModel("Hard seltzer", mItemList)
        mHomeItemList.add(homeItem2)
        val homeItem3 = HomePageItemModel("Whiskey", mItemList)
        mHomeItemList.add(homeItem3)
        val homeItem4 = HomePageItemModel("Lager", mItemList)
        mHomeItemList.add(homeItem4)
        val homeItem5 = HomePageItemModel("White wine", mItemList)
        mHomeItemList.add(homeItem5)
        val homeItem6 = HomePageItemModel("Vodka", mItemList)
        mHomeItemList.add(homeItem6)
        val homeItem7 = HomePageItemModel("Rose", mItemList)
        mHomeItemList.add(homeItem7)

        val mLiquorDealsAdapter = HomePageListAdapter(activity!!, this, mHomeItemList)
        val mLayoutManager = LinearLayoutManager(activity)
        mView?.rv_homeItemList?.layoutManager = mLayoutManager
        mView?.rv_homeItemList?.adapter = mLiquorDealsAdapter
        mView?.rv_homeItemList?.hasFixedSize()
        mView?.rv_homeItemList?.isNestedScrollingEnabled
    }

    private fun setupclickListener() {
//        mView?.lyt_buy_points?.setOnClickListener(this)
//        mView?.lyt_sell_points?.setOnClickListener(this)
//        mView?.lyt_donate_points?.setOnClickListener(this)
//        mView?.lyt_history?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
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

    override fun onItemClickListener(view: View, position: Int, categoryType: Int) {
        (activity as HomeActivity).setDisplayFragment(6)
        //ToastMsgUtils.showSuccessMsg((activity as HomeActivity).getParentView(), "Coming soon")
    }
}