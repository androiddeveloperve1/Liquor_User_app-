package com.liquoruser.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.liquoruser.R
import com.liquoruser.ui.base.BaseActivityWithoutActionBarActivity
import com.liquoruser.utility.AppConstants
import com.liquoruser.utility.SlideAnimationUtil
import kotlinx.android.synthetic.main.activity_custom_web_view.*
import kotlinx.android.synthetic.main.toolbar_secondry.*


class CustomWebViewActivity : BaseActivityWithoutActionBarActivity(), View.OnClickListener {

    private var mPageTitle: String? = ""
    private var mPageUrl: String? = ""
    private var dialog: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_web_view)

        initUI()
        setupClickListener()
    }

    private fun initUI() {

        mPageTitle = intent.getStringExtra(AppConstants.PAGE_TITLE)
        mPageUrl = intent.getStringExtra(AppConstants.PAGE_URL)

        lyt_progressBar.visibility = View.VISIBLE
        tv_toolbarTitle.text = mPageTitle
        iv_toolbarBack.visibility = View.VISIBLE
        iv_toolbarCancel.visibility = View.GONE
        tv_update.visibility = View.GONE

        webView.loadUrl(mPageUrl!!)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = MyWebViewClient(lyt_progressBar)
    }

    private fun setupClickListener() {
        iv_toolbarBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_toolbarBack -> {
                finish()
                SlideAnimationUtil.slideBackAnimation(this@CustomWebViewActivity)
            }
        }
    }

    private class MyWebViewClient(lytProgressbar: View) : WebViewClient() {
        private var mProgressBarView: View? = null
        init {
            this.mProgressBarView = lytProgressbar
        }
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url!!)
            return true
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            mProgressBarView?.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
    }
}