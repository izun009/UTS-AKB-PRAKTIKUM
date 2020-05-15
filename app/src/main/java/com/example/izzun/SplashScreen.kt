package com.example.izzun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 11 Mei 2020
 *
 * */

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(3000)

                    val intent = Intent(baseContext, SliderPage::class.java)
                    startActivity(intent)

                } catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }

        background.start()
    }
}
