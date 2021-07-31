package com.victor.creativenaija.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.victor.creativenaija.R
import com.victor.creativenaija.models.Comment

class ComentsAdapter : RecyclerView.Adapter<ComentsAdapter.CommentItemHolder>() {

    var comments:ArrayList<Comment> = arrayListOf()
    @JvmName("setComments1")
    fun setComments(comments:ArrayList<Comment>){
        this.comments = comments

    }
    public class CommentItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comments_item,parent,false)
        return CommentItemHolder(view)
    }

    override fun onBindViewHolder(holder: CommentItemHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.txtComment).setText(comments[position].comment)
    }

    override fun getItemCount(): Int {
      return comments.size
    }
}