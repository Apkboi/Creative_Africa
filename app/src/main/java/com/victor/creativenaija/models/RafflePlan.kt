package com.victor.creativenaija.models

data  class RafflePlan(
    val id:Int,
    val planName:String,
    val bidPrice:Int,
    val winPrice:Int,

) { constructor( planName: String,bidPrice: Int,winPrice: Int) : this(0, planName, bidPrice,winPrice)
}