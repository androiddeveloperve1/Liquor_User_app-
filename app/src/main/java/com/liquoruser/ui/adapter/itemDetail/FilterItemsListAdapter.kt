package com.liquoruser.ui.adapter.itemDetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liquoruser.R
import com.liquoruser.model.testModels.filter.FilterItemModel

class FilterItemsListAdapter (context: Context, filterList: ArrayList<FilterItemModel>, recyclerView: RecyclerView): RecyclerView.Adapter<FilterItemsListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mFilterItemList: ArrayList<FilterItemModel>? = null
    private var mRecyclerView: RecyclerView? = null
    init {
        this.mContext = context
        this.mFilterItemList = filterList
        this.mRecyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_filter_list_items, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return mFilterItemList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mFilterItemList?.get(position)

        holder.mItemName?.text = item?.filterItemName
        holder.mFilterCount?.text = "(" + item?.filterCount + ")"
        if (item?.isFilterItemSelected!!)
        {
            holder.mCheckBox?.isChecked = true
        }
        else
        {
            holder.mCheckBox?.isChecked = false
        }
        holder.mCheckBox?.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {
                item.isFilterItemSelected = isChecked
                mRecyclerView?.post(Runnable { notifyItemChanged(position) })
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mItemName: TextView? = null
        var mFilterCount: TextView? = null
        var mCheckBox: CheckBox? = null
        init {
            mItemName = itemView.findViewById(R.id.tv_itemName)
            mFilterCount = itemView.findViewById(R.id.tv_filterCount)
            mCheckBox = itemView.findViewById(R.id.checkBox)
        }
    }
}