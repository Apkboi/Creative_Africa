package com.victor.creativenaija

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.victor.creativenaija.adapters.ComentsAdapter
import com.victor.creativenaija.databinding.ActivityPostBinding
import com.victor.creativenaija.models.Comment
import com.victor.creativenaija.models.Post

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding:ActivityPostBinding? = null
        binding = ActivityPostBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)
        val intent:Intent = getIntent()
       val post= intent.getSerializableExtra("post") as Post

        val adapter = ComentsAdapter()
        adapter.setComments(Comment(1,1,"",7656).getComments())
        binding.commentsRecycler.adapter = adapter


    }
}