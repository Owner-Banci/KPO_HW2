package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdminActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val button: Button = findViewById(R.id.add_food)
        val updateButton: Button = findViewById(R.id.updateButton_admin)
        val linkToStatistics: Button = findViewById(R.id.link_to_statistics)
        val linkToMenu: TextView = findViewById(R.id.link_to_menu_admin)
        val itemsListAdmin: RecyclerView = findViewById(R.id.itemsListAdmin)
        val items = MenuManager.getInstance()
        val order = OrderManager.getInstance()


//        items.addItem(MenuItem("burger", 45, 36, 4799.99))


        button.setOnClickListener {
            val intent = Intent(this, AddFoodActivity::class.java)
            startActivity(intent)
        }

        linkToMenu.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        linkToStatistics.setOnClickListener {
            val intent = Intent(this, StatisticsActivity::class.java)
            startActivity(intent)
        }

        updateButton.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }


        itemsListAdmin.layoutManager = LinearLayoutManager(this)
        itemsListAdmin.adapter = AdminItemsAdapter(items, this)
    }
}