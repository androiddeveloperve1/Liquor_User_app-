package com.liquoruser.ui.adapter.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liquoruser.R
import com.liquoruser.listener.CategoryItemClickListener
import com.liquoruser.model.testModels.home.ItemModel
import com.liquoruser.utility.AppConstants

class HomeHorizontalItemListAdapter (context: Context, listener: CategoryItemClickListener, itemList: ArrayList<ItemModel>): RecyclerView.Adapter<HomeHorizontalItemListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mHomeItemList: ArrayList<ItemModel>? = null
    private var mClickListener: CategoryItemClickListener? = null

    init {
        this.mContext = context
        this.mHomeItemList = itemList
        this.mClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_deals_list, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return mHomeItemList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mHomeItemList?.get(position)

        holder.mItemImage?.setImageResource(item?.itemImage!!)
        if (item?.isItemFavorite!!)
        {
            holder.mIsItemFavorite?.setImageResource(R.mipmap.favorite_on_icon)
        }
        else
        {
            holder.mIsItemFavorite?.setImageResource(R.mipmap.favorite_off_icon)
        }
        holder.mSavePercentage?.text = item.itemDealsTitle
        holder.mItemName?.text = item.itemName
        holder.mItemPrice?.text = "$" + item.itemPrice
        holder.mItemQty?.text = item.itemQuantity
        holder.mItemRating?.rating =  item.itemRating?.toFloat()!!
        holder.mItemReview?.text = item.itemReview

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mClickListener?.onItemClickListener(holder.itemView, position, AppConstants.BEER)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mItemImage: ImageView? = null
        var mIsItemFavorite: ImageView? = null
        var mSavePercentage: TextView? = null
        var mItemName: TextView? = null
        var mItemPrice: TextView? = null
        var mItemQty: TextView? = null
        var mItemRating: RatingBar? = null
        var mItemReview: TextView? = null

        init {
            mItemImage = itemView.findViewById(R.id.iv_itemImage)
            mIsItemFavorite = itemView.findViewById(R.id.iv_itemFavorite)
            mSavePercentage = itemView.findViewById(R.id.tv_savePercentage)
            mItemName = itemView.findViewById(R.id.tv_itemName)
            mItemPrice = itemView.findViewById(R.id.tv_itemPrice)
            mItemQty = itemView.findViewById(R.id.tv_itemQty)
            mItemRating = itemView.findViewById(R.id.ratingBar)
            mItemReview = itemView.findViewById(R.id.tv_itemReview)
        }
    }
}