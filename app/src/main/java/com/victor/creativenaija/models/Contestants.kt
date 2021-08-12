package com.victor.creativenaija.models

data class Contestants(
    val id: Int,
    val userId: Int,
    val contestId: Int,
    val votes: Int,
    val registrationDate: Long,


    ) {

    constructor(userId: Int, contestId: Int, votes: Int, registrationDate: Long) : this(
        0,
        userId,
        contestId,
        votes,
        registrationDate
    )

}