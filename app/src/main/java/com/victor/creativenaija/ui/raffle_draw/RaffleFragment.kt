package com.victor.creativenaija.ui.raffle_draw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.victor.creativenaija.R
import com.victor.creativenaija.adapters.RafflePlanAdapter
import com.victor.creativenaija.databinding.FragmentRaffleDrawBinding

class RaffleFragment : Fragment() {

    private lateinit var raffleViewModel: RaffleViewModel
    private var _binding:FragmentRaffleDrawBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        raffleViewModel =
                ViewModelProvider(this).get(RaffleViewModel::class.java)
        _binding = FragmentRaffleDrawBinding.inflate(layoutInflater,container,false)

//        val root = inflater.inflate(R.layout.fragment_raffle_draw, container, false)
//
        val view = binding.root

        val adapter = RafflePlanAdapter()
        binding.planRecycler.adapter = adapter


//        mAdManagerAdView = findViewById(R.id.adManagerAdView)

        val adRequest = AdManagerAdRequest.Builder().build()
        binding.adManagerAdView.loadAd(adRequest)

        binding.adManagerAdView.adListener = object : AdListener(){
            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdClosed() {

                super.onAdClosed()
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                Toast.makeText(context,p0.message,Toast.LENGTH_LONG).show()
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
        return view
    }
}