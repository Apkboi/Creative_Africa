package com.victor.creativenaija.interfaces

import com.victor.creativenaija.models.Post

interface PostInteractionListener {
    fun onPostClicked(post: Post)
}