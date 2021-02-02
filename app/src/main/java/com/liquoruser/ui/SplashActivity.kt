package com.liquoruser.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.liquoruser.MainActivity
import com.liquoruser.R
import com.liquoruser.utility.SlideAnimationUtil

class SplashActivity : AppCompatActivity() {

    private var DELAY_TIME : Long =  1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
//            if (!Prefs.getString(AppConstant.USER_ID).isEmpty()) {
//                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
//            } else {
//                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
//            }
            startActivity(Intent(this@SplashActivity, AppIntroActivity::class.java))
            finish()
            SlideAnimationUtil.slideNextAnimation(this@SplashActivity)
        },DELAY_TIME)
    }
}
