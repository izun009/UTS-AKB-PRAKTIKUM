package com.example.izzun

import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.izzun.AdapterMedia.MusicAdapter
import kotlinx.android.synthetic.main.fragment_music.*

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 11 Mei 2020
 *
 * */

/**
 * A simple [Fragment] subclass.
 */
class MusicFragment : Fragment() {


    var MusicModelData:ArrayList<ModelMusic> = ArrayList()
    var MusicAdapter:MusicAdapter?=null
    val REQ_PICK_AUDIO = 1

    companion object{
        val PERMISSION_REQUEST_CODE = 12
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_music, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val Context = activity!!.applicationContext
        if(ContextCompat.checkSelfPermission(Context,android.Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity!!,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PERMISSION_REQUEST_CODE)
        }else{
            loadData()
        }
    }

    fun loadData(){
        val resolver = activity!!.contentResolver
        val mContext = activity!!.applicationContext
        var songCursor: Cursor? = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            null,null,null,null)
        while (songCursor!=null && songCursor.moveToNext()){
            var songName = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
            var songDuration = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.DURATION))
            var songPath = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.DATA))
            MusicModelData.add(ModelMusic(songName, songDuration, songPath))
        }
        MusicAdapter = MusicAdapter(MusicModelData,mContext)
        var layoutManager = LinearLayoutManager(mContext)
        recycler_music.layoutManager = layoutManager
        recycler_music.adapter = MusicAdapter
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_CODE){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(context,"Permission Granted",Toast.LENGTH_SHORT).show()
                loadData()
            }
        }
    }
}
