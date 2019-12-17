package com.codemen.gamedroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_color_row.view.*

class MainAdapter (private  val context : Context) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    private  var dataList = mutableListOf<ItemColor>()

    fun setListData(data:MutableList<ItemColor>){

        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_color_row,parent,false)

        return MainViewHolder(view)

    }

    override fun getItemCount(): Int {

        return if (dataList.size > 0 ){
            dataList.size
        }else{
            0
        }

    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {

        val item:ItemColor = dataList[position]
        holder.binView(item)

    }

    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun  binView(item: ItemColor){

            //itemView.itemImageColor.text = item.imageColor



        }
    }
}