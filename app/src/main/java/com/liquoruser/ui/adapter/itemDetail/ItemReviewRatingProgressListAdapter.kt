package com.liquoruser.ui.adapter.itemDetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.ContentLoadingProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.liquoruser.R
import com.liquoruser.listener.ItemClickListener
import com.liquoruser.model.testModels.itemDetail.ItemAvailableQuantityModel
import com.liquoruser.model.testModels.itemDetail.ItemReviewRatingProgressModel

class ItemReviewRatingProgressListAdapter (context: Context, itemQuantityList: ArrayList<ItemReviewRatingProgressModel>): RecyclerView.Adapter<ItemReviewRatingProgressListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mItemReviewRatingProgressList: ArrayList<ItemReviewRatingProgressModel>? = null
    init {
        this.mContext = context
        this.mItemReviewRatingProgressList = itemQuantityList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_review_rating_progrss_list, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return mItemReviewRatingProgressList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mItemReviewRatingProgressList?.get(position)
        holder.mProgressBar?.progress = item?.process!!
        holder.mReviewCount?.text = item?.itemCount
        holder.mAllReview?.text = item?.review
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mProgressBar: ContentLoadingProgressBar? = null
        var mReviewCount: TextView? = null
        var mAllReview: TextView? = null
        init {
            mProgressBar = itemView.findViewById(R.id.reviewRatingProgress)
            mReviewCount = itemView.findViewById(R.id.tv_reviewSerialNo)
            mAllReview = itemView.findViewById(R.id.tv_overAllReview)
        }
    }
}