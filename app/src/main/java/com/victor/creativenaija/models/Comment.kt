package com.victor.creativenaija.models

import com.victor.creativenaija.R

data class Comment(
    val id: Int,
    val posId: Int,
    val userId: Int,
    val comment: String,
    val time: Long
) {
    constructor(posId: Int, userId: Int, comment: String, time: Long) : this(
        0,
        posId,
        userId,
        comment,
        time
    )

    fun getComments(): ArrayList<Comment> {
        val comments: ArrayList<Comment> = arrayListOf()
        comments.add(
            Comment(
                1,
                1,
                "d,dlsmldkmdlsmldkmlakmakd \n dlsmldkmlakmakddlsmldkmlakmakdlakmakd",
                5665
            )
        )
        comments.add(
            Comment(
                1,
                1,
                "d,dlsmldkmlak  ,dlsmldkmdlsmldkml \n ,dlsmldkmdlsmldkml ,dlsmldkmdlsmldkml\n makd",
                5665
            )
        )
        comments.add(
            Comment(
                1, 1, "d,dls  d,dlsmldkmlak  ,dlsmldkmdlsmldkml \n" +
                        " ,dlsmldkmdlsmldkml ,dlsmldkmdlsmldkml\n" +
                        " makdmldkmlakmakd", 5665
            )
        )
        comments.add(
            Comment(
                1, 1, "d,dlsmld d,dlsmldkmlak  ,dlsmldkmdlsmldkml \n" +
                        " ,dlsmldkmdlsmldkml ,dlsmldkmdlsmldkml\n" +
                        " makdkmlakmakd", 5665
            )
        )
        return comments
    }
}