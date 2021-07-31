package com.victor.creativenaija

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.victor.creativenaija.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        var binding :ActivityMainBinding? = null
//        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
//        val  view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        navView.setBackgroundColor(Color.TRANSPARENT)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_raffle_draw, R.id.navigation_contest))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



        fab.setOnClickListener { startActivity(Intent(this,ProfileActivity::class.java)) }
    }
}