package com.liquoruser.ui.adapter.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liquoruser.R
import com.liquoruser.listener.CategoryItemClickListener
import com.liquoruser.model.testModels.ExtrasCategoryModel
import com.liquoruser.utility.AppConstants

class ExtraCategoryListAdapter (context: Context, listener: CategoryItemClickListener, categoryList: ArrayList<ExtrasCategoryModel>): RecyclerView.Adapter<ExtraCategoryListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mCategoryList: ArrayList<ExtrasCategoryModel>? = null
    private var mClickListener: CategoryItemClickListener? = null
    init {
        this.mContext = context
        this.mCategoryList = categoryList
        this.mClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_category_list, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return mCategoryList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mCategoryList?.get(position)
        holder.mCategoryItemName?.text = item?.categoryName
        holder.mCategoryItemImage?.setImageResource(item?.categoryIcon!!)

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mClickListener?.onItemClickListener(holder.itemView, position, AppConstants.EXTRAS)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mCategoryItemImage: ImageView? = null
        var mCategoryItemName: TextView? = null
        init {
            mCategoryItemImage = itemView.findViewById(R.id.iv_category)
            mCategoryItemName = itemView.findViewById(R.id.tv_categoryName)
        }
    }
}