package com.codemen.gamedroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    enum class TimerState {
        Stopped, Paused, Running
    }


    private lateinit var timer: CountDownTimer
    private var timerLengthSecond = 0L
    private var timerState = TimerState.Stopped
    private var secondsRemaining: Long = 0L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_start.setOnClickListener { v ->
            startTimer()
            timerState = TimerState.Running
            updateButtons()
        }
    }


    private fun startTimer() {

        timer = object : CountDownTimer(1000, 1000) {
            override fun onFinish() = onTimerFinished()

            override fun onTick(millisUntilFinished: Long) {

            }
        }.start()
    }


    private fun updateButtons() {
        when (timerState) {
            TimerState.Running -> {
                fab_start.isEnabled = false
            }
        }
    }

    private fun onTimerFinished() {
        timerState = TimerState.Stopped
    }
}