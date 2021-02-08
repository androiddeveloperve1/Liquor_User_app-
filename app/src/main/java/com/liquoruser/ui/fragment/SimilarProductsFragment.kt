package com.liquoruser.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.liquoruser.R
import com.liquoruser.dialogs.SimilarProductHelpDialog
import com.liquoruser.listener.CategoryItemClickListener
import com.liquoruser.model.testModels.home.ItemModel
import com.liquoruser.ui.FilterActivity
import com.liquoruser.ui.HomeActivity
import com.liquoruser.ui.adapter.home.SimilarProductListAdapter
import com.liquoruser.utility.SlideAnimationUtil
import kotlinx.android.synthetic.main.fragment_view_similer_products.view.*

class SimilarProductsFragment : Fragment(), View.OnClickListener, CategoryItemClickListener {

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
        mView = inflater.inflate(R.layout.fragment_view_similer_products, container, false)
        setupToolbar()
        setupHomeItemsList()
        setupclickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as HomeActivity).setCenterToolbarTitle(activity?.resources?.getString(R.string.title_home)!!)
        (activity as HomeActivity).setToolbarViewVisibility(true)
        (activity as HomeActivity).setToolbarCenterTitleViewVisibility(true)
        (activity as HomeActivity).setToolbarLeftTitleViewVisibility(false)
        (activity as HomeActivity).setSearchViewVisibility(false)
    }

    private fun setupHomeItemsList() {

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
        val mLiquorDealsAdapter = SimilarProductListAdapter(activity!!, this, mItemList)
        val mLayoutManager = GridLayoutManager(activity, 2)
        mView?.rv_similarProducts?.layoutManager = mLayoutManager
        mView?.rv_similarProducts?.adapter = mLiquorDealsAdapter
        mView?.rv_similarProducts?.hasFixedSize()
        mView?.rv_similarProducts?.isNestedScrollingEnabled
    }

    private fun setupclickListener() {
        mView?.iv_helpBtn?.setOnClickListener(this)
        mView?.iv_filterImage?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_helpBtn ->
            {
                SimilarProductHelpDialog().show(childFragmentManager, "SimilarProductHelpDialog")
            }
            R.id.iv_filterImage ->
            {
                launchFilterActivity()
            }
        }
    }

    override fun onItemClickListener(view: View, position: Int, categoryType: Int) {
        (activity as HomeActivity).setDisplayFragment(6)
    }

    private fun launchFilterActivity()
    {
        val homeIntent = Intent(activity, FilterActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as AppCompatActivity)
    }
}