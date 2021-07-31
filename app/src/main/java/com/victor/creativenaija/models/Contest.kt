package com.victor.creativenaija.models

data class Contest(
    val id: Int,
    val contestants: ArrayList<Contestants>,
    val contestDetails: String,
    val startDate: Long,
    val endDate: Long,
    val winnerId: Int
) {
    constructor(
        contestants: ArrayList<Contestants>,
        contestDetails: String,
        startDate: Long,
        endDate: Long,
        winnerId: Int
    ) : this(0, contestants, contestDetails, startDate, endDate, winnerId)

    fun getContests(): ArrayList<Contest> {
        val contests: ArrayList<Contest> = arrayListOf()
        contests.add(Contest(arrayListOf(), "kdddkkdkd", 4567, 4567, 7))
        contests.add(Contest(arrayListOf(), "kdddkkdkd", 4567, 4567, 7))
        contests.add(Contest(arrayListOf(), "kdddkkdkd", 4567, 4567, 7))
        contests.add(Contest(arrayListOf(), "kdddkkdkd", 4567, 4567, 7))
        return contests
    }
}