package com.example.izzun.AdapterMedia

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.izzun.Interface.CustomItemClickListener
import com.example.izzun.ModelMusic
import com.example.izzun.R
import java.util.concurrent.TimeUnit

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 15 Mei 2020
 *
 * */

class MusicAdapter(ModelMusic:ArrayList<ModelMusic>, context: Context): RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    var mContext = context
    var mSongModel = ModelMusic
    var allMusicList:ArrayList<String> = ArrayList()
    var mp: MediaPlayer?=null

    companion object{
        val MUSICLIST = "musiclist"
        val MUSICITEMPOS = "pos"
    }

    override fun getItemCount(): Int {
        return  mSongModel.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_music,parent,false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        var model = mSongModel[position]
        var songName = model.mSongName
        var songDuration = toMandS(model.mSongDuration.toLong())

        holder.songTV.text = songName
        holder.durationTV.text = songDuration
        holder.setOnCustomItemClickListener(object : CustomItemClickListener {
            override fun onCustomItemClick(view: View, pos: Int) {
                for (i in 0 until mSongModel.size){
                    allMusicList.add(mSongModel[i].mSongPath)
                }

                Log.i("allmusiclist", allMusicList.toString())
                if (mp!=null){
                    mp!!.reset()
                    mp!!.stop()
                    mp!!.release()
                    mp = null
                    Toast.makeText(mContext,"Stopped", Toast.LENGTH_SHORT).show()
                }else{
                    mp = MediaPlayer()
                    mp!!.setDataSource(allMusicList[pos])
                    mp!!.prepareAsync()
                    mp!!.setOnPreparedListener{
                        mp!!.start()
                    }
                    Toast.makeText(mContext,"Playing : "+songName, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    fun toMandS(millis:Long):String{
        var duration = String.format("%02d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(millis),
            TimeUnit.MILLISECONDS.toSeconds(millis)- TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(millis)
            ))
        return duration
    }

    class MusicViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        var songTV: TextView
        var durationTV: TextView
        var albumnArt: ImageView
        var mCustomItemClickListener:CustomItemClickListener?=null
        init {
            songTV = itemView.findViewById(R.id.song_name)
            durationTV = itemView.findViewById(R.id.song_duration)
            albumnArt = itemView.findViewById(R.id.music_images)
            itemView.setOnClickListener(this)
        }
        fun setOnCustomItemClickListener(customItemClickListener:CustomItemClickListener){
            this.mCustomItemClickListener = customItemClickListener
        }
        override fun onClick(view: View?) {
            this.mCustomItemClickListener!!.onCustomItemClick(view!!,adapterPosition)
        }
    }
}