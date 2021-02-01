package com.liquoruser.ui.adapter.itemDetail

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.liquoruser.R

class ItemQuantitySelectionAdapter (internal var context: Context, internal var itemQuantityList: ArrayList<String>?) :
    ArrayAdapter<String>(context, 0, itemQuantityList!!) {



    override fun getCount(): Int {
        return  itemQuantityList?.size!!
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): String? {
        return itemQuantityList?.get(position)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView
        if (itemView == null)
        {
            itemView = LayoutInflater.from(context).inflate(R.layout.text_layout,parent, false)
        }

        val label = itemView?.findViewById(R.id.text) as TextView
        label.text = itemQuantityList?.get(position)
        label.gravity = Gravity.CENTER
        label.setTextColor(context.resources.getColor(R.color.colorWhite))
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
        label.text = itemQuantityList?.get(position)
        label.textSize = context.resources.getDimension(R.dimen.sp_5)
        return label
    }
}