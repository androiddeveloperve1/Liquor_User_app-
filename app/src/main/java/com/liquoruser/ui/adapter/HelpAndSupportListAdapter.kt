package com.liquoruser.ui.adapter

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
import com.liquoruser.model.testModels.HelpAndSupportListModel

class HelpAndSupportListAdapter (context: Context, listener: ItemClickListener, queAnsList: ArrayList<HelpAndSupportListModel>): RecyclerView.Adapter<HelpAndSupportListAdapter.MyViewHolder>() {

    private var mContext: Context? = null
    private var mQuesAnsList: ArrayList<HelpAndSupportListModel>? = null
    private var mClickListener: ItemClickListener? = null
    init {
        this.mContext = context
        this.mQuesAnsList = queAnsList
        this.mClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_help_and_support_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mQuesAnsList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = mQuesAnsList?.get(position)

        holder.mQuestionText?.text = item?.questionText
        holder.mAnswerText?.text = item?.answerText

        if (item?.isAnswerViewExpand!!)
        {
            holder.mAnswerView?.visibility = View.VISIBLE
            holder.mDropDownImage?.rotation = 180f
        }
        else
        {
            holder.mAnswerView?.visibility = View.GONE
        }

        holder.mQuestionView?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if (item.isAnswerViewExpand!!)
                {
                    item.isAnswerViewExpand = false
                }
                else
                {
                    item.isAnswerViewExpand = true
                }
                notifyItemChanged(position)
            }
        })
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                mClickListener?.onItemClickListener(holder.itemView, position)
            }
        })
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mQuestionView: ConstraintLayout? = null
        var mAnswerView: ConstraintLayout? = null
        var mQuestionText: TextView? = null
        var mAnswerText: TextView? = null
        var mDropDownImage: ImageView? = null

        init {
            mQuestionView = itemView.findViewById(R.id.lyt_questionView)
            mAnswerView = itemView.findViewById(R.id.lyt_answerView)
            mQuestionText = itemView.findViewById(R.id.tv_questionText)
            mAnswerText = itemView.findViewById(R.id.tv_answerText)
            mDropDownImage = itemView.findViewById(R.id.iv_dropDown)
        }
    }
}