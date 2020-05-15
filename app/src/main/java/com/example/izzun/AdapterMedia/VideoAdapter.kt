package com.example.izzun.AdapterMedia

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.izzun.ModelVideo
import com.example.izzun.R

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 15 Mei 2020
 *
 * */

class VideoAdapter (val list: ArrayList<ModelVideo>, context: Context): RecyclerView.Adapter<VideoViewHolder>() {

    var aContext = context

    override fun onCreateViewHolder(viewGroup: ViewGroup, pos:Int):VideoViewHolder {
        val view = LayoutInflater.from(aContext).inflate(R.layout.item_video, viewGroup, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(youtube:VideoViewHolder, pos:Int) {
        val current: ModelVideo = list[pos]
        youtube.webView.loadUrl(current.mVideoUrl)
        youtube.videoTitle.text = current.mVideoTitle
    }

    override fun getItemCount(): Int = list.size
}