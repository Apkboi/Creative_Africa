package com.victor.creativenaija.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.exoplayer2.util.Util
import com.victor.creativenaija.AdapterViewListener
import com.victor.creativenaija.PostActivity
import com.victor.creativenaija.R
import com.victor.creativenaija.adapters.PostAdapter
import com.victor.creativenaija.databinding.FragmentHomeBinding
import com.victor.creativenaija.interfaces.PostInteractionListener
import com.victor.creativenaija.models.Post

class HomeFragment : Fragment(),PostInteractionListener {

    private lateinit var homeViewModel: HomeViewModel
    private  var _view: PostAdapter.PostItemHolder? = null
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var player: SimpleExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val view = binding.root

        val adapter = PostAdapter()
        adapter.setPostInteractionListener(this)


        adapter.setPost(Post(5, "z", 776, "", "").getPosts())
        binding.postsRecycler.adapter = adapter

        return view
    }

    override fun onPostClicked(post: Post) {
        val intent:Intent = Intent(context,PostActivity::class.java)

        intent.putExtra("post",post)
        startActivity(intent)
    }

//    override fun onCreate(postItemHolder: PostAdapter.PostItemHolder) {
//        _view = postItemHolder
//        _view!!.itemView.findViewById<TextView>(R.id.txtPostText).setText("ghkldd")
//
//
//
//
//    }
//
//    private fun initializePlayer(context: Context) {
//        player = SimpleExoPlayer.Builder(context)
//            .build()
//            .also { exoPlayer ->
//                _view?.itemView?.findViewById<StyledPlayerView>(R.id.video_view)?.player = exoPlayer
////                    val mediaItem = MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/play.mp4")
////                    exoPlayer.setMediaItem(mediaItem)
////                    exoPlayer.playWhenReady = playWhenReady
//                exoPlayer.seekTo(currentWindow, playbackPosition)
//
//
//                val defaultDataSourceFactory =
//                    DefaultDataSourceFactory(
//                        context,
//                        Util.getUserAgent(context, "yourApplicationName")
//                    )
//                exoPlayer.setPlayWhenReady(true)
//                val extractorMediaSource =
//                    ExtractorMediaSource.Factory(defaultDataSourceFactory)
//                        .createMediaSource(RawResourceDataSource.buildRawResourceUri(R.raw.cats))
//                exoPlayer.prepare(extractorMediaSource)
////                    exoPlayer.prepare()
//
//            }
//
//    }
//
//    public override fun onStart() {
//        super.onStart()
//        if (Util.SDK_INT >= 24&& _view != null) {
//            context?.let { initializePlayer(it) }
//        }
//    }
//
//    public override fun onResume() {
//        super.onResume()
//        hideSystemUi()
//        if ((Util.SDK_INT < 24 || player == null)) {
//            context?.let { initializePlayer(it) }
//        }
//    }
//    public override fun onStop() {
//        super.onStop()
//        if (Util.SDK_INT >= 24) {
//            releasePlayer()
//        }
//    }
//    public override fun onPause() {
//        super.onPause()
//        if (Util.SDK_INT < 24) {
//            releasePlayer()
//        }
//    }
//
//    @SuppressLint("InlinedApi")
//    private fun hideSystemUi() {
//        if (_view != null) {
//            _view?.itemView?.findViewById<StyledPlayerView>(R.id.video_view)?.systemUiVisibility =
//                (View.SYSTEM_UI_FLAG_LOW_PROFILE
//                        or View.SYSTEM_UI_FLAG_FULLSCREEN
//                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
//        }
//    }
//
//
//
//
//
//
//    private fun releasePlayer() {
//        player?.run {
//            playbackPosition = this.currentPosition
//            currentWindow = this.currentWindowIndex
//            playWhenReady = this.playWhenReady
//            release()
//        }
//        player = null
//    }

}