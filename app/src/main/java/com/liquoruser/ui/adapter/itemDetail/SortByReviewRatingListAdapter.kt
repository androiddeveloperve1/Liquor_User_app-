package com.liquoruser.ui.adapter.itemDetail

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.liquoruser.R

class SortByReviewRatingListAdapter (internal var context: Context, internal var sortByList: ArrayList<String>?) :
    ArrayAdapter<String>(context, 0, sortByList!!) {



    override fun getCount(): Int {
        return  sortByList?.size!!
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): String? {
        return sortByList?.get(position)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView
        if (itemView == null)
        {
            itemView = LayoutInflater.from(context).inflate(R.layout.text_layout,parent, false)
        }

        val label = itemView?.findViewById(R.id.text) as TextView
        label.text = sortByList?.get(position)
        return itemView
    }

    override fun getDropDownView(position: Int, convertView: View?,
                                 parent: ViewGroup): View {
        var dropDownItemView = convertView
        if (dropDownItemView == null)
        {
            dropDownItemView = LayoutInflater.from(context).inflate(R.layout.item_dropdown_view, parent, false)
        }
        val label = dropDownItemView?.findViewById(R.id.tv_text) as TextView
        label.text = sortByList?.get(position)
        return label
    }
}