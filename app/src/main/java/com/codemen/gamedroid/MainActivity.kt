package com.codemen.gamedroid

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_color_row.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var countDownTimer:CountDownTimer
    //private lateinit var adapter: MainAdapter

    private var recyclerView: RecyclerView? = null
    private var itemColor: ArrayList<ItemColor>? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var mainAdapter: MainAdapter? = null

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        gridLayoutManager = GridLayoutManager(applicationContext, 3, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        itemColor = ArrayList()
        itemColor = setAlphas()
        mainAdapter = MainAdapter(applicationContext, itemColor!!)
        recyclerView?.adapter = mainAdapter







        /* adapter = MainAdapter(this)
         recyclerView.layoutManager = GridLayoutManager(this,3)
         recyclerView.adapter = adapter */

        fab_start.setOnClickListener { v ->
            startTime()
            changeColor()
            fab_start.isClickable = false

        }


    }

    fun startTime() {
        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txt_contador.setText("" + millisUntilFinished/1000)

            }

            override fun onFinish() {
                fab_start.isClickable = true
                txt_contador.setText("")

            }
        }

        timer.start()
    }

    private fun setAlphas(): ArrayList<ItemColor> {

        var arrayList: ArrayList<ItemColor> = ArrayList()


        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorPrimary))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "", R.color.colorAccent))
        arrayList.add(ItemColor(R.drawable.letter_a, "",R.color.colorAccent))





        return arrayList
    }

    fun changeColor(){
        val rnd = Random()
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        txt_color.setBackgroundColor(color)
        itemImageColor.setBackgroundColor(color)
    }
}