package com.liquoruser.ui

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.liquoruser.MainActivity
import com.liquoruser.R
import com.liquoruser.ui.adapter.AppIntroPagerAdapter
import com.liquoruser.ui.base.BaseActivity
import com.liquoruser.utility.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_app_intro.*

class AppIntroActivity : BaseActivity(), ViewPager.OnPageChangeListener, View.OnClickListener{

    private val mLayouts: Array<Int> = arrayOf(R.layout.app_intro_slide_one
        , R.layout.app_intro_slide_one, R.layout.app_intro_slide_one
        , R.layout.app_intro_slide_one)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_intro)

        initUI()
        setupClickListener()
    }

    private fun initUI()
    {
        val adapter = AppIntroPagerAdapter(this, mLayouts)
        appIntroViewPager.adapter = adapter
        appIntroViewPager.addOnPageChangeListener(this)
        dots_indicator.setViewPager(appIntroViewPager);
    }

    private fun setupClickListener()
    {
        tv_skip.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.tv_skip ->
            {
                launchMainScreen()
            }
        }
    }

    private fun getItem(): Int = appIntroViewPager.currentItem + 1

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        if (position == mLayouts.size - 1) {
            launchMainScreen()
        }
    }

    override fun onPageSelected(position: Int) {
    }

    private fun launchMainScreen() {
        startActivity(Intent(this, ShoppingAddressActivity::class.java))
        finish()
    }
}