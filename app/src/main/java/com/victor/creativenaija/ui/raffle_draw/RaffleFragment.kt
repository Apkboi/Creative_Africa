package com.victor.creativenaija.ui.raffle_draw

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.*
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.victor.creativenaija.R
import com.victor.creativenaija.adapters.RafflePlanAdapter
import com.victor.creativenaija.databinding.FragmentRaffleDrawBinding
import com.victor.creativenaija.interfaces.BuyTicketListener

class RaffleFragment : Fragment(),BuyTicketListener,OnUserEarnedRewardListener {

    private lateinit var raffleViewModel: RaffleViewModel
    private var _binding: FragmentRaffleDrawBinding? = null
    private val binding get() = _binding!!
    private var mRewardedAd: RewardedAd? = null
    lateinit var adRequest: AdRequest
    val TAG = "Raffle Fragment"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        raffleViewModel =
            ViewModelProvider(this).get(RaffleViewModel::class.java)
        _binding = FragmentRaffleDrawBinding.inflate(layoutInflater, container, false)

//        val root = inflater.inflate(R.layout.fragment_raffle_draw, container, false)
//
        val view = binding.root

        val adapter = RafflePlanAdapter()
        adapter.setBuyTicketListener(this)
        binding.planRecycler.adapter = adapter
        adRequest = AdRequest.Builder().build()



//        mAdManagerAdView = findViewById(R.id.adManagerAdView)

        val adRequest = AdManagerAdRequest.Builder().build()
        binding.adManagerAdView.loadAd(adRequest)

        binding.adManagerAdView.adListener = object : AdListener() {
            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdClosed() {

                super.onAdClosed()
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                Toast.makeText(context, p0.message, Toast.LENGTH_LONG).show()
                super.onAdFailedToLoad(p0)
            }

            override fun onAdImpression() {
                super.onAdImpression()
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
            }

            override fun onAdOpened() {
                super.onAdOpened()
            }



        }


//        ------------------RewardedAd Loading ----------------
        RewardedAd.load(
           this.context,
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

        //        Setting Ad Fullscreen
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

        return view
        }





    override fun onBuyClicked() {

        //         ---------------- RewardAds Initialization Block

        //              Loading the Ad
        Toast.makeText(context, "ddd", Toast.LENGTH_LONG).show()


        if (mRewardedAd != null) {
            mRewardedAd?.show(activity,this)
            RewardedAd.load(
                this.context,
                "ca-app-pub-3940256099942544/5224354917",
                adRequest,
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        Log.d("error", adError?.message )
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


//        ------------------- Ads Initialization End-----------------------

    }

    override fun onUserEarnedReward(p0: RewardItem) {
//        TODO("Not yet implemented")
    }

//        TODO("Not yet implemented")
    }

