package com.liquoruser.utility

import androidx.appcompat.app.AppCompatActivity
import com.liquoruser.R

class SlideAnimationUtil {
    companion object {

        fun slideNextAnimation(activity1: AppCompatActivity) {
            activity1.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_left)
        }

        fun slideBackAnimation(activity1: AppCompatActivity) {
            activity1.overridePendingTransition(R.anim.slide_to_left, R.anim.slide_to_right);
        }
    }
}