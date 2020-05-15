package com.example.izzun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 13 Mei 2020
 *
 * */

class AdapterGallery (private val list: List<ModelGallery>, val listener: (Int) -> Unit)
    : RecyclerView.Adapter<GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GalleryViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val gambar: ModelGallery = list[position]
        holder.bind(gambar, position, listener)
    }

    override fun getItemCount(): Int = list.size

}

//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast
//import androidx.recyclerview.widget.RecyclerView
//
//
//class AdapterGallery(var context: Context, var arrayList: ArrayList<ModelGallery>) :
//    RecyclerView.Adapter<AdapterGallery.ItemHolder>() {
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
//        val viewHolder = LayoutInflater.from(parent.context)
//            .inflate(R.layout.grid_layout_list_item, parent, false)
//        return ItemHolder(viewHolder)
//    }
//
//    override fun getItemCount(): Int {
//        return arrayList.size
//    }
//
//    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
//
//        val charItem: ModelGallery = arrayList.get(position)
//
//        holder.icons.setImageResource(charItem.icons!!)
//        holder.titles.text = charItem.alpha
//
//        holder.titles.setOnClickListener {
//            Toast.makeText(context, charItem.alpha, Toast.LENGTH_LONG).show()
//        }
//
//    }
//
//    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
//        var titles = itemView.findViewById<TextView>(R.id.alpha_text_view)
//
//    }
//}