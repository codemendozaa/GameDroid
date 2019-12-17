package com.codemen.gamedroid

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var countDownTimer:CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_start.setOnClickListener { v ->
            startTime()
            val rnd = Random()
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
              txt_color.setBackgroundColor(color)
        }

    }

    fun startTime() {
        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txt_contador.setText("seconds remaining:" + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                txt_contador.setText("done!")
            }
        }.start()


    }

}