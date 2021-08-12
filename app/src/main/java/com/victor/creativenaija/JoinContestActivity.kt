package com.victor.creativenaija

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.victor.creativenaija.databinding.ActivityJoinContestBinding

class JoinContestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityJoinContestBinding
        binding = ActivityJoinContestBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)

        val list = arrayOf("Singer", "Dancer", "Photographer", "Poet", "Model")

        binding.categorySpinner.isFocusable = false

        binding.categorySpinner.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list)
    }
}