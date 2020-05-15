package com.example.izzun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_detail_gallery.view.*

/**
 * Nama : M Izzudin Wijaya
 * NIM  : 10117152
 * Waktu Pembuatan : 11 Mei 2020
 *
 * */

class GalleryViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_gallery, parent, false)) {

    fun bind(Picture: ModelGallery, pos: Int, listener: (Int) -> Unit) {

        val name  = Picture.nama
        val img  = Picture.image

        super.itemView
        itemView.setTag(this)
        itemView.apply {
            namaPicture?.text = Picture.nama
            Picasso.get().load(Picture.image).into(picture)
            itemView.setOnClickListener {

            }
        }
    }
}