package com.example.izzun.AdapterMedia

import android.annotation.SuppressLint
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.izzun.R

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 15 Mei 2020
 *
 * */

class VideoViewHolder@SuppressLint("SetJavaScriptEnabled")
constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

    var webView: WebView
    var videoTitle: TextView

    init{
        webView = itemView.findViewById(R.id.video)
        videoTitle = itemView.findViewById(R.id.video_title)
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.settings.javaScriptEnabled = true
    }
}