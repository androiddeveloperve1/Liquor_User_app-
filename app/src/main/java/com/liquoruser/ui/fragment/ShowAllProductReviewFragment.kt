package com.liquoruser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.liquoruser.R
import com.liquoruser.model.testModels.itemDetail.ItemReviewRatingProgressModel
import com.liquoruser.ui.HomeActivity
import com.liquoruser.ui.adapter.itemDetail.ItemReviewRatingProgressListAdapter
import com.liquoruser.ui.adapter.itemDetail.ItemUserReviewListAdapter
import com.liquoruser.ui.adapter.itemDetail.SortByReviewRatingListAdapter
import kotlinx.android.synthetic.main.fragment_show_all_product_reviews.view.*

class ShowAllProductReviewFragment : Fragment(), View.OnClickListener {
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
        mView = inflater.inflate(R.layout.fragment_show_all_product_reviews, container, false)
        setupToolbar()
        initialiseView()
        setupReviewRatingProgressList()
        setupSortByRatingReviewView()
        setupUsersReviewList()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as HomeActivity).setLeftToolbarTitle("Item name")
        (activity as HomeActivity).setToolbarViewVisibility(true)
        (activity as HomeActivity).setToolbarCenterTitleViewVisibility(false)
        (activity as HomeActivity).setToolbarLeftTitleViewVisibility(true)
        (activity as HomeActivity).setSearchViewVisibility(false)
    }

    private fun initialiseView()
    {


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
        mView?.rv_reviewRatingProgress?.isNestedScrollingEnabled = false
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

    private fun setupClickListener()
    {
        mView?.btn_writeAReview?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.btn_writeAReview ->
            {
                (activity as HomeActivity).setDisplayFragment(8)
            }
        }
    }
}