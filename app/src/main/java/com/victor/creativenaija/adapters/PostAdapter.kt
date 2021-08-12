package com.victor.creativenaija.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.exoplayer2.util.Log
import com.google.android.exoplayer2.util.Util
import com.victor.creativenaija.PostActivity
import com.victor.creativenaija.R
import com.victor.creativenaija.interfaces.PostInteractionListener
import com.victor.creativenaija.models.Post


class PostAdapter : RecyclerView.Adapter<PostAdapter.PostItemHolder>() {


    private var context: Context? = null

    var posts: ArrayList<Post> = arrayListOf()

//    var playerView: StyledPlayerView? = null


    public fun setPost(posts: ArrayList<Post>) {
        this.posts = posts
    }

    var postInteractionListener: PostInteractionListener? = null

    //
    @JvmName("setAdapterViewListener1")
    fun setPostInteractionListener(postInteractionListener: PostInteractionListener) {
        this.postInteractionListener = postInteractionListener
    }


    public class PostItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val playerView: StyledPlayerView =
            itemView.findViewById<StyledPlayerView>(R.id.video_view)
        var simpleExoPlayer: SimpleExoPlayer? = null
        private var playbackPosition: Long = 0
        private var currentWindow = 0
        private var playWhenReady = false


        fun initializePlayer() {


            simpleExoPlayer =
                ExoPlayerFactory.newSimpleInstance(
                    itemView.context,
                    DefaultRenderersFactory(itemView.context),
                    DefaultTrackSelector(),
                    DefaultLoadControl()
                )

            playerView.player = simpleExoPlayer
            simpleExoPlayer!!.playWhenReady = false

            val defaultDataSourceFactory =
                DefaultDataSourceFactory(
                    itemView.context,
                    Util.getUserAgent(itemView.context, "yourApplicationName")
                )
            val extractorMediaSource = ExtractorMediaSource.Factory(defaultDataSourceFactory)
//                .createMediaSource(RawResourceDataSource.buildRawResourceUri(R.raw.cats))
//            simpleExoPlayer!!.prepare(extractorMediaSource)
            simpleExoPlayer!!.pause()

        }

        fun isPlaying(): Boolean {
            return simpleExoPlayer != null &&
                    simpleExoPlayer!!.getPlaybackState() !== Player.STATE_ENDED &&
                    simpleExoPlayer!!.getPlaybackState() !== Player.STATE_IDLE &&
                    simpleExoPlayer!!.getPlayWhenReady()
        }

        fun releasePlayer() {
            if (simpleExoPlayer != null) {


                playbackPosition = simpleExoPlayer!!.getCurrentPosition()
                currentWindow = simpleExoPlayer!!.getCurrentWindowIndex()
                playWhenReady = simpleExoPlayer!!.getPlayWhenReady()
                simpleExoPlayer?.release()
                simpleExoPlayer = null
            }

        }

        fun stopPlayer() {
            if (isPlaying()) {
                simpleExoPlayer?.pause()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.post_layout, parent, false)

        return PostItemHolder(view)
    }

    override fun onBindViewHolder(holder: PostItemHolder, position: Int) {
//        TODO("Not yet implemented")

        if (holder.isPlaying()) {
            Log.e("TAG1", "play");
            holder.releasePlayer();
//            holder.initializePlayer();
        } else {
            Log.e("TAG1", "empty");
//            holder.initializePlayer();
        }


        holder.itemView.findViewById<TextView>(R.id.txtPostText).setText(posts[position].postText)
        holder.itemView.setOnClickListener {


            holder.simpleExoPlayer?.stop()

            postInteractionListener?.onPostClicked(posts[position])
        }

    }

    override fun getItemCount(): Int {
        return posts.size
//        TODO("Not yet implemented")
    }


//    fun initializePlayer() {
//        player = SimpleExoPlayer.Builder(holder.itemView.context)
//            .build()
//            .also { exoPlayer ->
//                holder.itemView.findViewById<StyledPlayerView>(R.id.video_view).player = exoPlayer
////                    val mediaItem = MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp4")
////                    exoPlayer.setMediaItem(mediaItem)
////                    exoPlayer.playWhenReady = playWhenReady
//                exoPlayer.seekTo(currentWindow, playbackPosition)
//
//
//                val defaultDataSourceFactory =
//                    DefaultDataSourceFactory(holder.itemView.context, Util.getUserAgent(holder.itemView.context, "yourApplicationName"))
//                exoPlayer.setPlayWhenReady(false)
//                val extractorMediaSource = ExtractorMediaSource.Factory(defaultDataSourceFactory)
//                    .createMediaSource(RawResourceDataSource.buildRawResourceUri(R.raw.cats))
//                exoPlayer.prepare(extractorMediaSource)
////                    exoPlayer.prepare()
//
//            }
//
//    }


}