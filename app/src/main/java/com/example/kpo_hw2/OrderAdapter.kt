package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderItemAdapter(private var order: Order, private var context: Context) :
    RecyclerView.Adapter<OrderItemAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.item_list_image_order)
        val name: TextView = view.findViewById(R.id.item_list_name_order)
        val time: TextView = view.findViewById(R.id.item_list_time_order)
        val price: TextView = view.findViewById(R.id.item_list_price_order)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_orderlist, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return order.items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = order.items[position]
        holder.name.text = currentItem.name
        holder.time.text = "Время приготовления: ${currentItem.preparationTime} сек"
        holder.price.text = "${currentItem.price} ₽"
    }

}