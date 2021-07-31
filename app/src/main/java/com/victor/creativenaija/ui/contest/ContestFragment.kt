package com.victor.creativenaija.ui.contest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.victor.creativenaija.R
import com.victor.creativenaija.adapters.ContestsAdapter
import com.victor.creativenaija.databinding.FragmentContestBinding
import com.victor.creativenaija.databinding.FragmentHomeBinding
import com.victor.creativenaija.models.Contest

class ContestFragment : Fragment() {

    private lateinit var contestViewModel: ContestViewModel
    private var _binding: FragmentContestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(

            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        contestViewModel =
                ViewModelProvider(this).get(ContestViewModel::class.java)
        _binding = FragmentContestBinding.inflate(layoutInflater, container, false)
//        val root = inflater.inflate(R.layout.fragment_contest, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        contestViewModel.text.observe(viewLifecycleOwner, Observer {
////            textView.text = it
//        })
        val view = binding.root

        val adapter = ContestsAdapter()
        adapter.setContest(Contest(arrayListOf(),"ddd",67,7,4).getContests())
        binding.contestRecycler.adapter = adapter
        return view
    }
}