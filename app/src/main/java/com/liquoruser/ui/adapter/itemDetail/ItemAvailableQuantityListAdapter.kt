package com.liquoruser.ui.adapter.itemDetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.liquoruser.R
import com.liquoruser.listener.ItemClickListener
import com.liquoruser.model.testModels.itemDetail.ItemAvailableQuantityModel

class ItemAvailableQuantityListAdapter (context: Context, listener: ItemClickListener, itemQuantityList: ArrayList<ItemAvailableQuantityModel>): RecyclerView.Adapter<ItemAvailableQuantityListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mAvailableQuantityList: ArrayList<ItemAvailableQuantityModel>? = null
    private var mClickListener: ItemClickListener? = null
    init {
        this.mContext = context
        this.mAvailableQuantityList = itemQuantityList
        this.mClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_available_quantity_list, parent, false)
        return MyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return mAvailableQuantityList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mAvailableQuantityList?.get(position)
        if (item?.isSelectedQuantity!!)
        {
            holder.mItemOtyLayout?.background = mContext?.resources?.getDrawable(R.drawable.bg_solid_white_black_border)
        }
        else
        {
            holder.mItemOtyLayout?.background = mContext?.resources?.getDrawable(R.drawable.bg_solid_white_with_light_gray_border)
        }
        holder.mItemQty?.text = item?.itemQty
        holder.mItemQtyMsg?.text = item?.msg

        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mClickListener?.onItemClickListener(holder.itemView, position)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mItemOtyLayout: ConstraintLayout? = null
        var mItemQty: TextView? = null
        var mItemQtyMsg: TextView? = null
        init {
            mItemOtyLayout = itemView.findViewById(R.id.lyt_item)
            mItemQty = itemView.findViewById(R.id.tv_itemQty)
            mItemQtyMsg = itemView.findViewById(R.id.tv_itemQtyMsg)
        }
    }
}