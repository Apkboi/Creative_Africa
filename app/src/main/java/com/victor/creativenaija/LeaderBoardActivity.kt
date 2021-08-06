package com.victor.creativenaija

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.victor.creativenaija.adapters.ContestantsAdapter
import com.victor.creativenaija.databinding.ActivityLeaderBoardBinding

class LeaderBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityLeaderBoardBinding
        binding = ActivityLeaderBoardBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)

        val adapter = ContestantsAdapter()
        binding.contestantsRecycler.adapter = adapter

    }
}