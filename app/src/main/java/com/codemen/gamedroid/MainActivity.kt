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
    private var colorUsed : ArrayList<Int> = ArrayList()
    private var mainColor : Int = 0


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
                changeColor()
            }
        }

        timer.start()
    }

    private fun setAlphas(): ArrayList<ItemColor> {

        val arrayList: ArrayList<ItemColor> = ArrayList()

        arrayList.add(ItemColor(color =   Color.MAGENTA))
        arrayList.add(ItemColor(color =   Color.BLACK))
        arrayList.add(ItemColor(color =   Color.YELLOW))

        arrayList.add(ItemColor(color =   Color.CYAN))
        arrayList.add(ItemColor(color =   Color.GREEN))
        arrayList.add(ItemColor(color =   Color.GRAY))

        arrayList.add(ItemColor(color =   Color.BLUE))
        arrayList.add(ItemColor(color =   Color.DKGRAY))
        arrayList.add(ItemColor(color =   Color.RED))

        arrayList.add(ItemColor(color =  Color.LTGRAY))
        arrayList.add(ItemColor(color =   Color.parseColor("#00574B")))
        arrayList.add(ItemColor(color =   Color.parseColor("#FFFFBB33")))


        return arrayList
    }

    fun changeColor() {
        //var rnd = Random()

        //var color: Int = Color.argb(255, rnd.nextInt(255), rnd.nextInt(256), rnd.nextInt(256))
        mainColor = Random().nextInt(12 )
        var color: Int = itemColor[mainColor].color
        txt_color.setBackgroundColor(color)

        //itemImageColor.setBackgroundColor(color)
        colorUsed = ArrayList<Int>()

        mainAdapter?.setConfig(colorUsed, mainColor)


    }

}