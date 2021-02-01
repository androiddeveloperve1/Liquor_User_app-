package com.liquoruser.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.liquoruser.R
import com.liquoruser.ui.*
import com.liquoruser.utility.AppConstants
import com.liquoruser.utility.SlideAnimationUtil
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment(), View.OnClickListener {

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
        mView = inflater.inflate(R.layout.fragment_profile, container, false)
        setupToolbar()
        setupClickListener()
        return mView
    }

    private fun setupToolbar()
    {
        (activity as HomeActivity).setToolbarTitle(activity?.resources?.getString(R.string.title_profile)!!)
        (activity as HomeActivity).setToolbarViewVisibility(true)
        (activity as HomeActivity).setSearchViewVisibility(false)
    }

    private fun setupClickListener()
    {
        mView?.lyt_myOrder?.setOnClickListener(this)
        mView?.lyt_referFriend?.setOnClickListener(this)
        mView?.lyt_accountDetail?.setOnClickListener(this)
        mView?.lyt_myReview?.setOnClickListener(this)
        mView?.lyt_addresses?.setOnClickListener(this)
        mView?.lyt_paymentInfo?.setOnClickListener(this)
        mView?.lyt_notifications?.setOnClickListener(this)

        mView?.lyt_supportAndResources?.setOnClickListener(this)
        mView?.lyt_contactUs?.setOnClickListener(this)
        mView?.lyt_faq?.setOnClickListener(this)
        mView?.lyt_termsOfService?.setOnClickListener(this)
        mView?.lyt_privacyPolicy?.setOnClickListener(this)
        mView?.lyt_acknowledgement?.setOnClickListener(this)
        mView?.lyt_Accessibility?.setOnClickListener(this)
        mView?.lyt_interestAds?.setOnClickListener(this)
        mView?.btn_logout?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.lyt_myOrder ->
            {
                launchMyOrderScreen()
            }
            R.id.lyt_referFriend ->
            {
                launchReferFriendScreen()
            }
            R.id.lyt_accountDetail ->
            {
                launchAccountDetailScreen()
            }
            R.id.lyt_myReview ->
            {
                launchMyReviewScreen()
            }
            R.id.lyt_addresses ->
            {
                launchMyAddressScreen()
            }
            R.id.lyt_paymentInfo ->
            {
                launchPaymentInfoScreen()
            }
            R.id.lyt_notifications ->
            {
                launchNotificationScreen()
            }
            R.id.lyt_supportAndResources ->
            {
                launchHelpAndSupportScreen()
            }
            R.id.lyt_contactUs ->
            {
                launchContactUsScreen()
            }
            R.id.lyt_acknowledgement ->
            {
                launchAcknowledgementScreen()
            }
            R.id.lyt_Accessibility ->
            {
                launchAccessibilityScreen()
            }
            R.id.lyt_faq ->
            {
                launchWebViewScreen(AppConstants.FAQ_PAGE)
            }
            R.id.lyt_termsOfService ->
            {
                launchWebViewScreen(AppConstants.TERMS_OF_SERVICES)
            }
            R.id.lyt_privacyPolicy ->
            {
                launchWebViewScreen(AppConstants.PRIVACY_POLICY)
            }
        }
    }

    private fun launchReferFriendScreen() {
        val homeIntent = Intent(activity, ReferFriendActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchMyOrderScreen() {
        val homeIntent = Intent(activity, MyOrdersActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchAccountDetailScreen() {
        val homeIntent = Intent(activity, AccountDetailActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchMyReviewScreen() {
        val homeIntent = Intent(activity, MyReviewActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchMyAddressScreen() {
        val homeIntent = Intent(activity, MyAddressActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchPaymentInfoScreen() {
        val homeIntent = Intent(activity, PaymentInformationActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchNotificationScreen()
    {
        val homeIntent = Intent(activity, NotificationActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchHelpAndSupportScreen()
    {
        val homeIntent = Intent(activity, HelpAndSupportActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchContactUsScreen()
    {
        val homeIntent = Intent(activity, ContactUsActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchAcknowledgementScreen()
    {
        val homeIntent = Intent(activity, AcknowledgementActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchAccessibilityScreen()
    {
        val homeIntent = Intent(activity, AccessibilityActivity::class.java)
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }

    private fun launchWebViewScreen(pageType: String)
    {
        val homeIntent = Intent(activity, CustomWebViewActivity::class.java)
        when(pageType)
        {
            AppConstants.FAQ_PAGE ->
            {
                homeIntent.putExtra(AppConstants.PAGE_TITLE, resources.getString(R.string.faq))
                homeIntent.putExtra(AppConstants.PAGE_URL, resources.getString(R.string.faq_url))
            }
            AppConstants.TERMS_OF_SERVICES ->
            {
                homeIntent.putExtra(AppConstants.PAGE_TITLE, resources.getString(R.string.terms_amp_services))
                homeIntent.putExtra(AppConstants.PAGE_URL, resources.getString(R.string.terms_of_services_url))
            }
            AppConstants.PRIVACY_POLICY ->
            {
                homeIntent.putExtra(AppConstants.PAGE_TITLE, resources.getString(R.string.privacy_policy))
                homeIntent.putExtra(AppConstants.PAGE_URL, resources.getString(R.string.privacy_policy_url))
            }
        }
        startActivity(homeIntent)
        SlideAnimationUtil.slideNextAnimation(activity!! as HomeActivity)
    }
}