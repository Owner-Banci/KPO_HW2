package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val restaurantAttributes = RestourantManager.getInstance()
        var foodRating = -1
        val itemName = intent.getStringExtra("itemName")

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonReview = findViewById<Button>(R.id.button_auth)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            foodRating = when (checkedId) {
                R.id.rating1 -> 1
                R.id.rating2 -> 2
                R.id.rating3 -> 3
                R.id.rating4 -> 4
                R.id.rating5 -> 5
                else -> -1
            }
        }

        buttonReview.setOnClickListener {
            if (foodRating != -1) {
                if (itemName != null) {
                    restaurantAttributes.addRating(itemName, foodRating)
                }
                Toast.makeText(this, "Ваша оценка: $itemName : $foodRating сохранена", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ThankYouPagesActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Пожалуйста, выберите оценку", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
