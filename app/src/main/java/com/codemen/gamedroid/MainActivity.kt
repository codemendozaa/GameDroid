package com.codemen.gamedroid

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Vibrator
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var countDownTimer: CountDownTimer


    private var recyclerView: RecyclerView? = null
    lateinit var itemColor: ArrayList<ItemColor>
    private var gridLayoutManager: GridLayoutManager? = null
    private var mainAdapter: MainAdapter? = null
    private var colorUsed: ArrayList<Int> = ArrayList()
    private var mainColor: Int = 0
    var success: Int = 0
    var errores: Int = 0
    var validateClick = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)

        gridLayoutManager =
            GridLayoutManager(this, 3)
        recyclerView?.layoutManager = gridLayoutManager


        itemColor = ArrayList()
        itemColor = setAlphas()
        mainAdapter = MainAdapter(applicationContext, itemColor, this)
        recyclerView?.adapter = mainAdapter



        fab_start.setOnClickListener { v ->
            startTime()
            changeColor()
            reset()
            fab_start.isClickable = false
            validateClick = true


        }


    }

    fun startTime() {
        val timer = object : CountDownTimer(11000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txt_contador.setText("" + millisUntilFinished / 1000)


            }

            override fun onFinish() {
                fab_start.isClickable = true
                txt_contador.setText("")
                alertDialogo()
                validateClick = false


            }

        }

        timer.start()
    }

    private fun setAlphas(): ArrayList<ItemColor> {

        val arrayList: ArrayList<ItemColor> = ArrayList()

        arrayList.add(ItemColor(color = Color.MAGENTA))
        arrayList.add(ItemColor(color = Color.BLACK))
        arrayList.add(ItemColor(color = Color.YELLOW))

        arrayList.add(ItemColor(color = Color.CYAN))
        arrayList.add(ItemColor(color = Color.GREEN))
        arrayList.add(ItemColor(color = Color.GRAY))

        arrayList.add(ItemColor(color = Color.BLUE))
        arrayList.add(ItemColor(color = Color.DKGRAY))
        arrayList.add(ItemColor(color = Color.RED))

        arrayList.add(ItemColor(color = Color.LTGRAY))
        arrayList.add(ItemColor(color = Color.parseColor("#00574B")))
        arrayList.add(ItemColor(color = Color.parseColor("#FFFFBB33")))


        return arrayList
    }

    fun changeColor() {

        mainColor = Random().nextInt(12)
        var color: Int = itemColor[mainColor].color
        txt_color.setBackgroundColor(color)

        colorUsed = ArrayList()

        mainAdapter?.setConfig(colorUsed, mainColor)

        //TODO..Refrescar el componento recyclerView.
        mainAdapter?.notifyDataSetChanged()


    }

    fun alertDialogo() {

        val builder = AlertDialog.Builder(this@MainActivity)

        // Set the alert dialog title
        builder.setTitle("Tu partida a Terminado")

        // Display a message on alert dialog
        builder.setMessage(
            "Este fue Tu resultado:" + " "
                    + "Acertadas:" + " " + success++
                    + " " + "Errores:" + " " + errores++
                    + " "
                    + "¿Deseas seguir jugando?"
        )


        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("YES") { dialog, which ->
            // Do something when user press the positive button
            Toast.makeText(applicationContext, "Ok,Buena suerte.", Toast.LENGTH_SHORT).show()
            reset()
            validateClick = false
        }

        // Display a negative button on alert dialog
        builder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(applicationContext, "Hasta pronto.", Toast.LENGTH_SHORT).show()
            finish()
        }


        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()

    }

    fun reset() {

        if (success >= 0 || errores >= 0) {
            txt_error.setText("")
            txt_acertada.setText("")
            success = 0
            errores = 0

        }
    }
}