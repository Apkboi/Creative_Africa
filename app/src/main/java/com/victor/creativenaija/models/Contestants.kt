package com.victor.creativenaija.models

data class Contestants(
    val id: Int,
    val userId: Int,
    val contestId: Int,
    val votes: Int,
    val registrationDate: Long,
    var postLink:String


    ) {

    constructor(userId: Int, contestId: Int, votes: Int, registrationDate: Long,postLink: String) : this(
        0,
        userId,
        contestId,
        votes,
        registrationDate,
        postLink
    )

}