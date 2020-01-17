package com.codemen.gamedroid

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.use
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_color_row.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var countDownTimer: CountDownTimer


    private var recyclerView: RecyclerView? = null
    lateinit var  itemColor: ArrayList<ItemColor>
    private var gridLayoutManager: GridLayoutManager? = null
    private var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        gridLayoutManager =
            GridLayoutManager(this, 3)
        recyclerView?.layoutManager = gridLayoutManager


        itemColor = ArrayList()
        itemColor = setAlphas()
        mainAdapter = MainAdapter(applicationContext, itemColor)
        recyclerView?.adapter = mainAdapter

        var colorAl = resources.getStringArray(R.array.androidcolors)



        fab_start.setOnClickListener { v ->
            startTime()
            changeColor()
            fab_start.isClickable = false

        }


    }

    fun startTime() {
        val timer = object : CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txt_contador.setText("" + millisUntilFinished / 1000)

            }

            override fun onFinish() {
                fab_start.isClickable = true
                txt_contador.setText("")

            }
        }

        timer.start()
    }

    private fun setAlphas(): ArrayList<ItemColor> {

       //
       // var rnd = Random()

        var arrayList: ArrayList<ItemColor> = ArrayList()


        arrayList.add(ItemColor(color =  R.color.colorAccent))
        arrayList.add(ItemColor(color =   R.color.colorPrimary))
        arrayList.add(ItemColor(color =   R.color.colorAccent))

        arrayList.add(ItemColor(color =  R.color.colorAccent))
        arrayList.add(ItemColor(color =   R.color.colorPrimary))
        arrayList.add(ItemColor(color =   R.color.colorAccent))

        arrayList.add(ItemColor(color =  R.color.colorAccent))
        arrayList.add(ItemColor(color =   Color.parseColor("#ffffff")))
        arrayList.add(ItemColor(color =   R.color.colorAccent))

        arrayList.add(ItemColor(color =  R.color.colorAccent))
        arrayList.add(ItemColor(color =   R.color.colorPrimary))
        arrayList.add(ItemColor(color =   R.color.colorAccent))





        return arrayList
    }

    fun changeColor() {
        var rnd = Random()
        var color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        txt_color.setBackgroundColor(color)
        itemImageColor.setBackgroundColor(color)

        if (itemImageColor == txt_color) {


        }
    }
}