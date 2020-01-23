package com.codemen.gamedroid


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainAdapter( private val context: Context, var arrayList: ArrayList<ItemColor>, var mainActivity: MainActivity) :
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

    fun selectColor(): Int {
        var position: Int = Random().nextInt(12)
        for (color in this.colorUsed) {
            if (color === position) {
                return selectColor()
            }
        }
        return position
    }



    override fun onBindViewHolder(holder: ItemHolder, position: Int) {



            var positionRm: Int = selectColor()
            var color: Int = arrayList[positionRm].color
            colorUsed.add(positionRm)
            if (colorUsed.size === 10) {
                holder.colors.setBackgroundColor(color)
            }

        holder.colors.setBackgroundColor(color)
        holder.colors.setOnClickListener {

            if (mainColor === positionRm) {
                Toast.makeText(context, "Buen trabajo!!"+ mainActivity.success, Toast.LENGTH_SHORT).show()
                mainActivity.success++
                mainActivity.txt_acertada.setText("Correctas:"+mainActivity.success)

            } else {

                Toast.makeText(context, " ohh intenta otro vez..", Toast.LENGTH_SHORT).show()
                mainActivity.errores++
                mainActivity.txt_error.setText("Error:"+mainActivity.errores)



            }

            mainActivity.changeColor()

        }

    }

    fun setConfig(colorUsed: ArrayList<Int>, mainColor: Int) {
        this.colorUsed = colorUsed
        this.mainColor = mainColor
    }


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var colors = itemView.findViewById<TextView>(R.id.itemImageColor)

    }
}

