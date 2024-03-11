package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StatisticsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val mostPopularItem: TextView = findViewById(R.id.most_popular_food_name1)
        val avarageFoodRating: TextView = findViewById(R.id.avarage_food_rating2)
        val mostHighAvarageRating: TextView = findViewById(R.id.highest_rated_food1)
        val mostLowAvarageRating: TextView = findViewById(R.id.lowhigh_food_rating1)
        val endView: Button = findViewById(R.id.end_view)
        val order = OrderManager.getInstance()
        val restaurantAttributes = RestourantManager.getInstance()


        val mostCommonItemName = order.mostCommonItemName()
        mostPopularItem.text = mostCommonItemName

        val averageRating = restaurantAttributes.averageRating()
        avarageFoodRating.text = averageRating.toString()

        val high = restaurantAttributes.findDishWithMaxAverageRating()
        mostHighAvarageRating.text = high

        val low = restaurantAttributes.findDishWithMinAverageRating()
        mostLowAvarageRating.text = low

        endView.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }
    }
}