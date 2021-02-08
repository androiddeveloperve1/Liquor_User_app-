package com.liquoruser.ui.adapter.itemDetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liquoruser.R
import com.liquoruser.listener.ItemClickListener
import com.liquoruser.model.testModels.filter.FilterModel
import com.liquoruser.model.testModels.itemDetail.ItemAvailableQuantityModel

class FilterListAdapter (context: Context, filterList: ArrayList<FilterModel>): RecyclerView.Adapter<FilterListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mFilterList: ArrayList<FilterModel>? = null
    init {
        this.mContext = context
        this.mFilterList = filterList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_filter_list, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return mFilterList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mFilterList?.get(position)

        holder.mFilterTitle?.text = item?.filterTypeName
        val filterItemsListAdapter = FilterItemsListAdapter(mContext!!, item?.filterItems!!, holder.mFilterItemsList!!)
        val mLayoutManager = LinearLayoutManager(mContext)
        holder.mFilterItemsList?.layoutManager = mLayoutManager
        holder.mFilterItemsList?.adapter = filterItemsListAdapter
        holder.mFilterItemsList?.hasFixedSize()
        holder.mFilterItemsList?.isNestedScrollingEnabled
        if (item.isFilterTypeShowing!!)
        {
            holder.mFilterItemsList?.visibility = View.VISIBLE
        }
        else
        {
            holder.mFilterItemsList?.visibility = View.GONE
        }

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                if (item.isFilterTypeShowing!!)
                {
                    item.isFilterTypeShowing = false
                }
                else
                {
                    item.isFilterTypeShowing = true
                }

                notifyItemChanged(position)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mFilterLayout: ConstraintLayout? = null
        var mFilterTitle: TextView? = null
        var mFilterItemsList: RecyclerView? = null
        init {
            mFilterLayout = itemView.findViewById(R.id.lyt_filterTitle)
            mFilterTitle = itemView.findViewById(R.id.tv_itemName)
            mFilterItemsList = itemView.findViewById(R.id.rv_filterItems)
        }
    }
}