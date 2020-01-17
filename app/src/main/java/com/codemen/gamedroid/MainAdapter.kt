package com.codemen.gamedroid


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.github.lzyzsd.randomcolor.RandomColor

class MainAdapter (private  val context : Context, var arrayList: ArrayList<ItemColor>) :
    RecyclerView.Adapter<MainAdapter.ItemHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val viewHolder  = LayoutInflater.from(context).inflate(R.layout.item_color_row,parent,false)

        return ItemHolder(viewHolder)

    }

    override fun getItemCount(): Int {

        return arrayList.size

    }

    override fun onBindViewHolder(holder:ItemHolder, position: Int) {

        val itemColor: ItemColor = arrayList.get(position)
        var randomColor = RandomColor()
        //holder.colors.setImageResource(itemColor.icons!!)
        holder.colors.text = itemColor.imageColor
        holder.titles.text = itemColor.alpha

        holder.colors.setOnClickListener {
            Toast.makeText(context, itemColor.alpha, Toast.LENGTH_LONG).show()
        }

        holder.colors.setBackgroundColor(randomColor.randomColor())
    }

        class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            var colors = itemView.findViewById<TextView>(R.id.itemImageColor)
            var titles = itemView.findViewById<TextView>(R.id.title_text_view)







        }
}
