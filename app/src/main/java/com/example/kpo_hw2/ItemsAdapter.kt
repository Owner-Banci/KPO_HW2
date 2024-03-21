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


class ItemsAdapter(private var menu: Menu, private var context: Context) :
    RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onPlusClick(position: Int)
        fun onMinusClick(position: Int)
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val name: TextView = view.findViewById(R.id.item_list_name)
        val time: TextView = view.findViewById(R.id.item_list_time)
        val count: TextView = view.findViewById(R.id.item_list_count)
        val price: TextView = view.findViewById(R.id.item_list_price)
        val btnMinus: Button = view.findViewById(R.id.btn_minus)
        val btnPlus: Button = view.findViewById(R.id.btn_plus)
        val quantityText: TextView = view.findViewById(R.id.quantity_text)


        init {
            btnPlus.setOnClickListener {
                listener?.onPlusClick(adapterPosition)
            }

            btnMinus.setOnClickListener {
                listener?.onMinusClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menu.items.size
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val order = OrderManager.getInstance()
        val currentItem = menu.items[position]

        holder.name.text = currentItem.name
        holder.time.text =
            "Время приготовления: ${currentItem.preparationTime} сек"  //Устанавливаем значения для дизайна блюд
        holder.count.text = "Количество: ${currentItem.count} шт"
        holder.price.text = "${currentItem.price} ₽"


        holder.btnPlus.setOnClickListener {//Добавляем блюдо в заказ при нажатии на кнопку, также увеличиваем счетчик между кнопками
            val quantity = holder.quantityText.text.toString().toInt()

            if (currentItem.count == 0) {
                menu.items.remove(currentItem)
            }
            if (currentItem.count > 0) {
                holder.quantityText.text = (quantity + 1).toString()

                order.items.add(currentItem)

                holder.count.text = "Количество: ${currentItem.deminishCount()} шт"

                Toast.makeText(context, "Заказ ${currentItem.name} добавлен", Toast.LENGTH_LONG).show()
            }

        }

        holder.btnMinus.setOnClickListener {//Удаляем блюдо из заказа, при нажатии на кнопку, также убавляем счётчик между кнопками
            val quantity = holder.quantityText.text.toString().toInt()
            if (quantity > 0) {
                holder.quantityText.text = (quantity - 1).toString()

                order.items.remove(currentItem)
                holder.count.text = "Количество: ${currentItem.decriseCount()} шт"
                Toast.makeText(context, "Заказ ${currentItem.name} удален", Toast.LENGTH_LONG).show()
            }
        }
    }
}

