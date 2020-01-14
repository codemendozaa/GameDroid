package com.codemen.gamedroid

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var countDownTimer:CountDownTimer
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(this)
        recyclerView.layoutManager = GridLayoutManager(this,3)
        recyclerView.adapter = adapter

        fab_start.setOnClickListener { v ->
            startTime()
            val rnd = Random()
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
              txt_color.setBackgroundColor(color)
        }

    }

    fun startTime() {
        val timer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txt_contador.setText("" + millisUntilFinished/1000)
            }

            override fun onFinish() {
                txt_contador.setText("")
            }
        }

        timer.start()
    }

}