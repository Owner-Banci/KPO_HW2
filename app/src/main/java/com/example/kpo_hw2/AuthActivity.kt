package com.example.kpo_hw2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener {
            val intent1 = Intent(this, MainActivity::class.java) //perehod na druguyu stranisu
            startActivity(intent1)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == "") {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            } else {
                val db = DbHelper.getInstance(this)
                val isAuth = db.getUser(login, pass)

                if (isAuth) {
                    Toast.makeText(this, "Пользователь $login avtarizovan", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()

                    if (login.endsWith("_ad")) {
                        val intent3 = Intent(this, AdminActivity::class.java)
                        startActivity(intent3)
                    } else {
                        val intent2 = Intent(this, ItemsActivity::class.java)
                        startActivity(intent2)
                    }
                } else {
                    Toast.makeText(this, "Пользователь $login NE avtarizovan", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}