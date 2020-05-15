package com.example.izzun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.izzun.AdapterMedia.VideoAdapter

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 15 Mei 2020
 * 
 * */

/**
 * A simple [Fragment] subclass.
 */
class VideoFragment : Fragment() {

    lateinit var recyclervideo:RecyclerView
    var arrayList:ArrayList<ModelVideo> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_video, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclervideo = view.findViewById(R.id.recycler_video)
        var layoutManager = LinearLayoutManager(context)
        recyclervideo.layoutManager = layoutManager
        recyclervideo.setHasFixedSize(true)

        arrayList = ArrayList()
        var videoList = ModelVideo(" Avengers:Endgame Trailer","https://www.youtube.com/embed/TcMBFSGVi1c")
        arrayList.add(videoList)
        videoList = ModelVideo(" Civil War Trailer","https://www.youtube.com/embed/dKrVegVI0Us")
        arrayList.add(videoList)
        videoList = ModelVideo(" Venom Official Trailer","https://www.youtube.com/embed/u9Mv98Gr5pY")
        arrayList.add(videoList)
        videoList = ModelVideo(" The Way Back(2011) Trailer","https:/www.youtube.com/embed/OYUqhuLdwRM")
        arrayList.add(videoList)

        val mContext = activity!!.applicationContext
        val youtubeAdapter = VideoAdapter(arrayList, mContext)
        recyclervideo.adapter = youtubeAdapter
    }
}
