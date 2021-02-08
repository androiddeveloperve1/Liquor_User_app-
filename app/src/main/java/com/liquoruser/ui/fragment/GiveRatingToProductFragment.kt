package com.liquoruser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.liquoruser.R
import com.liquoruser.ui.HomeActivity
import kotlinx.android.synthetic.main.fragment_give_rating_to_product.view.*

class GiveRatingToProductFragment : Fragment(), View.OnClickListener {
    private var mView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_give_rating_to_product, container, false)
        setupToolbar()
        initialiseView()
        setupClickListener()
        return mView
    }

    private fun setupToolbar() {
        (activity as HomeActivity).setLeftToolbarTitle("Item name")
        (activity as HomeActivity).setToolbarViewVisibility(false)
        (activity as HomeActivity).setToolbarCenterTitleViewVisibility(false)
        (activity as HomeActivity).setToolbarLeftTitleViewVisibility(false)
        (activity as HomeActivity).setSearchViewVisibility(false)
    }

    private fun initialiseView()
    {


    }

    private fun setupClickListener()
    {
        mView?.iv_close?.setOnClickListener(this)
        mView?.btn_writeReview?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id)
        {
            R.id.iv_close ->
            {
                (activity as HomeActivity).removeFragmentFromBackStack()
            }
            R.id.btn_writeReview ->
            {
                (activity as HomeActivity).setDisplayFragment(9)
            }
        }
    }
}