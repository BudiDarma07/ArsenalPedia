package com.example.arsenalpediaview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashArsenal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val countDownTimer = object : CountDownTimer(3000L, 1000){
            override fun onTick(millisUnitilFinished: Long) {
            }

            override fun onFinish() {
                navigateToMainAcitivity()
            }
        }
        countDownTimer.start()
    }
    private fun navigateToMainAcitivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }



}