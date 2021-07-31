package com.victor.creativenaija

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.victor.creativenaija.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding:ActivityProfileBinding? = null
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)

        binding.cardAccount.setOnClickListener {
            startActivity(Intent(this,AccountActivity::class.java))
        }
    }
}