package com.victor.creativenaija.ui.raffle_draw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
        return view
    }
}