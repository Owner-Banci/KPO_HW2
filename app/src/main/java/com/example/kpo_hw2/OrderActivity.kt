package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val itemsList: RecyclerView = findViewById(R.id.orderItemList)
        val totalPrice: TextView = findViewById(R.id.orderlist_price)
        val totalTime: TextView = findViewById(R.id.orderlist_totaltime)
        val linkToMenu: TextView = findViewById(R.id.link_to_menu)
        val linkToTYP: Button = findViewById(R.id.linkToTYPButton)
        val order = OrderManager.getInstance()
        val kitchen = Kitchen()


        kitchen.startPreparing(order)
        order.status = OrderStatus.ACCEPTED

        Toast.makeText(this, "Началась обработка заказа", Toast.LENGTH_LONG).show()

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = OrderItemAdapter(order, this)



        totalPrice.text = order.totalPrice() + " ₽"
        totalTime.text = order.totalTime(order.items) + " сек"

        linkToMenu.setOnClickListener {
            val intent = Intent(this, ItemsActivity::class.java)
            startActivity(intent)
        }


        linkToTYP.setOnClickListener {
            val intent = Intent(this, ThankYouPagesActivity::class.java)
            startActivity(intent)
        }

    }


}