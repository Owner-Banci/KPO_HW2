package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AddFoodActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        val inputName: EditText = findViewById(R.id.food_name)
        val inputTime: EditText = findViewById(R.id.food_time)
        val inputCount: EditText = findViewById(R.id.food_count)
        val inputPrice: EditText = findViewById(R.id.food_price)
        val linkToAdminMenu: TextView = findViewById(R.id.link_to_menu_ad)
        val button: Button = findViewById(R.id.food_add_btn)

        linkToAdminMenu.setOnClickListener {
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }

        fun String.isInt(): Boolean {
            return this.toIntOrNull() != null
        }

        button.setOnClickListener {
            val name = inputName.text.toString().trim()
            val time = inputTime.text.toString().trim()
            val count = inputCount.text.toString().trim()
            val price = inputPrice.text.toString().trim()

            val isIntTime: Boolean = time.isInt()
            val isIntCount: Boolean = count.isInt()
            val isIntPrice: Boolean = price.toDoubleOrNull() != null


            if (name.isEmpty() || time.isEmpty() || count.isEmpty() || price.isEmpty()) {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else if (!isIntTime) {
                Toast.makeText(this, "Время приготовления задано некорректно", Toast.LENGTH_LONG).show()
            } else if (!isIntCount) {
                Toast.makeText(this, "Количество блюд задано некорректно", Toast.LENGTH_LONG).show()
            } else if (!isIntPrice) {
                Toast.makeText(this, "Цена указана некорректно", Toast.LENGTH_LONG).show()
            } else {
                val menu = MenuManager.getInstance()
                val item = MenuItem(name, time.toInt(), count.toInt(), price.toDouble())

                menu.addItem(item)
                Toast.makeText(this, "Блюдо $name добавлено", Toast.LENGTH_LONG).show()

                inputName.text.clear()
                inputTime.text.clear()
                inputCount.text.clear()
                inputPrice.text.clear()
            }
        }

    }
}