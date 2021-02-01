package com.liquoruser.ui.adapter.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liquoruser.R
import com.liquoruser.listener.CategoryItemClickListener
import com.liquoruser.model.testModels.home.HomePageItemModel
import com.liquoruser.utility.AppConstants

class HomePageListAdapter (context: Context, listener: CategoryItemClickListener, itemList: ArrayList<HomePageItemModel>): RecyclerView.Adapter<HomePageListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mHomeItemList: ArrayList<HomePageItemModel>? = null
    private var mClickListener: CategoryItemClickListener? = null

    init {
        this.mContext = context
        this.mHomeItemList = itemList
        this.mClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_home_list, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return mHomeItemList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mHomeItemList?.get(position)

        holder.mItemTitle?.text = item?.itemType
        val itemList = item?.homeItem
        if (!itemList?.isNullOrEmpty()!!)
        {
            val mLiquorDealsAdapter = HomeHorizontalItemListAdapter(mContext!!, mClickListener!!, itemList)
            val mLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            holder.mItemList?.layoutManager = mLayoutManager
            holder.mItemList?.adapter = mLiquorDealsAdapter
            holder.mItemList?.hasFixedSize()
            holder.mItemList?.isNestedScrollingEnabled
        }

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mClickListener?.onItemClickListener(holder.itemView, position, AppConstants.BEER)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mItemTitle: TextView? = null
        var mItemList: RecyclerView? = null

        init {
            mItemTitle = itemView.findViewById(R.id.tv_itemTitle)
            mItemList = itemView.findViewById(R.id.rv_items)
        }
    }
}