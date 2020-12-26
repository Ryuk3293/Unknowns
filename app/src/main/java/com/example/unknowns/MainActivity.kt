package com.example.unknowns

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.unknowns.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val homeFragment = HomeFragment()
        val addFragment = AddFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(homeFragment)

        BottomNavigationView.OnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home->setCurrentFragment(homeFragment)
                R.id.menu_add->setCurrentFragment(addFragment)
                R.id.menu_profile->setCurrentFragment(profileFragment)
            }
            true
        }


//        binding.signOutButton.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            signOut()
//            finish()
//        }


    }


    private fun signOut() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("USER_KEY",0)
        editor.apply()
        editor.commit()
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }

}