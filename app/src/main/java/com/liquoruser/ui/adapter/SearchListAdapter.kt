package com.liquoruser.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liquoruser.R
import com.liquoruser.listener.ItemClickListener

class SearchListAdapter (context: Context, listener: ItemClickListener, searchList: ArrayList<String>): RecyclerView.Adapter<SearchListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mSearchList: ArrayList<String>? = null
    private var mClickListener: ItemClickListener? = null
    init {
        this.mContext = context
        this.mSearchList = searchList
        this.mClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_search_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mSearchList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.mSearchItemName?.text = mSearchList?.get(position)

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mClickListener?.onItemClickListener(holder.itemView, position)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mSearchItemName: TextView? = null
        init {
            mSearchItemName = itemView.findViewById(R.id.tv_searchItem)
        }
    }
}