package com.victor.creativenaija

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashScreenActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        object : CountDownTimer(20, 10){
            override fun onTick(p0: Long) {
//                TODO("Not yet implemented")
            }

            override fun onFinish() {
                startActivity(Intent(this@SplashScreenActivity,OnboardingActivity::class.java))
                finish()
//                TODO("Not yet implemented")
            }
        }.start()
    }
}