package com.liquoruser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.liquoruser.R
import com.liquoruser.listener.ItemClickListener
import com.liquoruser.ui.HomeActivity
import com.liquoruser.ui.adapter.SearchListAdapter
import com.liquoruser.utility.ToastMsgUtils
import kotlinx.android.synthetic.main.fragment_search.view.*

class SearchFragment : Fragment(), View.OnClickListener, ItemClickListener {

    private var mSearchList: ArrayList<String>? = null
    private var mSearchListAdapter: SearchListAdapter? = null
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
        mView = inflater.inflate(R.layout.fragment_search, container, false)
        setupToolbar()
        setupSearchList()
        setupclickListener()
        return mView
    }

    private fun setupToolbar()
    {
        (activity as HomeActivity).setCenterToolbarTitle(activity?.resources?.getString(R.string.title_search)!!)
        (activity as HomeActivity).setToolbarViewVisibility(false)
        (activity as HomeActivity).setSearchViewVisibility(true)

//        (activity as HomeActivity).setToolbarMenuIconVisibility(false)
//        (activity as HomeActivity).setToolbarBackIconVisibility(true)
//        (activity as HomeActivity).setToolbarAddIconVisibility(false)
    }

    private fun setupSearchList()
    {
        mSearchList = ArrayList<String>()
        mSearchList?.add("Ale")
        mSearchList?.add("Cider")
        mSearchList?.add("Vodka")
        mSearchList?.add("Champagne")
        mSearchList?.add("Tequila")

        mSearchListAdapter = SearchListAdapter(activity!!, this, mSearchList!!)
        val mLayoutManager = LinearLayoutManager(activity)
        mView?.rv_search?.layoutManager = mLayoutManager
        mView?.rv_search?.adapter = mSearchListAdapter
        mView?.rv_search?.hasFixedSize()
        //mView?.rv_allBusiness?.addItemDecoration(RecyclerViewItemDecorator(activity))
        mView?.rv_search?.isNestedScrollingEnabled
    }

    private fun setupclickListener()
    {
//        mView?.lyt_buy_points?.setOnClickListener(this)
//        mView?.lyt_sell_points?.setOnClickListener(this)
//        mView?.lyt_donate_points?.setOnClickListener(this)
//        mView?.lyt_history?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
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

    override fun onItemClickListener(view: View, position: Int) {
        val item = mSearchList?.get(position)
        ToastMsgUtils.showSuccessMsg((activity as HomeActivity).getParentView(), item!!)
    }
}