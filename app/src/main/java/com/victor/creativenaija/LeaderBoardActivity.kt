package com.victor.creativenaija

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.material.button.MaterialButton
import com.victor.creativenaija.adapters.ContestantsAdapter
import com.victor.creativenaija.databinding.ActivityLeaderBoardBinding
import com.victor.creativenaija.databinding.VoteDialogBinding
import com.victor.creativenaija.interfaces.VoteIneractionListener
import com.victor.creativenaija.utils.Constants
import androidx.appcompat.app.AlertDialog as AlertDialog1

class LeaderBoardActivity : AppCompatActivity(), VoteIneractionListener,OnUserEarnedRewardListener {

    //    private lateinit var dialog:AlertDialog.Builder
//    private lateinit var alertDialog:Dialog
//    @SuppressLint("InflateParams")
    private var mRewardedAd: RewardedAd? = null
    lateinit var alertDialog: AlertDialog
    private var TAG = "MainActivity"
    lateinit var adRequest:AdRequest
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



         adRequest = AdRequest.Builder().build()

        mRewardedAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad was shown.")
            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                // Called when ad fails to show.
                Log.d(TAG, "Ad failed to show.")
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                Log.d(TAG, "Ad was dismissed.")
                mRewardedAd = null
            }
        }


//              Loading the Ad

        RewardedAd.load(
            this,
            "ca-app-pub-3940256099942544/5224354917",
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError?.message)
                    mRewardedAd = null
                }

                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    Log.d(TAG, "Ad was loaded.")
                    mRewardedAd = rewardedAd
                }
            })


    }


//    Event To Happen When Vote is Clicked
    @SuppressLint("InflateParams")
    override fun onVoteClicked() {

        val view2: View = layoutInflater.inflate(R.layout.vote_dialog, null, false)
        val dialog = AlertDialog.Builder(this)
        dialog.setView(view2)
         alertDialog = dialog.create()
//        alertDialog.setContentView(view2)
        alertDialog.show()


//                           The Watch Ad Event

        view2.findViewById<LinearLayout>(R.id.watch_ad).setOnClickListener {

            if (mRewardedAd != null) {
                mRewardedAd?.show(this, this)
                RewardedAd.load(
                    this,
                    "ca-app-pub-3940256099942544/5224354917",
                    adRequest,
                    object : RewardedAdLoadCallback() {
                        override fun onAdFailedToLoad(adError: LoadAdError) {
                            Log.d(TAG, adError?.message)
                            mRewardedAd = null
                        }

                        override fun onAdLoaded(rewardedAd: RewardedAd) {
                            Log.d(TAG, "Ad was loaded.")
                            mRewardedAd = rewardedAd
                        }
                    })

            } else {
                Log.d(TAG, "The rewarded ad wasn't ready yet.")
            }
        }

        Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onUserEarnedReward(p0: RewardItem) {
        Toast.makeText(this,"Voted",Toast.LENGTH_LONG).show()
        alertDialog.dismiss()

//        TODO("Not yet implemented")
    }
}

