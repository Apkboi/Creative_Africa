package com.victor.creativenaija

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.victor.creativenaija.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding :ActivitySignUpBinding
        binding = ActivitySignUpBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
        val sexes = arrayOf("Male", "Female")
        binding.sexSpinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,sexes)
    }
}