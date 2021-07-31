package com.victor.creativenaija.models

import java.io.Serializable

data class Post(
    val id: Int,
    val posterId: Int,
    val image: String,
    val postDate: Long,
    val videoUri: String,
    val postText: String
):Serializable {
    constructor(
        posterId: Int,
        image: String,
        postDate: Long,
        videoUri: String,
        postText: String
    ) : this(0, posterId, image, postDate, videoUri, postText)

    fun getPosts(): ArrayList<Post> {
        val posts: ArrayList<Post> = arrayListOf()
        posts.add(Post(4, "sd", 4567765, "dmnbvcv", "hdkhcdcdcdc"))
        posts.add(Post(4, "sd", 4567765, "dmnbvcv", "hdkhcdcdcdc"))
        posts.add(Post(4, "sd", 4567765, "dmnbvcv", "hdkhcdcdcdc"))
        posts.add(Post(4, "sd", 4567765, "dmnbvcv", "hdkhcdcdcdc"))
        posts.add(Post(4, "sd", 4567765, "dmnbvcv", "hdkhcdcdcdc"))
        return posts
    }
//    constructor() : this()

}