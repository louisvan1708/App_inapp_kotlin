package com.example.app_inapp_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_inapp_kotlin.R
import com.example.app_inapp_kotlin.Ironman


class ironmanAdapter(private val ironmanList:ArrayList<Ironman>): RecyclerView.Adapter<ironmanAdapter.IronmanViewHolder>(){

    var onItemCick : ((Ironman) -> Unit)? = null

    class IronmanViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imgironman)
        val tvName : TextView = itemView.findViewById(R.id.tvName)
        val tvPrice : TextView = itemView.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IronmanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ironman,parent,false)
        return IronmanViewHolder(view)
    }

    override fun onBindViewHolder(holder: IronmanViewHolder, position: Int) {
        val ironman = ironmanList[position]
        holder.tvName.text = ironman.name
        holder.tvPrice.text = ironman.price
        holder.imageView.setImageResource(ironman.img)

        holder.itemView.setOnClickListener {
            onItemCick?.invoke(ironman)
        }
    }

    override fun getItemCount(): Int {
        return ironmanList.size
    }

}
