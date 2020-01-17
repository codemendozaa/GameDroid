package com.codemen.gamedroid


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.github.lzyzsd.randomcolor.RandomColor
import kotlinx.android.synthetic.main.item_color_row.*
import java.util.*


class MainAdapter (private  val context : Context, var arrayList: ArrayList<ItemColor>) : RecyclerView.Adapter<MainAdapter.ItemHolder>() {

    init {
        println("dsfsdfsd")
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val viewHolder  = LayoutInflater.from(context).inflate(R.layout.item_color_row,parent,false)

        return ItemHolder(viewHolder)

    }

    override fun getItemCount(): Int {

        return arrayList.size

    }

    override fun onBindViewHolder(holder:ItemHolder, position: Int) {


        holder.colors.setBackgroundColor(arrayList[position].color)

        holder.colors.setOnClickListener {
            Toast.makeText(context, "Seleccionado", Toast.LENGTH_LONG).show()
        }


       // holder.colors.setBackgroundColor(randomColor.randomColor())
    }

        class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var colors = itemView.findViewById<TextView>(R.id.itemImageColor)





        }
}

