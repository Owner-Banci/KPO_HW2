package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val button: Button = findViewById(R.id.item_list_button)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val menu = MenuManager.getInstance()

//        menu.addItem(MenuItem("Steak", 2, 45, 1999.99))
//        menu.addItem(MenuItem("Burger", 3, 73, 4799.99)) //Добавляем в список новые позиции меню
//        menu.addItem(MenuItem("Pizza", 4, 21, 9999.99))


        itemsList.layoutManager = LinearLayoutManager(this) //Передаем в конструктор адаптера, контекст и меню
        itemsList.adapter = ItemsAdapter(menu, this)


        button.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

    }
}