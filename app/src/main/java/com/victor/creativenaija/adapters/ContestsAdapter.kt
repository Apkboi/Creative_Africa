package com.victor.creativenaija.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.victor.creativenaija.R
import com.victor.creativenaija.models.Contest

class ContestsAdapter : RecyclerView.Adapter<ContestsAdapter.ContestsItemHolder>() {

    var contests: ArrayList<Contest> = arrayListOf()
    fun setContest(contests: ArrayList<Contest>) {
        this.contests = contests

    }

    public class ContestsItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContestsItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contest_item, parent, false)
        return ContestsItemHolder(view)
    }

    override fun onBindViewHolder(holder: ContestsItemHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.txtContestTittle).setText(contests[position].contestDetails)
    }

    override fun getItemCount(): Int {
       return contests.size

    }
}