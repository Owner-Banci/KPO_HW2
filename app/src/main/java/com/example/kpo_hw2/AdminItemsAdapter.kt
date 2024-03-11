package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView


class AdminItemsAdapter(private var menu: Menu, private var context: Context) :
    RecyclerView.Adapter<AdminItemsAdapter.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.item_list_image_admin)
        val name: TextView = view.findViewById(R.id.item_list_name_admin)
        val time: TextView = view.findViewById(R.id.item_list_time_admin)
        val count: TextView = view.findViewById(R.id.item_list_count_admin)
        val price: TextView = view.findViewById(R.id.item_list_price_admin)
        val button: Button = view.findViewById(R.id.item_list_admin_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_in_list_admin, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menu.items.size
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val menu = MenuManager.getInstance()
        val currentItem = menu.items[position]
        holder.name.text = currentItem.name
        holder.time.text = "Время приготовления: ${currentItem.preparationTime} сек"
        holder.count.text = "Количество: ${currentItem.count} шт"
        holder.price.text = "${currentItem.price} ₽"

        holder.button.setOnClickListener {
            menu.removeItem(position)
            Toast.makeText(context, "Заказ ${currentItem.name} удален", Toast.LENGTH_LONG).show()
        }
    }
}