package com.victor.creativenaija.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.material.button.MaterialButton
import com.victor.creativenaija.R
import com.victor.creativenaija.interfaces.BuyTicketListener
import com.victor.creativenaija.models.Contest
import com.victor.creativenaija.models.RafflePlan

class RafflePlanAdapter : RecyclerView.Adapter<RafflePlanAdapter.PlanListItemHolder>() {


    var plans: ArrayList<RafflePlan> = arrayListOf()

    val TAG = "RaffleAdapter"
    private var busBuyTicketListener:BuyTicketListener?=null

    fun setBuyTicketListener(buyTicketListener: BuyTicketListener){
        this.busBuyTicketListener = buyTicketListener
    }

    fun setContest(plans: ArrayList<RafflePlan>) {
        this.plans = plans

    }

    public class PlanListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanListItemHolder {
//        TODO("Not yet implemented")
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.raffle_layout, parent, false)
        return PlanListItemHolder(view)
    }

    override fun onBindViewHolder(holder: PlanListItemHolder, position: Int) {




        holder.itemView.findViewById<TextView>(R.id.txt_win).setText("WIN")
        val btn_buy: MaterialButton =
            holder.itemView.findViewById<MaterialButton>(R.id.btn_buyTicket)
        btn_buy.setOnClickListener {
            //              Loading the Ad

            busBuyTicketListener?.onBuyClicked()


        }
//        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
        return 2
    }
}