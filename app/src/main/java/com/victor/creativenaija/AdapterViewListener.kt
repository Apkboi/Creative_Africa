package com.victor.creativenaija

import android.view.View
import com.victor.creativenaija.adapters.PostAdapter

interface AdapterViewListener {
    fun onCreate(postItemHolder: PostAdapter.PostItemHolder)
}