package com.codemen.gamedroid


import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.codemen.gamedroid.R.id.itemImageColor
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainAdapter(
    private val context: Context,
    private var arrayList: ArrayList<ItemColor>,
    private var mainActivity: MainActivity

) :
    RecyclerView.Adapter<MainAdapter.ItemHolder>() {


    private var colorUsed: ArrayList<Int> = ArrayList()
    private var mainColor: Int? = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val viewHolder =
            LayoutInflater.from(context).inflate(R.layout.item_color_row, parent, false)

        return ItemHolder(viewHolder)

    }

    override fun getItemCount(): Int {

        return arrayList.size

    }

    private fun selectColor(): Int {
        val position: Int = Random().nextInt(12)
        for (color in this.colorUsed) {
            if (color == position) {
                return selectColor()
            }
        }
        return position
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {


        val positionRm: Int = selectColor()
        val color: Int = arrayList[positionRm].color
        colorUsed.add(positionRm)

        holder.colors.setBackgroundColor(color)


        holder.colors.setOnClickListener {
            if (mainActivity.validateClick) {

                //  Toast.makeText(context, " Debes dar Play ", Toast.LENGTH_SHORT).show()

                if (mainColor == positionRm) {

                    val mp = MediaPlayer.create(mainActivity, R.raw.beep_05)
                    mp.start()
                    Toast.makeText(
                        context,
                        "Buen trabajo!!",
                        Toast.LENGTH_SHORT
                    ).show()
                    mainActivity.success++

                    mainActivity.txt_acertada.text = "Buenas:" + mainActivity.success

                } else {


                    val vibe: Vibrator =
                        mainActivity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    val effect: VibrationEffect =
                        VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE)


                    vibe.vibrate(effect)
                    Toast.makeText(context, " ohh intenta otro vez..", Toast.LENGTH_SHORT).show()
                    mainActivity.errores++

                    mainActivity.txt_error.text = "Error:" + mainActivity.errores
                }

                mainActivity.changeColor()
            }
        }

    }

    fun setConfig(colorUsed: ArrayList<Int>, mainColor: Int) {
        this.colorUsed = colorUsed
        this.mainColor = mainColor
    }


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var colors: TextView = itemView.findViewById(itemImageColor)

    }
}

