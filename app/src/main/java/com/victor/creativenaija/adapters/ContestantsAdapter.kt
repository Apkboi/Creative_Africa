package com.victor.creativenaija.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.victor.creativenaija.R
import com.victor.creativenaija.interfaces.VoteIneractionListener
import com.victor.creativenaija.models.Contestants

class ContestantsAdapter(): RecyclerView.Adapter<ContestantsAdapter.ContestantsItemHolder>() {



   private var contestantsList:ArrayList<Contestants> = arrayListOf()
    private var voteIneractionListener: VoteIneractionListener? = null

    fun setVoteInteractionListener(voteIneractionListener: VoteIneractionListener){
        this.voteIneractionListener = voteIneractionListener
    }

    fun setContestants (contestantsList:ArrayList<Contestants>){
        this.contestantsList = contestantsList

    }

    public class ContestantsItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContestantsItemHolder {
//        TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.leader_board_item,parent,false)
        return ContestantsItemHolder(view)
    }

    override fun onBindViewHolder(holder: ContestantsItemHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.txt_position).setText((position+1).toString())
        holder.itemView.findViewById<LinearLayout>(R.id.btn_vote).setOnClickListener { voteIneractionListener?.onVoteClicked() }

//        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
        return 5
    }
}