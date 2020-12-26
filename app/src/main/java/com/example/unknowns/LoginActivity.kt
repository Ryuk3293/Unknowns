package com.example.unknowns

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.unknowns.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isLoggedIn()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java);
            loggedIn()
            startActivity(intent)
            finish()

        }

    }

    private fun isLoggedIn() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val loginStatus = sharedPreferences.getInt("USER_KEY", 0)

        if (loginStatus == 1){
            val intent = Intent(this, HomeActivity::class.java);
            startActivity(intent)
            finish()
        }
    }

    private fun loggedIn() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("USER_KEY",1)
        editor.apply()
        editor.commit()
    }

}