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

class RaffleFragment : Fragment() {

    private lateinit var raffleViewModel: RaffleViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        raffleViewModel =
                ViewModelProvider(this).get(RaffleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_raffle_draw, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        raffleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}