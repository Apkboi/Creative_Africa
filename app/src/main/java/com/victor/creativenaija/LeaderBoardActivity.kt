package com.victor.creativenaija

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.victor.creativenaija.adapters.ContestantsAdapter
import com.victor.creativenaija.databinding.ActivityLeaderBoardBinding
import com.victor.creativenaija.databinding.VoteDialogBinding
import com.victor.creativenaija.interfaces.VoteIneractionListener
import com.victor.creativenaija.utils.Constants
import androidx.appcompat.app.AlertDialog as AlertDialog1

class LeaderBoardActivity : AppCompatActivity(), VoteIneractionListener {

    //    private lateinit var dialog:AlertDialog.Builder
//    private lateinit var alertDialog:Dialog
//    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLeaderBoardBinding =
            ActivityLeaderBoardBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
//        alertDialog =Dialog(this)
//        val voteBinding = VoteDialogBinding.bind(LayoutInflater.from(this).inflate(R.layout.vote_dialog,null)).root
//        val view2:View =layoutInflater.inflate(R.layout.vote_dialog,null)
//
//        alertDialog.setContentView(view2)
//        alertDialog = dialog.create()


        val adapter = ContestantsAdapter()
        binding.contestantsRecycler.adapter = adapter
        adapter.setVoteInteractionListener(this)

        binding.btnJoin.setOnClickListener {
            startActivityForResult(
                Intent(
                    this,
                    JoinContestActivity::class.java
                ), Constants.JOIN_REQUEST_CODE
            )
        }

    }

    @SuppressLint("InflateParams")
    override fun onVoteClicked() {

        val view2: View = layoutInflater.inflate(R.layout.vote_dialog, null, false)
        val dialog = AlertDialog.Builder(this)
        dialog.setView(view2)
        val alertDialog: AlertDialog = dialog.create()
//        alertDialog.setContentView(view2)
        alertDialog.show()

        Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}

