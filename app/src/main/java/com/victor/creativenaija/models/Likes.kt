package com.victor.creativenaija.models

data class Likes(
    val id: Int,
    val postId: Int,
    val userId: Int
) {
    constructor(postId: Int, userId: Int) : this(0, postId, userId)
}