package com.liquoruser.listener

import android.view.View

interface CategoryItemClickListener {
    fun onItemClickListener(view: View, position: Int, categoryType: Int)
}