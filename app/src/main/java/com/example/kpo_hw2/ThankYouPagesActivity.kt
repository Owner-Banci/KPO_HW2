package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class ThankYouPagesActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you_pages)

        val order = OrderManager.getInstance()
        val restaurantAttributes = RestaurantAttributes()
        val linkToMenu: TextView = findViewById(R.id.TYP_link_to_menu)
        val listView = findViewById<ListView>(R.id.TYPItemList)
        val cancelButton: Button = findViewById(R.id.cancelButton)
        val updateButton: Button = findViewById(R.id.updateButton)
        val payButton: Button = findViewById(R.id.payButton)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listView.adapter = adapter

        linkToMenu.setOnClickListener {
            val intent = Intent(this, ItemsActivity::class.java)
            startActivity(intent)
        }

        val uniqueItems = order.items.distinctBy { it.name } //vovodim tolko unikalniye obyekti
        uniqueItems.forEachIndexed { index, item ->
            adapter.insert("Оценить: ${item.name}, Статус: ${order.status}", index)
            if (order.status == OrderStatus.PAID || order.status == OrderStatus.CANCELED) {
                order.items.clear()
            }
        }

        fun extractDishName(text: String): String {
            val startIndex = text.indexOf("Оценить:") + "Оценить:".length
            val endIndex = text.indexOf(",", startIndex)
            return text.substring(startIndex, endIndex).trim()
        }

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val itemName = extractDishName(listView.getItemAtPosition(i).toString())
            Toast.makeText(this, "Вы нажали на кнопку: $itemName", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("itemName", itemName)
            startActivity(intent)

        }


        updateButton.setOnClickListener {
            val intent = Intent(this, ThankYouPagesActivity::class.java)
            startActivity(intent)
        }

        cancelButton.setOnClickListener {
            order.status = OrderStatus.CANCELED
            val intent = Intent(this, ThankYouPagesActivity::class.java)
            startActivity(intent)
        }

        payButton.setOnClickListener {
            if (order.status == OrderStatus.READY) {
                restaurantAttributes.addRevenue(order.totalPrice().toDouble())  //Пополняем казну ресторана
                order.status = OrderStatus.PAID
                val intent = Intent(this, ThankYouPagesActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Заказ ещё не готов", Toast.LENGTH_LONG).show()
            }
        }

    }

}

